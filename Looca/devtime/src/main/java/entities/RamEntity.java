package entities;

import com.mycompany.devtime.ConfiguracaoBanco;
import org.springframework.jdbc.core.JdbcTemplate;

public class RamEntity {
    private Integer idRam;
    private Double total;
    private Integer fkMaquina;
    
        ConfiguracaoBanco configuracaoBanco = new ConfiguracaoBanco();
    JdbcTemplate assistente = new JdbcTemplate(
            configuracaoBanco.getBancoDeDados());
    
    public void insertRam(){
        
        assistente.update("INSERT INTO RAM VALUES(?,?)", null,
                total);
        System.out.println(assistente.queryForList("SELECT * FROM RAM"));
    }

    public RamEntity(Double total) {
        this.total = total;
    }

}
