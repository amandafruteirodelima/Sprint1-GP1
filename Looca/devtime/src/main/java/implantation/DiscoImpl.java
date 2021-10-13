package implantation;

import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import entities.DiscoEntity;
import java.util.List;
import com.github.britooo.looca.api.core.Looca;

public class DiscoImpl {

    Looca looca = new Looca();
    DiscosGroup grupoDeDiscos = looca.getGrupoDeDiscos();
    List<Disco> discos = grupoDeDiscos.getDiscos();

    public void findDisco() {

        for (Disco disco : discos) {
            Double convertido = disco.getTamanho() / Math.pow(10, 9);
            DiscoEntity discoAtual;
            discoAtual = new DiscoEntity(disco.getNome(),
                    disco.getModelo(), convertido);

            discoAtual.insertDisco();
        }
    }
}
