package entities;

import com.mycompany.devtime.ConfiguracaoBanco;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.jdbc.core.JdbcTemplate;

public class HistoricoRamEntity {
    
    private Double usoRam;
    private Double disponivel;
    private Integer fkRam;

    ConfiguracaoBanco configuracaoBanco = new ConfiguracaoBanco();
    JdbcTemplate assistente = new JdbcTemplate(
            configuracaoBanco.getBancoDeDados());

    SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
    Date date = new Date();

    public HistoricoRamEntity(Double usoRam, Double disponivel, Integer fkRam) {
        this.usoRam = usoRam;
        this.disponivel = disponivel;
        this.fkRam = fkRam;
    }

    public void insertHistoricoRam() {
        assistente.update("INSERT INTO HISTORICO_RAM VALUES(?,?,?,?,?)", null,
                usoRam, disponivel, formatter.format(date), fkRam);
    }
}
