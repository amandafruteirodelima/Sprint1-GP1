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

    public RamEntity(Double total, Integer fkMaquina) {
        this.total = total;
        this.fkMaquina = fkMaquina;
    }

    public RamEntity() {
    }

    private static RamEntity instance = new RamEntity();

    public static RamEntity getInstance() {
        return instance;
    }

    public void insertRam() {

        assistente.update("INSERT INTO RAM VALUES(?,?,?)", null,
                total, fkMaquina);
        System.out.println(assistente.queryForList("SELECT * FROM RAM"));
    }

    public Integer getIdRam() {
        return idRam;
    }

    public void setIdRam(Integer idRam) {
        this.idRam = idRam;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getFkMaquina() {
        return fkMaquina;
    }

    public void setFkMaquina(Integer fkMaquina) {
        this.fkMaquina = fkMaquina;
    }

    

}
