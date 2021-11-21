package implantation;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.processos.Processo;
import com.github.britooo.looca.api.group.processos.ProcessosGroup;
import com.mycompany.devtime.ConfiguracaoBanco;
import entities.MaquinaEntity;
import entities.MaquinaSoftwareEntity;
import entities.SoftwareEntity;
import java.util.List;
import logging.LogErro;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class MaquinaSoftwareImpl {

    Looca looca = new Looca();
    ConfiguracaoBanco configuracaoBanco = new ConfiguracaoBanco();
    JdbcTemplate assistente = new JdbcTemplate(
            configuracaoBanco.getBancoDeDados());
    ProcessosGroup grupoDeProcessos = looca.getGrupoDeProcessos();
    SoftwareEntity softwareInstance = SoftwareEntity.getInstance();
    MaquinaEntity maquinaInstance = MaquinaEntity.getInstance();
    LogErro logErro = new LogErro();

    public void findMaquinaSoftware() {
        List<Processo> processos = grupoDeProcessos.getProcessos();
        for (Processo processo : processos) {
            try {
                List<SoftwareEntity> softwareid = assistente.query("Select *"
                        + " from Software where nomeSoftware = '"
                        + processo.getNome() + "'",
                        new BeanPropertyRowMapper<>(SoftwareEntity.class));

                for (int i = 0; i < softwareid.size(); i++) {
                    SoftwareEntity softwareDaVez = softwareid.get(i);

                    MaquinaSoftwareEntity maquinaSoftware = new MaquinaSoftwareEntity(
                            processo.getUsoCpu(),
                            processo.getUsoMemoria(),
                            processo.getPid(),
                            maquinaInstance.getIdMaquina(),
                            softwareDaVez.getIdSoftware()
                    );
                    maquinaSoftware.insertMaquinaSoftware();
                }
                
            } catch (Exception erro) {
                logErro.mensagemErroSelect(erro);
            }

        }
    }
}
