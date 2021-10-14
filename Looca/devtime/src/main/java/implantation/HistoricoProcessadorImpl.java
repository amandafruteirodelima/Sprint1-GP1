package implantation;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.processador.Processador;
import entities.HistoricoProcessadorEntity;

public class HistoricoProcessadorImpl {
    
    Looca looca = new Looca();
    Processador processador = looca.getProcessador();
    
    public void findHistoricoProcessador(){
        
        HistoricoProcessadorEntity historicoProcessador = 
                new HistoricoProcessadorEntity(processador.getUso());
        
        historicoProcessador.insertHistoricoProcessador();
    }
    
}
