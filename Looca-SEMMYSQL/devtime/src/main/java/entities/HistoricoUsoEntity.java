package entities;

import com.mycompany.devtime.ConfiguracaoBanco;
import java.text.SimpleDateFormat;
import java.util.Date;
import logging.LogErro;
import org.springframework.jdbc.core.JdbcTemplate;

public class HistoricoUsoEntity {

    private Integer idHistoricoUso;
    private Integer fkComponente;
    private Double consumo;

    LogErro logErro = new LogErro();
    ConfiguracaoBanco configuracaoBanco = new ConfiguracaoBanco();
    JdbcTemplate assistente = new JdbcTemplate(
            configuracaoBanco.getBancoDeDados());



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
        } catch (Exception erro) {
            logErro.mensagemErroInsert(erro);
        }
    }

}
