package entities;

import com.mycompany.devtime.ConfiguracaoBanco;
import org.springframework.jdbc.core.JdbcTemplate;

public class ProcessadorEntity {
    private Integer idProcessador;
    private String fabricante;
    private String nomeProcessador;
    private Double frequencia;
    private Integer numeroCPUs;
    private Integer fkMaquina;
}
