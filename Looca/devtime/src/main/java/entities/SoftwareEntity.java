package entities;

import com.mycompany.devtime.ConfiguracaoBanco;
import logging.LogErro;
import org.springframework.jdbc.core.JdbcTemplate;

public class SoftwareEntity {

    private Integer idSoftware;
    private String nomeSoftware;

    LogErro logErro = new LogErro();
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
        try {
            assistente.update("INSERT INTO SOFTWARE(nomeSoftware,linkImagemSoftware)"
                    + " VALUES(?,?)",
                    nomeSoftware, "https://pbs.twimg.com/media/EeTDgb4WoAAcrmS.jpg");
            
        } catch (Exception erro) {
            logErro.mensagemErroInsert(erro);
        }

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
