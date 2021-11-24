package implantation;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.processos.Processo;
import com.github.britooo.looca.api.group.processos.ProcessosGroup;
import com.mycompany.devtime.ConfiguracaoBanco;
import entities.SoftwareEntity;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class SoftwareImpl {

    Looca looca = new Looca();
    ConfiguracaoBanco configuracaoBanco = new ConfiguracaoBanco();
    JdbcTemplate assistente = new JdbcTemplate(
            configuracaoBanco.getBancoDeDados());
    ProcessosGroup grupoDeProcessos = looca.getGrupoDeProcessos();
    List<Processo> processos = grupoDeProcessos.getProcessos();

    public void findSoftware() {
        for (Processo processo : processos) {
            if (isDuplicado(processo)) {
                SoftwareEntity software = new SoftwareEntity(processo.getNome());
                software.insertSoftware();
            }
        }
    }

    public void findSoftware(String nome) {
        SoftwareEntity software = new SoftwareEntity(nome);
        software.insertSoftware();
    }

    public Boolean isDuplicado(Processo processo) {

        List<SoftwareEntity> softwares = assistente.query("Select *"
                + " from Software where nomeSoftware = '"
                + processo.getNome() + "'",
                new BeanPropertyRowMapper<>(SoftwareEntity.class));

        for (SoftwareEntity software : softwares) {

            if (software.getNomeSoftware().equals(processo.getNome())) {
                return false;
            }
        }
        return true;
    }
}
