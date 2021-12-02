package slack;

import com.github.seratch.jslack.Slack;
import com.github.seratch.jslack.api.webhook.Payload;
import com.github.seratch.jslack.api.webhook.WebhookResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import logging.LogErro;

public class IntegracaoSlack {

    private String webHooksURL = "https://hooks.slack.com/services/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";
    private String token = "xoxb-2750374347075-2762998716865-cQwcWCBDuk6FMP08ey8PMUBV";
    private String canalSlack = "historico-registro";

    LogErro erro = new LogErro();
    
    public void enviarMensagem(String mensagem) {
        try {
            StringBuilder mensagemBuilder = new StringBuilder();

            mensagemBuilder.append(mensagem);

            Payload payload = Payload.builder().channel(canalSlack).text(mensagemBuilder.toString()).build();

            WebhookResponse wbResp = Slack.getInstance().send(webHooksURL, payload);
            
            System.out.println("FIM");
        } catch (Exception e) {
            erro.mensagemErroInsert(e);
            System.out.println("FIM");
        }
    }

    public void pegarDadosDisco(Double consumo, Integer idComponente) {

        try {
            String url = "jdbc:sqlserver://servidor-grupo1-devtime.database.windows.net:1433;database=grupo1-Devtime;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net";
            Connection conexao = DriverManager.getConnection(url, "Grupo01", "@#grupo1");

            PreparedStatement capacidadeComponente = conexao.prepareStatement("select * from [dbo].[Funcionario] \n"
                    + "join [dbo].[Maquina] "
                    + "on fk_Funcionario = idFuncionario "
                    + "join [dbo].[Componente] "
                    + "on idMaquina = fk_Maquina "
                    + "where idComponente = " + idComponente);

            ResultSet resultadoComponenteCapacidade = capacidadeComponente.executeQuery();

            Double capacidadeTotal = 0.0;
            String capacidade = "";
            String nomeUsuario = "";
            String nomeComponente = "";
            String descComponente = "";

            while (resultadoComponenteCapacidade.next()) {;
                nomeUsuario = resultadoComponenteCapacidade.getString("nomeFuncionario");
                nomeComponente = resultadoComponenteCapacidade.getString("nomeComponente");
                capacidade = resultadoComponenteCapacidade.getString("capacidade");
                descComponente = resultadoComponenteCapacidade.getString("descricao");
            }
            
            String numCapacidadeCortado = capacidade.substring(0, 3);
            capacidadeTotal = (Double.parseDouble(numCapacidadeCortado) * 100) / consumo;

            if (capacidadeTotal >= 70.0) {
                String infoSlack = String.format("\n\nALERTA \nFuncionário %s "
                        + "\nO componente ( %s ) está sendo muito utilizado. "
                        + "\nEstá sendo usado %.1f%% do limite total. "
                        + "\nDescrição do Componente %s %s",
                        nomeUsuario,
                        nomeComponente,
                        capacidadeTotal,
                        nomeComponente,
                        descComponente);
                System.out.println(infoSlack);
                enviarMensagem(infoSlack);
            }
        } 
        catch (Exception e) {
            erro.mensagemErroInsert(e);
            System.out.println("FIM");
        }
    }
}