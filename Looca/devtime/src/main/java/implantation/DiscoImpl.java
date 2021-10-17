package implantation;

import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import entities.DiscoEntity;
import java.util.List;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Volume;
import com.mycompany.devtime.ConfiguracaoBanco;
import entities.MaquinaEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class DiscoImpl {

    MaquinaEntity maquina = MaquinaEntity.getInstance();
    Looca looca = new Looca();
    ConfiguracaoBanco configuracaoBanco = new ConfiguracaoBanco();
    JdbcTemplate assistente = new JdbcTemplate(
            configuracaoBanco.getBancoDeDados());
    DiscosGroup grupoDeDiscos = looca.getGrupoDeDiscos();
    List<Disco> discos = grupoDeDiscos.getDiscos();
    List<Volume> volumes = grupoDeDiscos.getVolumes();

    public void findDisco() {

        int i = 0;
        for (Disco disco : discos) {

            Double convertido = disco.getTamanho() / Math.pow(10, 9);
            DiscoEntity discoAtual;
            discoAtual = new DiscoEntity(disco.getNome(),
                    disco.getModelo(), volumes.get(i).getUUID(),
                    convertido, maquina.getIdMaquina());

            discoAtual.insertDisco();

            i++;
        }

    }
}
