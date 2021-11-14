package entities;

import com.mycompany.devtime.ConfiguracaoBanco;
import java.text.SimpleDateFormat;
import java.util.Date;
import logging.LogErro;
import org.springframework.jdbc.core.JdbcTemplate;

public class MaquinaSoftwareEntity {

    private Integer idMaquina_Software;
    private Double usoCPUSoftware;
    private Double usoRAMSoftware;
    private Integer pid;
    private Integer fk_maquina;
    private Integer fk_software;

    LogErro logErro = new LogErro();
    ConfiguracaoBanco configuracaoBanco = new ConfiguracaoBanco();
    JdbcTemplate assistente = new JdbcTemplate(
            configuracaoBanco.getBancoDeDados());

    SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
    Date date = new Date();

    public MaquinaSoftwareEntity(Double usoCPUSoftware, Double usoRAMSoftware,
            Integer pid, Integer fk_maquina, Integer fk_software) {
        this.usoCPUSoftware = usoCPUSoftware;
        this.usoRAMSoftware = usoRAMSoftware;
        this.pid = pid;
        this.fk_maquina = fk_maquina;
        this.fk_software = fk_software;
    }

    public void insertMaquinaSoftware() {
        
        try {
            assistente.update("INSERT INTO MAQUINA_SOFTWARE(usoCPUSoftware, "
                + "usoRAMSoftware, pid, DataHora, fk_maquina, fk_software) "
                + "VALUES(?,?,?,?,?,?)",
                usoCPUSoftware, usoRAMSoftware, pid,
                formatter.format(date), fk_maquina, fk_software);
            
        } catch (Exception erro) {
            logErro.mensagemErroInsert(erro);
        }
        
    }

    public Integer getIdMaquina_Software() {
        return idMaquina_Software;
    }

    public void setIdMaquina_Software(Integer idMaquina_Software) {
        this.idMaquina_Software = idMaquina_Software;
    }

    public Double getUsoCPUSoftware() {
        return usoCPUSoftware;
    }

    public void setUsoCPUSoftware(Double usoCPUSoftware) {
        this.usoCPUSoftware = usoCPUSoftware;
    }

    public Double getUsoRAMSoftware() {
        return usoRAMSoftware;
    }

    public void setUsoRAMSoftware(Double usoRAMSoftware) {
        this.usoRAMSoftware = usoRAMSoftware;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getFk_maquina() {
        return fk_maquina;
    }

    public void setFk_maquina(Integer fk_maquina) {
        this.fk_maquina = fk_maquina;
    }

    public Integer getFk_software() {
        return fk_software;
    }

    public void setFk_software(Integer fk_software) {
        this.fk_software = fk_software;
    }

    public SimpleDateFormat getFormatter() {
        return formatter;
    }

    public void setFormatter(SimpleDateFormat formatter) {
        this.formatter = formatter;
    }

}
