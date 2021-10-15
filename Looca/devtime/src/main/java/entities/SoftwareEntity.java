package entities;

import com.mycompany.devtime.ConfiguracaoBanco;
import org.springframework.jdbc.core.JdbcTemplate;

public class SoftwareEntity {

    private String nomeSoftware;

    ConfiguracaoBanco configuracaoBanco = new ConfiguracaoBanco();
    JdbcTemplate assistente = new JdbcTemplate(
            configuracaoBanco.getBancoDeDados());

    public SoftwareEntity(String nomeSoftware) {
        this.nomeSoftware = nomeSoftware;
    }
    
    public void insertSoftware(){
        assistente.update("INSERT INTO SOFTWARE VALUES(?,?)", 
                null, nomeSoftware);
        System.out.println(assistente.queryForList(
                "SELECT * FROM SOFTWARE"));
    }
}
