package entities;

import com.mycompany.devtime.ConfiguracaoBanco;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.jdbc.core.JdbcTemplate;

public class HistoricoProcessadorEntity {

    private Integer idHistoricoProcessador;
    private Double usoProcessador;
    private Integer fkProcessador;

    ConfiguracaoBanco configuracaoBanco = new ConfiguracaoBanco();
    JdbcTemplate assistente = new JdbcTemplate(
            configuracaoBanco.getBancoDeDados());

    SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
    Date date = new Date();

    public HistoricoProcessadorEntity(Double usoProcessador) {
        this.usoProcessador = usoProcessador;
    }

    public void insertHistoricoProcessador() {
        assistente.update("INSERT INTO HISTORICO_PROCESSADOR VALUES(?,?,?)",
                null, usoProcessador, formatter.format(date));
        System.out.println(assistente.queryForList(
                "SELECT * FROM HISTORICO_PROCESSADOR"));
    }

    public Double getUsoProcessador() {
        return usoProcessador;
    }

    public void setUsoProcessador(Double usoProcessador) {
        this.usoProcessador = usoProcessador;
    }

}
