package entities;

import com.mycompany.devtime.ConfiguracaoBanco;

import java.text.SimpleDateFormat;
import java.util.Date;
import logging.LogErro;
import org.springframework.jdbc.core.JdbcTemplate;

public class HistoricoUsoSoftwareEntity {

    private Integer idHistoricoUsoSoftware;
    private Date dataHora;
    private Double consumo;
    private Integer fk_Software;
    private Integer fk_Maquina;

    LogErro logErro = new LogErro();
    ConfiguracaoBanco configuracaoBanco = new ConfiguracaoBanco();
    JdbcTemplate assistente = new JdbcTemplate(
            configuracaoBanco.getBancoDeDados());


    SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
    Date date = new Date();

    public HistoricoUsoSoftwareEntity(Double consumo, Integer fk_Software, Integer fk_Maquina) {
        this.consumo = consumo;
        this.fk_Software = fk_Software;
        this.fk_Maquina = fk_Maquina;
    }

    public void insertHistoricoUsoSoftware() {

        try {
            assistente.update("INSERT INTO Historico_Uso_Software(dataHora, "
                    + "consumo, fk_software, fk_maquina) "
                    + "VALUES(?,?,?,?)",
                    formatter.format(date), consumo, fk_Software, fk_Maquina);

        } catch (Exception erro) {
            logErro.mensagemErroInsert(erro);
        }
    }

}
