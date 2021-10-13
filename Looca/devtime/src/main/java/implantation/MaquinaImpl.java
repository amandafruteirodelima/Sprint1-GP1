package implantation;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.sistema.Sistema;
import entities.MaquinaEntity;

public class MaquinaImpl {

    public void findMaquina() {
        Looca looca = new Looca();
        Sistema sistema = looca.getSistema();

        MaquinaEntity maquina = new MaquinaEntity(
                sistema.getSistemaOperacional(),
                sistema.getArquitetura(),
                sistema.getFabricante());

        maquina.insertMaquina();
    }

}
