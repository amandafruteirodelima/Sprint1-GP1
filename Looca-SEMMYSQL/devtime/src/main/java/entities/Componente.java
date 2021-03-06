package entities;

import com.mycompany.devtime.ConfiguracaoBanco;
import logging.LogErro;
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

    LogErro logErro = new LogErro();

    MaquinaEntity maquinaInstance = MaquinaEntity.getInstance();

    ConfiguracaoBanco configuracaoBanco = new ConfiguracaoBanco();

    JdbcTemplate assistente = new JdbcTemplate(
            configuracaoBanco.getBancoDeDados());


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

        try {
            assistente.update("INSERT INTO COMPONENTE(nomeComponente, capacidade, "
                    + "descricao, infoAdicional,unidadeDeMedida, fk_Maquina) "
                    + "VALUES(?,?,?,?,?,?)",
                    nomeComponente, capacidade, descricao, infoAdicional,
                    unidadeDeMedida, fkMaquina);

        } catch (Exception erro) {
            logErro.mensagemErroInsert(erro);
        }
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
