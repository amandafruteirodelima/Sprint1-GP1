package entities;

import com.mycompany.devtime.ConfiguracaoBanco;
import java.text.DecimalFormat;
import org.springframework.jdbc.core.JdbcTemplate;

public class ProcessadorEntity {
    private Integer idProcessador;
    private String fabricante;
    private String nomeProcessador;
    private Long frequencia;
    private Integer numeroCPUs;
    private Integer fkMaquina;
    
    
    ConfiguracaoBanco configuracaoBanco = new ConfiguracaoBanco();
    JdbcTemplate assistente = new JdbcTemplate(
            configuracaoBanco.getBancoDeDados());

    public ProcessadorEntity(String fabricante, String nomeProcessador, 
            Long frequencia, Integer numeroCPUs) {
        this.fabricante = fabricante;
        this.nomeProcessador = nomeProcessador;
        this.frequencia = frequencia;
        this.numeroCPUs = numeroCPUs;
    }
    
    public void insertProcessador(){
        assistente.update("INSERT INTO PROCESSADOR VALUES(?,?,?,?,?)", null,
                fabricante, nomeProcessador, frequencia, numeroCPUs);
        System.out.println(assistente.queryForList("SELECT * FROM PROCESSADOR"));
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getNomeProcessador() {
        return nomeProcessador;
    }

    public void setNomeProcessador(String nomeProcessador) {
        this.nomeProcessador = nomeProcessador;
    }

    public Long getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(Long frequencia) {
        this.frequencia = frequencia;
    }

    public Integer getNumeroCPUs() {
        return numeroCPUs;
    }

    public void setNumeroCPUs(Integer numeroCPUs) {
        this.numeroCPUs = numeroCPUs;
    }
    
}
