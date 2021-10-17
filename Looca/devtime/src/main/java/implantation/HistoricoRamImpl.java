package implantation;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.mycompany.devtime.ConfiguracaoBanco;
import entities.HistoricoRamEntity;
import entities.RamEntity;
import org.springframework.jdbc.core.JdbcTemplate;

public class HistoricoRamImpl {

    Looca looca = new Looca();
    Memoria memoria = looca.getMemoria();
    ConfiguracaoBanco configuracaoBanco = new ConfiguracaoBanco();
    JdbcTemplate assistente = new JdbcTemplate(
            configuracaoBanco.getBancoDeDados());
    RamEntity ramInstance = RamEntity.getInstance();

    public void findHistoricoRam() {

        Double disponivel = memoria.getDisponivel() / Math.pow(10, 9);
        Double emUso = memoria.getEmUso() / Math.pow(10, 9);

        HistoricoRamEntity historicoRam = new HistoricoRamEntity(emUso,
                        disponivel,
                        ramInstance.getIdRam());

        historicoRam.insertHistoricoRam();
    }
}
