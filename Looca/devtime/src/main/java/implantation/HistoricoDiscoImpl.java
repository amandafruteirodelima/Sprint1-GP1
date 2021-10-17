package implantation;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.discos.Volume;
import com.mycompany.devtime.ConfiguracaoBanco;
import entities.DiscoEntity;
import entities.HistoricoDiscoEntity;
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

            List<DiscoEntity> discoid = assistente.query("Select idDisco"
                    + " from Disco where fkMaquina = '"
                    + maquina.getIdMaquina() + "' and uuid = '"
                    + volume.getUUID() + "'",
                    new BeanPropertyRowMapper<>(DiscoEntity.class));

            DiscoEntity discoDaVez = null;

            for (int i = 0; i < discoid.size(); i++) {
                discoDaVez = discoid.get(i);
            }

            Double convertido = volume.getDisponivel() / Math.pow(10, 9);
            HistoricoDiscoEntity historicoDisco = new HistoricoDiscoEntity(
                    convertido, discoDaVez.getIdDisco());

            historicoDisco.insertHistoricoDisco();
        }

    }

}
