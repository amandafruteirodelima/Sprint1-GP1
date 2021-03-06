package implantation;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.processos.Processo;
import com.github.britooo.looca.api.group.processos.ProcessosGroup;
import com.mycompany.devtime.ConfiguracaoBanco;
import entities.MaquinaEntity;
import entities.HistoricoUsoSoftwareEntity;
import entities.SoftwareEntity;
import java.util.List;
import java.util.Objects;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class HistoricoUsoSoftwareImpl {

    Looca looca = new Looca();
    ConfiguracaoBanco configuracaoBanco = new ConfiguracaoBanco();
    JdbcTemplate assistente = new JdbcTemplate(
            configuracaoBanco.getBancoDeDados());
    ProcessosGroup grupoDeProcessos = looca.getGrupoDeProcessos();
    SoftwareImpl software = new SoftwareImpl();
    MaquinaEntity maquinaInstance = MaquinaEntity.getInstance();
    List<Processo> processos = grupoDeProcessos.getProcessos();

    public void findHistoricoSoftware() {

        for (Processo processo : processos) {

            String select = "Select *"
                        + " from Software where nomeSoftware = '"
                        + processo.getNome() + "'";

            if (processo.getUsoMemoria() > 0.4) {
            
                List<SoftwareEntity> softwareid = assistente.query(select,
                        new BeanPropertyRowMapper<>(SoftwareEntity.class));

                if (softwareid.isEmpty() || Objects.isNull(softwareid)) {
                    software.findSoftware(processo.getNome());
                    softwareid = assistente.query(select,
                            new BeanPropertyRowMapper<>(SoftwareEntity.class));
                }

                for (int i = 0; i < softwareid.size(); i++) {

                    SoftwareEntity softwareDaVez = softwareid.get(i);

                    HistoricoUsoSoftwareEntity usoSoftware = new HistoricoUsoSoftwareEntity(
                            processo.getUsoMemoria(),
                            softwareDaVez.getIdSoftware(),
                            maquinaInstance.getIdMaquina()
                    );
                    usoSoftware.insertHistoricoUsoSoftware();
                }
            }
            
        }
    }
}
