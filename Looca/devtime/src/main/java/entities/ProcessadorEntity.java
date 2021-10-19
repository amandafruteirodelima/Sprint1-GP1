package entities;

import com.mycompany.devtime.ConfiguracaoBanco;
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
            Long frequencia, Integer numeroCPUs, Integer fkMaquina) {
        this.fabricante = fabricante;
        this.nomeProcessador = nomeProcessador;
        this.frequencia = frequencia;
        this.numeroCPUs = numeroCPUs;
        this.fkMaquina = fkMaquina;
    }

    public ProcessadorEntity() {
    }

    private static ProcessadorEntity instance = new ProcessadorEntity();

    public static ProcessadorEntity getInstance() {
        return instance;
    }

    public void insertProcessador() {
        assistente.update("INSERT INTO PROCESSADOR(fabricante, nomeProcessador, "
                + "frequencia, numeroCPU, fk_Maquina) VALUES(?,?,?,?,?)",
                fabricante, nomeProcessador, frequencia, numeroCPUs, fkMaquina);
    }

    public Integer getIdProcessador() {
        return idProcessador;
    }

    public void setIdProcessador(Integer idProcessador) {
        this.idProcessador = idProcessador;
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

    public Integer getFkMaquina() {
        return fkMaquina;
    }

    public void setFkMaquina(Integer fkMaquina) {
        this.fkMaquina = fkMaquina;
    }

    

}
