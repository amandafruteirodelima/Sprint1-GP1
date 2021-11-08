package implantation;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.discos.Volume;
import com.mycompany.devtime.ConfiguracaoBanco;
import entities.Componente;
import entities.HistoricoUsoEntity;
import entities.MaquinaEntity;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class HistoricoDiscoImpl {

    Looca looca = new Looca();
    ConfiguracaoBanco configuracaoBanco = new ConfiguracaoBanco();
    JdbcTemplate assistente = new JdbcTemplate(
            configuracaoBanco.getBancoDeDados());
    MaquinaEntity maquina = MaquinaEntity.getInstance();
    DiscosGroup grupoDeDiscos = looca.getGrupoDeDiscos();

    public void findHistoricoDisco() {

        List<Volume> volumes = grupoDeDiscos.getVolumes();

        for (Volume volume : volumes) {

            List<Componente> discoid = assistente.query("Select idComponente"
                    + " from Componente where fk_Maquina = '"
                    + maquina.getIdMaquina() + "' and infoAdicional = '"
                    + volume.getUUID() + "'",
                    new BeanPropertyRowMapper<>(Componente.class));

            Componente discoDaVez = null;

            for (int i = 0; i < discoid.size(); i++) {
                discoDaVez = discoid.get(i);
            }

            Double convertido = (double) volume.getDisponivel();
            HistoricoUsoEntity historicoDisco = new HistoricoUsoEntity(
                    discoDaVez.getIdComponente(),convertido);

            historicoDisco.insertHistorico();
        }

    }

}
