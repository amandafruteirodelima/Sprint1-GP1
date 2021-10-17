package implantation;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.processador.Processador;
import com.mycompany.devtime.ConfiguracaoBanco;
import entities.MaquinaEntity;
import entities.ProcessadorEntity;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class ProcessadorImpl {

    Looca looca = new Looca();
    Processador processador = looca.getProcessador();
    ConfiguracaoBanco configuracaoBanco = new ConfiguracaoBanco();
    JdbcTemplate assistente = new JdbcTemplate(
            configuracaoBanco.getBancoDeDados());
    MaquinaEntity maquinaInstance = MaquinaEntity.getInstance();
    ProcessadorEntity processadorInstance = ProcessadorEntity.getInstance();

    public void findProcessador() {

        ProcessadorEntity cpu = new ProcessadorEntity(
                processador.getFabricante(),
                processador.getNome(), processador.getFrequencia(),
                processador.getNumeroCpusLogicas(),
                maquinaInstance.getIdMaquina());
        cpu.insertProcessador();

        List<ProcessadorEntity> processadorid = assistente.query("Select"
                + " idprocessador from processador where fk_maquina = '"
                + maquinaInstance.getIdMaquina() + "'",
                new BeanPropertyRowMapper<>(ProcessadorEntity.class));

        ProcessadorEntity processadorDaVez = null;
        for (int i = 0; i < processadorid.size(); i++) {
            processadorDaVez = processadorid.get(i);
        }
        processadorInstance.setIdProcessador(processadorDaVez.getIdProcessador());

    }
}
