package implantation;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.mycompany.devtime.ConfiguracaoBanco;
import entities.MaquinaEntity;
import entities.RamEntity;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class RamImpl {

    Looca looca = new Looca();
    ConfiguracaoBanco configuracaoBanco = new ConfiguracaoBanco();
    JdbcTemplate assistente = new JdbcTemplate(
            configuracaoBanco.getBancoDeDados());
    Memoria memoria = looca.getMemoria();
    MaquinaEntity maquinaInstance = MaquinaEntity.getInstance();
    RamEntity ramInstance = RamEntity.getInstance();

    public void findRam() {
        Double convertido = memoria.getTotal() / Math.pow(10, 9);
        RamEntity ram = new RamEntity(convertido,
                maquinaInstance.getIdMaquina());
        ram.insertRam();

        List<RamEntity> ramid = assistente.query("Select"
                + " idram from ram where fkmaquina = '"
                + maquinaInstance.getIdMaquina() + "'",
                new BeanPropertyRowMapper<>(RamEntity.class));

        RamEntity ramDaVez = null;
        for (int i = 0; i < ramid.size(); i++) {
            ramDaVez = ramid.get(i);
        }
        ramInstance.setIdRam(ramDaVez.getIdRam());

    }
}
