package implantation;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.processador.Processador;
import com.mycompany.devtime.ConfiguracaoBanco;
import entities.Componente;
import entities.HistoricoUsoEntity;
import entities.MaquinaEntity;
import java.util.List;
import logging.LogErro;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class HistoricoProcessadorImpl {

    Looca looca = new Looca();
    Processador processador = looca.getProcessador();
    ConfiguracaoBanco configuracaoBanco = new ConfiguracaoBanco();
    JdbcTemplate assistente = new JdbcTemplate(
            configuracaoBanco.getBancoDeDados());
    MaquinaEntity maquinaInstance = MaquinaEntity.getInstance();
    LogErro logErro = new LogErro();

    public void findHistoricoProcessador() {

        try {
            List<Componente> componente = assistente.query("SELECT *"
                    + " FROM COMPONENTE WHERE FK_MAQUINA ='"
                    + maquinaInstance.getIdMaquina() + "' AND NOMECOMPONENTE = "
                    + "'CPU'",
                    new BeanPropertyRowMapper<>(Componente.class));

            Componente componenteDaVez = null;
            for (int i = 0; i < componente.size(); i++) {
                componenteDaVez = componente.get(i);
            }
            
            if (componenteDaVez.getIsAtivo().equals(1)) {
                HistoricoUsoEntity historicoProcessador
                        = new HistoricoUsoEntity(
                                componenteDaVez.getIdComponente(),
                                processador.getUso());

                historicoProcessador.insertHistorico();
            }

        } catch (Exception erro) {
            logErro.mensagemErroSelect(erro);
        }

    }

}
