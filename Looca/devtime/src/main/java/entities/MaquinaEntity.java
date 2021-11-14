package entities;

import com.mycompany.devtime.ConfiguracaoBanco;
import java.util.List;
import logging.LogErro;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class MaquinaEntity {

    private Integer idMaquina;
    private String sistemaOperacional;
    private Integer arquiteturaSO;
    private String fabricanteSO;
    private Integer fkFuncionario;

    LogErro logErro = new LogErro();
    ConfiguracaoBanco configuracaoBanco = new ConfiguracaoBanco();
    JdbcTemplate assistente = new JdbcTemplate(
            configuracaoBanco.getBancoDeDados());
    FuncionarioEntity funcionario = FuncionarioEntity.getInstance();

    public MaquinaEntity(String sistemaOperacional, Integer arquiteturaSO,
            String fabricanteSO, Integer fkFuncionario) {
        this.sistemaOperacional = sistemaOperacional;
        this.arquiteturaSO = arquiteturaSO;
        this.fabricanteSO = fabricanteSO;
        this.fkFuncionario = fkFuncionario;
    }

    public MaquinaEntity() {
    }

    private static MaquinaEntity instance = new MaquinaEntity();

    public static MaquinaEntity getInstance() {
        return instance;
    }

    public void insertMaquina() {
        try {
            assistente.update("INSERT INTO Maquina(sistemaOperacional,arquiteturaSO, "
                    + "fabricanteSO,fk_Funcionario) VALUES(?,?,?,?)",
                    sistemaOperacional, arquiteturaSO,
                    fabricanteSO, fkFuncionario);

        } catch (Exception erro) {
            logErro.mensagemErroInsert(erro);
        }
    }

    public void instanciarMaquina() {
        try {
            List<MaquinaEntity> maquinaid = assistente.query("Select *"
                    + " from Maquina where fk_Funcionario = '"
                    + funcionario.getIdFuncionario() + "'",
                    new BeanPropertyRowMapper<>(MaquinaEntity.class));

            MaquinaEntity maquinaDaVez = null;
            for (int i = 0; i < maquinaid.size(); i++) {
                maquinaDaVez = maquinaid.get(i);

            }
            instance.setIdMaquina(maquinaDaVez.getIdMaquina());
            
        } catch (Exception erro) {
            logErro.mensagemErroSelect(erro);
        }
    }

    public Integer getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(Integer idMaquina) {
        this.idMaquina = idMaquina;
    }

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }

    public void setSistemaOperacional(String sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }

    public Integer getArquiteturaSO() {
        return arquiteturaSO;
    }

    public void setArquiteturaSO(Integer arquiteturaSO) {
        this.arquiteturaSO = arquiteturaSO;
    }

    public String getFabricanteSO() {
        return fabricanteSO;
    }

    public void setFabricanteSO(String fabricanteSO) {
        this.fabricanteSO = fabricanteSO;
    }

    public Integer getFkFuncionario() {
        return fkFuncionario;
    }

    public void setFkFuncionario(Integer fkFuncionario) {
        this.fkFuncionario = fkFuncionario;
    }

}
