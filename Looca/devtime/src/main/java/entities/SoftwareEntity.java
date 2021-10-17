package entities;

import com.mycompany.devtime.ConfiguracaoBanco;
import org.springframework.jdbc.core.JdbcTemplate;

public class SoftwareEntity {

    private Integer idSoftware;
    private String nomeSoftware;

    ConfiguracaoBanco configuracaoBanco = new ConfiguracaoBanco();
    JdbcTemplate assistente = new JdbcTemplate(
            configuracaoBanco.getBancoDeDados());

    public SoftwareEntity(String nomeSoftware) {
        this.nomeSoftware = nomeSoftware;
    }

    public SoftwareEntity() {
    }

    private static SoftwareEntity instance = new SoftwareEntity();

    public static SoftwareEntity getInstance() {
        return instance;
    }

    public void insertSoftware() {
        assistente.update("INSERT INTO SOFTWARES VALUES(?,?)",
                null, nomeSoftware);
    }

    public Integer getIdSoftware() {
        return idSoftware;
    }

    public void setIdSoftware(Integer idSoftware) {
        this.idSoftware = idSoftware;
    }

    public String getNomeSoftware() {
        return nomeSoftware;
    }

    public void setNomeSoftware(String nomeSoftware) {
        this.nomeSoftware = nomeSoftware;
    }

    
}
