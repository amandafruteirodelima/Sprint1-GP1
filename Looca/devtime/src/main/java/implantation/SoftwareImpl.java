package implantation;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.processos.Processo;
import com.github.britooo.looca.api.group.processos.ProcessosGroup;
import entities.SoftwareEntity;
import java.util.List;

public class SoftwareImpl {

    Looca looca = new Looca();
    ProcessosGroup grupoDeProcessos = looca.getGrupoDeProcessos();
    List<Processo> processos = grupoDeProcessos.getProcessos();

    public void findSoftware() {
        for (Processo processo : processos) {
            SoftwareEntity software = new SoftwareEntity(processo.getNome());
            software.insertSoftware();
        }
    }
}
