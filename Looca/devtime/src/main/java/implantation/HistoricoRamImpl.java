package implantation;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.mycompany.devtime.ConfiguracaoBanco;
import entities.Componente;
import entities.HistoricoUsoEntity;
import entities.MaquinaEntity;
import java.util.List;
import logging.LogErro;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class HistoricoRamImpl {

    Looca looca = new Looca();
    Memoria memoria = looca.getMemoria();
    ConfiguracaoBanco configuracaoBanco = new ConfiguracaoBanco();
    JdbcTemplate assistente = new JdbcTemplate(
            configuracaoBanco.getBancoDeDados());
    MaquinaEntity maquinaInstance = MaquinaEntity.getInstance();
    LogErro logErro = new LogErro();

    public void findHistoricoRam() {

        try {
            List<Componente> componente = assistente.query("SELECT *"
                    + " FROM COMPONENTE WHERE FK_MAQUINA ='"
                    + maquinaInstance.getIdMaquina() + "' AND NOMECOMPONENTE = 'RAM'",
                    new BeanPropertyRowMapper<>(Componente.class));

            Componente componenteDaVez = null;
            for (int i = 0; i < componente.size(); i++) {
                componenteDaVez = componente.get(i);
            }

            if (componenteDaVez.getIsAtivo().equals(1)) {

                Double emUso = (double) memoria.getEmUso();

                HistoricoUsoEntity historicoRam = new HistoricoUsoEntity(
                        componenteDaVez.getIdComponente(), emUso);

                historicoRam.insertHistorico();
                historicoRam.insertHistoricoMySql();
            }

        } catch (Exception erro) {
            logErro.mensagemErroSelect(erro);
        }

    }
}
