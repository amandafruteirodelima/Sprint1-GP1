package implantation;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.memoria.Memoria;
import entities.RamEntity;

public class RamImpl {
    Looca looca = new Looca();
    Memoria memoria = looca.getMemoria();
    
    public void findRam(){
        Double convertido =  memoria.getTotal() / Math.pow(10, 9);
        RamEntity ram = new RamEntity(convertido);
        ram.insertRam();
    }
}
