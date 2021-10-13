package implantation;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.processador.Processador;
import entities.ProcessadorEntity;

public class ProcessadorImpl {

    public void findProcessador() {
        Looca looca = new Looca();
        Processador processador = looca.getProcessador();
        
        ProcessadorEntity cpu = new ProcessadorEntity(
                processador.getFabricante(),
                processador.getNome(), processador.getFrequencia(),
                processador.getNumeroCpusLogicas());
        cpu.insertProcessador();
    }
}
