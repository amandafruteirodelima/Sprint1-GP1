package entities;

import com.mycompany.devtime.ConfiguracaoBanco;
import org.springframework.jdbc.core.JdbcTemplate;

public class DiscoEntity {

    private Integer idDisco;
    private String nomeDisco;
    private String modelo;
    private Long tamanhoDisco;
    private Integer fkMaquina;

    ConfiguracaoBanco configuracaoBanco = new ConfiguracaoBanco();
    JdbcTemplate assistente = new JdbcTemplate(
            configuracaoBanco.getBancoDeDados());

    public DiscoEntity(String nomeDisco, String modelo, Long tamanhoDisco) {
        this.nomeDisco = nomeDisco;
        this.modelo = modelo;
        this.tamanhoDisco = tamanhoDisco;
    }

    public void insertDisco() {
        Double conversor =  tamanhoDisco / Math.pow(10, 9);
        assistente.update("INSERT INTO DISCO VALUES(?,?,?,?)", null,
                nomeDisco, modelo, conversor);
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

    public Long getTamanhoDisco() {
        return tamanhoDisco;
    }

    public void setTamanhoDisco(Long tamanhoDisco) {
        this.tamanhoDisco = tamanhoDisco;
    }

}
