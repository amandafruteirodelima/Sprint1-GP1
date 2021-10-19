package entities;

import com.mycompany.devtime.ConfiguracaoBanco;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

public class DiscoEntity {

    private Integer idDisco;
    private String nomeDisco;
    private String modelo;
    private String uuid;
    private Double tamanhoDisco;
    private Integer fkMaquina;

    ConfiguracaoBanco configuracaoBanco = new ConfiguracaoBanco();
    JdbcTemplate assistente = new JdbcTemplate(
            configuracaoBanco.getBancoDeDados());

    public DiscoEntity(String nomeDisco, String modelo, String uuid, 
            Double tamanhoDisco, Integer fkMaquina) {
        this.nomeDisco = nomeDisco;
        this.modelo = modelo;
        this.uuid = uuid;
        this.tamanhoDisco = tamanhoDisco;
        this.fkMaquina = fkMaquina;
    }

    public DiscoEntity() {
    }

    public void insertDisco() {
        assistente.update("INSERT INTO DISCO(nomeDisco, modelo, uuid, "
                + "tamanhoDisco, fk_Maquina) VALUES(?,?,?,?,?)",
                nomeDisco, modelo, uuid, tamanhoDisco, fkMaquina);
    }

    public Integer getIdDisco() {
        return idDisco;
    }

    public void setIdDisco(Integer idDisco) {
        this.idDisco = idDisco;
    }

    public String getNomeDisco() {
        return nomeDisco;
    }

    public void setNomeDisco(String nomeDisco) {
        this.nomeDisco = nomeDisco;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Double getTamanhoDisco() {
        return tamanhoDisco;
    }

    public void setTamanhoDisco(Double tamanhoDisco) {
        this.tamanhoDisco = tamanhoDisco;
    }

}
