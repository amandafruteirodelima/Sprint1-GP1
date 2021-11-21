package implantation;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.discos.Volume;
import com.mycompany.devtime.ConfiguracaoBanco;
import entities.Componente;
import entities.HistoricoUsoEntity;
import entities.MaquinaEntity;
import java.util.List;
import logging.LogErro;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class HistoricoDiscoImpl {
    
    Looca looca = new Looca();
    ConfiguracaoBanco configuracaoBanco = new ConfiguracaoBanco();
    JdbcTemplate assistente = new JdbcTemplate(
            configuracaoBanco.getBancoDeDados());
    MaquinaEntity maquina = MaquinaEntity.getInstance();
    DiscosGroup grupoDeDiscos = looca.getGrupoDeDiscos();
    LogErro logErro = new LogErro();
    
    public void findHistoricoDisco() {
        
        List<Volume> volumes = grupoDeDiscos.getVolumes();
        List<Disco> discos = grupoDeDiscos.getDiscos();
        
        for (Disco disco : discos) {
            
            try {
                List<Componente> discoid = assistente.query("Select *"
                        + " from Componente where fk_Maquina = '"
                        + maquina.getIdMaquina() + "' and descricao = '"
                        + disco.getNome() + "'",
                        new BeanPropertyRowMapper<>(Componente.class));
                
                Componente discoDaVez = null;               
                for (int i = 0; i < discoid.size(); i++) {
                    discoDaVez = discoid.get(i);
                }
                
                if (discoDaVez.getIsAtivo().equals(1)) {
                    for (int i = 0; i == 0; i++) {
                        Double convertido = (double) volumes.get(i).getDisponivel();
                        
                        HistoricoUsoEntity historicoDisco = new HistoricoUsoEntity(
                                discoDaVez.getIdComponente(), convertido);
                        
                        historicoDisco.insertHistorico();
                    }
                }
            } catch (Exception erro) {
                logErro.mensagemErroSelect(erro);
            }
        }
    }
}
