package implantation;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.processos.Processo;
import com.github.britooo.looca.api.group.processos.ProcessosGroup;
import com.mycompany.devtime.ConfiguracaoBanco;
import entities.SoftwareEntity;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

public class SoftwareImpl {

    Looca looca = new Looca();
    SoftwareEntity softwareInstance = SoftwareEntity.getInstance();
    ConfiguracaoBanco configuracaoBanco = new ConfiguracaoBanco();
    JdbcTemplate assistente = new JdbcTemplate(
            configuracaoBanco.getBancoDeDados());
    ProcessosGroup grupoDeProcessos = looca.getGrupoDeProcessos();
    List<Processo> processos = grupoDeProcessos.getProcessos();

    public void findSoftware() {
        for (Processo processo : processos) {
            SoftwareEntity software = new SoftwareEntity(processo.getNome());
            software.insertSoftware();
        }
    }
}
