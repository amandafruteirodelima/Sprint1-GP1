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

    public HistoricoDiscoEntity(Double armazenamento) {
        this.armazenamento = armazenamento;
    }
    
    public void insertHistoricoDisco() {       
        assistente.update("INSERT INTO HISTORICODISCO VALUES(?,?,?)", null,
                armazenamento,formatter.format(date));
        System.out.println(assistente.queryForList(
                "SELECT * FROM HISTORICODISCO"));
    }

    public Double getArmazenamento() {
        return armazenamento;
    }
}
