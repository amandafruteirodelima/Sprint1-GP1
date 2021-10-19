package entities;

import com.mycompany.devtime.ConfiguracaoBanco;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.jdbc.core.JdbcTemplate;

public class HistoricoDiscoEntity {

    private Integer idHistoricoDisco;
    private Double armazenamento;
    private Integer fkDisco;

    ConfiguracaoBanco configuracaoBanco = new ConfiguracaoBanco();
    JdbcTemplate assistente = new JdbcTemplate(
            configuracaoBanco.getBancoDeDados());

    SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
    Date date = new Date();

    public HistoricoDiscoEntity(Double armazenamento, Integer fkDisco) {
        this.armazenamento = armazenamento;
        this.fkDisco = fkDisco;
    }

    public void insertHistoricoDisco() {
        assistente.update("INSERT INTO HISTORICO_DISCO(ArmazenamentoDisco, "
                + "DataHora, fk_Disco) VALUES(?,?,?)",
                armazenamento, formatter.format(date), fkDisco);
    }

}
