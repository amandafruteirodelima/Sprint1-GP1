package implantation;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.processos.Processo;
import com.github.britooo.looca.api.group.processos.ProcessosGroup;
import entities.MaquinaSoftwareEntity;
import java.util.List;

public class MaquinaSoftwareImpl {

    Looca looca = new Looca();
    ProcessosGroup grupoDeProcessos = looca.getGrupoDeProcessos();

    public void findMaquinaSoftware() {
        List<Processo> processos = grupoDeProcessos.getProcessos();
        for (Processo processo : processos) {
            MaquinaSoftwareEntity maquinaSoftware
                    = new MaquinaSoftwareEntity(processo.getUsoCpu(),
                            processo.getUsoMemoria());

            maquinaSoftware.insertMaquinaSoftware();

        }
    }
}
