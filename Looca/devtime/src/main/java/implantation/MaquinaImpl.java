package implantation;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.mycompany.devtime.ConfiguracaoBanco;
import entities.FuncionarioEntity;
import entities.MaquinaEntity;
import java.util.List;
import logging.LogErro;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class MaquinaImpl {

    FuncionarioEntity funcionario = FuncionarioEntity.getInstance();
    MaquinaEntity maquinaInstance = MaquinaEntity.getInstance();
    ConfiguracaoBanco configuracaoBanco = new ConfiguracaoBanco();
    JdbcTemplate assistente = new JdbcTemplate(
            configuracaoBanco.getBancoDeDados());
    LogErro logErro = new LogErro();

    public void findMaquina() {
        Looca looca = new Looca();
        Sistema sistema = looca.getSistema();

        MaquinaEntity maquina = new MaquinaEntity(
                sistema.getSistemaOperacional(),
                sistema.getArquitetura(),
                sistema.getFabricante(),
                funcionario.getIdFuncionario());

        maquina.insertMaquina();
        
        try {
            List<MaquinaEntity> maquinaid = assistente.query("Select *"
                    + " from Maquina where fk_Funcionario = '"
                    + funcionario.getIdFuncionario() + "'",
                    new BeanPropertyRowMapper<>(MaquinaEntity.class));

            MaquinaEntity maquinaDaVez = null;
            for (int i = 0; i < maquinaid.size(); i++) {
                maquinaDaVez = maquinaid.get(i);
            }
            maquinaInstance.setIdMaquina(maquinaDaVez.getIdMaquina());

        } catch (Exception erro) {
            logErro.mensagemErroSelect(erro);
        }

    }
}
