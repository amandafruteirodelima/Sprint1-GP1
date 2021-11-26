package entities;

import com.mycompany.devtime.ConfiguracaoBanco;
import com.mycompany.devtime.ConfiguracaoBancoMySql;
import org.springframework.jdbc.core.JdbcTemplate;

public class SoftwareEntity {

    private Integer idSoftware;
    private String nomeSoftware;

    ConfiguracaoBanco configuracaoBanco = new ConfiguracaoBanco();
    
    JdbcTemplate assistente = new JdbcTemplate(
            configuracaoBanco.getBancoDeDados());

    ConfiguracaoBancoMySql configuracaoBancoMySql = new ConfiguracaoBancoMySql();
    
    JdbcTemplate assistenteMySql = new JdbcTemplate(
            configuracaoBancoMySql.getBancoDeDadosMySql());

    public SoftwareEntity(String nomeSoftware) {
        this.nomeSoftware = nomeSoftware;
    }

    public SoftwareEntity() {
    }

    public void insertSoftware() {
        
            assistente.update("INSERT INTO Software(nomeSoftware)"
                    + " VALUES(?)",
                    nomeSoftware);

       
    }

   public void insertSoftwareMySql() {;
        
            assistenteMySql.update("INSERT INTO Software(nomeSoftware)"
                    + " VALUES(?)",
                  nomeSoftware);
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
