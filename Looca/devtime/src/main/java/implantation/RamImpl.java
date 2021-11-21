package implantation;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.memoria.Memoria;
import entities.Componente;
import entities.MaquinaEntity;

public class RamImpl {

    Looca looca = new Looca();
    Memoria memoria = looca.getMemoria();
    MaquinaEntity maquinaInstance = MaquinaEntity.getInstance();

    public void findRam() {
        Double convertido = (double)memoria.getTotal();
        Componente ram = new Componente("RAM", convertido, "", "", "GB", 
                maquinaInstance.getIdMaquina());
        ram.insertComponente();
    }
}
