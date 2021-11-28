package entities;

import com.mycompany.devtime.ConfiguracaoBanco;
import com.mycompany.devtime.ConfiguracaoBancoMySql;
import org.springframework.jdbc.core.JdbcTemplate;

public class Componente {

    private Integer idComponente;
    private String nomeComponente;
    private Double capacidade;
    private String descricao;
    private String infoAdicional;
    private String unidadeDeMedida;
    private Integer fkMaquina;
    private Integer isAtivo;

    MaquinaEntity maquinaInstance = MaquinaEntity.getInstance();
    
    ConfiguracaoBanco configuracaoBanco = new ConfiguracaoBanco();
    
    JdbcTemplate assistente = new JdbcTemplate(
            configuracaoBanco.getBancoDeDados());

    ConfiguracaoBancoMySql configuracaoBancoMySql = new ConfiguracaoBancoMySql();
    
    JdbcTemplate assistenteMySql = new JdbcTemplate(
            configuracaoBancoMySql.getBancoDeDadosMySql());

    public Componente() {
    }

    public Componente(String nomeComponente,
            Double capacidade, String descricao, String infoAdicional,
            String unidadeDeMedida, Integer fkMaquina) {
        this.nomeComponente = nomeComponente;
        this.capacidade = capacidade;
        this.descricao = descricao;
        this.infoAdicional = infoAdicional;
        this.unidadeDeMedida = unidadeDeMedida;
        this.fkMaquina = fkMaquina;
        this.isAtivo = 1;
    }

    public void insertComponente() {
            assistente.update("INSERT INTO Componente(nomeComponente, capacidade, "
                    + "descricao, infoAdicional,unidadeDeMedida, fk_Maquina) "
                    + "VALUES(?,?,?,?,?,?)",
                    nomeComponente, capacidade, descricao, infoAdicional,
                    unidadeDeMedida, fkMaquina);

    }

    public void insertComponenteMySql() {    
            assistenteMySql.update("INSERT INTO Componente(nomeComponente, "
                    + "capacidade, descricao, infoAdicional,unidadeDeMedida, "
                    + "fk_Maquina) VALUES(?,?,?,?,?,?)", nomeComponente,
                    capacidade, descricao, infoAdicional, unidadeDeMedida,
                    fkMaquina);

    }

    public Integer getIdComponente() {
        return idComponente;
    }

    public void setIdComponente(Integer idComponente) {
        this.idComponente = idComponente;
    }

    public Integer getIsAtivo() {
        return isAtivo;
    }

    public void setIsAtivo(Integer isAtivo) {
        this.isAtivo = isAtivo;
    }
}
