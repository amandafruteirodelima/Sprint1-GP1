package entities;

import com.mycompany.devtime.ConfiguracaoBanco;
import org.springframework.jdbc.core.JdbcTemplate;

public class RamEntity {
    private Integer idRam;
    private Double Total;
    private Integer fkMaquina;
}
