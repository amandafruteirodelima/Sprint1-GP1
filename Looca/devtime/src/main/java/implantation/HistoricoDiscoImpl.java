package implantation;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.discos.Volume;
import entities.HistoricoDiscoEntity;
import java.util.List;

public class HistoricoDiscoImpl {
    
    public void findHistoricoDisco(){
        
        Looca looca = new Looca();
        DiscosGroup grupoDeDiscos = looca.getGrupoDeDiscos();
        List<Volume> volumes = grupoDeDiscos.getVolumes();
        
        for (Volume volume : volumes){
            Double convertido =  volume.getDisponivel() / Math.pow(10, 9);
            HistoricoDiscoEntity historicoDisco = new HistoricoDiscoEntity(
                    convertido);
            historicoDisco.insertHistoricoDisco();
        }
    } 
    
}
