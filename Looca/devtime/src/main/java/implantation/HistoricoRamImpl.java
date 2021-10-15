package implantation;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.memoria.Memoria;
import entities.HistoricoRamEntity;

public class HistoricoRamImpl {

    Looca looca = new Looca();
    Memoria memoria = looca.getMemoria();

    public void findHistoricoRam() {

        HistoricoRamEntity historicoRam
                = new HistoricoRamEntity(memoria.getEmUso() / Math.pow(10, 9),
                        memoria.getDisponivel() / Math.pow(10, 9));

        historicoRam.insertHistoricoRam();
    }
}
