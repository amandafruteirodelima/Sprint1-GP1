package implantation;

import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import java.util.List;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Volume;
import entities.Componente;
import entities.MaquinaEntity;

public class DiscoImpl {

    Looca looca = new Looca();
    MaquinaEntity maquinaInstance = MaquinaEntity.getInstance();
    DiscosGroup grupoDeDiscos = looca.getGrupoDeDiscos();
    List<Disco> discos = grupoDeDiscos.getDiscos();
    List<Volume> volumes = grupoDeDiscos.getVolumes();

    public void findDisco() {

        int i = 0;
        for (Disco disco : discos) {

            Double convertido = (double) disco.getTamanho();
            Componente discoAtual;
            discoAtual = new Componente("DISCO", convertido, disco.getNome(),
                    volumes.get(i).getUUID(), "GB", maquinaInstance.getIdMaquina());

            discoAtual.insertComponente();

            i++;
        }

    }
}
