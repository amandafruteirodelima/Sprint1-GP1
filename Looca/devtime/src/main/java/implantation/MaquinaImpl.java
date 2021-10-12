package implantation;

import entities.MaquinaEntity;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.discos.Volume;
import com.github.britooo.looca.api.group.sistema.Sistema;
import entities.DiscoEntity;
import entities.HistoricoDiscoEntity;
import java.util.List;

public class MaquinaImpl {

    public static void main(String[] args) {
        Looca looca = new Looca();
        Sistema sistema = looca.getSistema();
        DiscosGroup grupoDeDiscos = looca.getGrupoDeDiscos();
         
//        MaquinaEntity maquina = new MaquinaEntity(
//                sistema.getSistemaOperacional(),
//                sistema.getArquitetura(),
//                sistema.getFabricante());
//
//        maquina.insertMaquina();
        
        List<Disco> discos = grupoDeDiscos.getDiscos();
        
        for (Disco disco : discos) {           
            DiscoEntity discoAtual = new DiscoEntity(disco.getNome(), 
                    disco.getModelo(), disco.getTamanho());
            
            discoAtual.insertDisco();
        }
        
        
        List<Volume> volumes = grupoDeDiscos.getVolumes();
        
        for (Volume volume : volumes){
            HistoricoDiscoEntity historicoDisco = new HistoricoDiscoEntity(
                    volume.getDisponivel());
            historicoDisco.insertHistoricoDisco();
        }
        
        
    }

}
