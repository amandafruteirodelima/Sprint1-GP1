package implantation;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.processador.Processador;
import com.mycompany.devtime.ConfiguracaoBanco;
import entities.Componente;
import entities.MaquinaEntity;
import org.springframework.jdbc.core.JdbcTemplate;

public class ProcessadorImpl {

    Looca looca = new Looca();
    Processador processador = looca.getProcessador();
    ConfiguracaoBanco configuracaoBanco = new ConfiguracaoBanco();
    JdbcTemplate assistente = new JdbcTemplate(
            configuracaoBanco.getBancoDeDados());
    MaquinaEntity maquinaInstance = MaquinaEntity.getInstance();

    public void findProcessador() {

        Componente cpu = new Componente("CPU",
                (double) processador.getFrequencia(), processador.getNome(),
                processador.getFabricante(), "Ghz",
                maquinaInstance.getIdMaquina());
        cpu.insertComponente();
    }
}
