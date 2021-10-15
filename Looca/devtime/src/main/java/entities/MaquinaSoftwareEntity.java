package entities;

import com.mycompany.devtime.ConfiguracaoBanco;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.jdbc.core.JdbcTemplate;

public class MaquinaSoftwareEntity {

    private Double usoCPUSoftware;
    private Double usoRAMSoftware;

    ConfiguracaoBanco configuracaoBanco = new ConfiguracaoBanco();
    JdbcTemplate assistente = new JdbcTemplate(
            configuracaoBanco.getBancoDeDados());

    SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
    Date date = new Date();

    public MaquinaSoftwareEntity(Double usoCPUSoftware, Double usoRAMSoftware) {
        this.usoCPUSoftware = usoCPUSoftware;
        this.usoRAMSoftware = usoRAMSoftware;
    }

    public void insertMaquinaSoftware() {
        assistente.update("INSERT INTO MAQUINA_SOFTWARE VALUES(?,?,?,?)", 
                null, usoCPUSoftware, usoRAMSoftware, formatter.format(date));
        System.out.println(assistente.queryForList(
                "SELECT * FROM MAQUINA_SOFTWARE"));
    }

}
