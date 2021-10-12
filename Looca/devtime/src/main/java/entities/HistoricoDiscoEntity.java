package entities;

import com.mycompany.devtime.ConfiguracaoBanco;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.jdbc.core.JdbcTemplate;

public class HistoricoDiscoEntity {
    private Integer idHistoricoDisco;
    private Long Armazenamento;
    private Integer fkDisco;
    
    ConfiguracaoBanco configuracaoBanco = new ConfiguracaoBanco();
    JdbcTemplate assistente = new JdbcTemplate(
            configuracaoBanco.getBancoDeDados());
    SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
    Date date = new Date();

    public HistoricoDiscoEntity(Long Armazenamento) {
        this.Armazenamento = Armazenamento;
    }
    
    public void insertHistoricoDisco() {
        Double conversor =  Armazenamento / Math.pow(10, 9);
        assistente.update("INSERT INTO HISTORICODISCO VALUES(?,?,?)", null,
                conversor,formatter.format(date));
        System.out.println(assistente.queryForList(
                "SELECT * FROM HISTORICODISCO"));
    }

    public Long getArmazenamento() {
        return Armazenamento;
    }
}
