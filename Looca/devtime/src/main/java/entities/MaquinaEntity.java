package entities;

import com.mycompany.devtime.ConfiguracaoBanco;
import org.springframework.jdbc.core.JdbcTemplate;

public class MaquinaEntity {

    private Integer idMaquina;
    private String sistemaOperacional;
    private Integer arquiteturaSO;
    private String fabricanteSO;
    private Integer fkFuncionario;

    ConfiguracaoBanco configuracaoBanco = new ConfiguracaoBanco();
    JdbcTemplate assistente = new JdbcTemplate(
            configuracaoBanco.getBancoDeDados());

    public MaquinaEntity(String sistemaOperacional, Integer arquiteturaSO, 
            String fabricanteSO) {
        this.sistemaOperacional = sistemaOperacional;
        this.arquiteturaSO = arquiteturaSO;
        this.fabricanteSO = fabricanteSO;
    }
    
    public void insertMaquina() {
        
        assistente.update("INSERT INTO MAQUINA VALUES(?,?,?,?)", null,
                sistemaOperacional, arquiteturaSO, fabricanteSO); 
        System.out.println(assistente.queryForList("SELECT * FROM maquina"));
    }

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }

    public void setSistemaOperacional(String sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }

    public Integer getArquiteturaSO() {
        return arquiteturaSO;
    }

    public void setArquiteturaSO(Integer arquiteturaSO) {
        this.arquiteturaSO = arquiteturaSO;
    }

    public String getFabricanteSO() {
        return fabricanteSO;
    }

    public void setFabricanteSO(String fabricanteSO) {
        this.fabricanteSO = fabricanteSO;
    }

}
