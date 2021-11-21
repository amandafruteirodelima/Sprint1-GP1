package entities;

import com.mycompany.devtime.ConfiguracaoBanco;
import com.mycompany.devtime.ConfiguracaoBancoMySql;
import logging.LogErro;
import org.springframework.jdbc.core.JdbcTemplate;

public class SoftwareEntity {

    private Integer idSoftware;
    private String nomeSoftware;

    LogErro logErro = new LogErro();
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
        try {
            assistente.update("INSERT INTO SOFTWARE(nomeSoftware)"
                    + " VALUES(?)",
                    nomeSoftware);

        } catch (Exception erro) {
            logErro.mensagemErroInsert(erro);
        }
    }

    public void insertSoftwareMySql() {
        try {
            assistenteMySql.update("INSERT INTO SOFTWARE(nomeSoftware)"
                    + " VALUES(?)",
                    nomeSoftware);

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
