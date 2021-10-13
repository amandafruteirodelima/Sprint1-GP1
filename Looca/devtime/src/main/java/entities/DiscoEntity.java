package entities;

import com.mycompany.devtime.ConfiguracaoBanco;
import org.springframework.jdbc.core.JdbcTemplate;

public class DiscoEntity {

    private Integer idDisco;
    private String nomeDisco;
    private String modelo;
    private Double tamanhoDisco;
    private Integer fkMaquina;

    ConfiguracaoBanco configuracaoBanco = new ConfiguracaoBanco();
    JdbcTemplate assistente = new JdbcTemplate(
            configuracaoBanco.getBancoDeDados());

    public DiscoEntity(String nomeDisco, String modelo, Double tamanhoDisco) {
        this.nomeDisco = nomeDisco;
        this.modelo = modelo;
        this.tamanhoDisco = tamanhoDisco;
    }

    public void insertDisco() {      
        assistente.update("INSERT INTO DISCO VALUES(?,?,?,?)", null,
                nomeDisco, modelo, tamanhoDisco);
        System.out.println(assistente.queryForList("SELECT * FROM DISCO"));
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
