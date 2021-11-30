package implantation;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.processador.Processador;
import entities.Componente;
import entities.MaquinaEntity;

public class ProcessadorImpl {

    Looca looca = new Looca();
    Processador processador = looca.getProcessador();
    MaquinaEntity maquinaInstance = MaquinaEntity.getInstance();

    public void findProcessador() {

        Componente cpu = new Componente("CPU",
                (double) processador.getFrequencia(), processador.getNome(),
                processador.getFabricante(), "Ghz",
                maquinaInstance.getIdMaquina());
        cpu.insertComponente();
  
    }
}
