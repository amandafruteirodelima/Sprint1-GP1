package entities;

import com.mycompany.devtime.ConfiguracaoBanco;
import com.mycompany.devtime.ConfiguracaoBancoMySql;
import java.text.SimpleDateFormat;
import java.util.Date;
import logging.LogErro;
import org.springframework.jdbc.core.JdbcTemplate;
import slack.IntegracaoSlack;

public class HistoricoUsoEntity {

    private Integer idHistoricoUso;
    private Integer fkComponente;
    private Double consumo;

    LogErro logErro = new LogErro();
    ConfiguracaoBanco configuracaoBanco = new ConfiguracaoBanco();
    JdbcTemplate assistente = new JdbcTemplate(
            configuracaoBanco.getBancoDeDados());

    ConfiguracaoBancoMySql configuracaoBancoMySql = new ConfiguracaoBancoMySql();
    JdbcTemplate assistenteMySql = new JdbcTemplate(
            configuracaoBancoMySql.getBancoDeDadosMySql());
    
    IntegracaoSlack integracao = new IntegracaoSlack();
    
    SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
    Date date = new Date();

    public HistoricoUsoEntity(Integer fkComponente, Double consumo) {
        this.fkComponente = fkComponente;
        this.consumo = consumo;
    }

    public void insertHistorico() {

        try {
            assistente.update("INSERT INTO HISTORICO_USO(fk_Componente, dataHora, "
                    + "consumo) VALUES(?,?,?)",
                    fkComponente, formatter.format(date), consumo);
            System.out.println("Inserindo os dados do Histórico Uso no SQL");
            
            integracao.pegarDadosDisco(consumo, fkComponente);
            
        } catch (Exception erro) {
            logErro.mensagemErroInsert(erro);
        }
    }
     public void insertHistoricoMySql() {
        System.out.println("Inserindo os dados do Histórico Uso no MySQL");
         System.out.println(String.format("%d, %d, %s, %.2f", idHistoricoUso,fkComponente,formatter.format(date),consumo));
        assistenteMySql.update("INSERT INTO Historico_Uso(fk_Componente, dataHora, "
                + "consumo) VALUES(?,?,?)",
                fkComponente, formatter.format(date), consumo);
        System.out.println(String.format("%d, %d, %s, %.2f", idHistoricoUso,fkComponente,formatter.format(date),consumo));
        System.out.println("Dados inseridos no Histórico Uso no MySQL");
    }

    public Double getConsumo() {
        return consumo;
    }
}
