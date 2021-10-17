package implantation;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.processador.Processador;
import com.mycompany.devtime.ConfiguracaoBanco;
import entities.HistoricoProcessadorEntity;
import entities.ProcessadorEntity;
import org.springframework.jdbc.core.JdbcTemplate;

public class HistoricoProcessadorImpl {
    
    Looca looca = new Looca();
    Processador processador = looca.getProcessador();
    ConfiguracaoBanco configuracaoBanco = new ConfiguracaoBanco();
    JdbcTemplate assistente = new JdbcTemplate(
            configuracaoBanco.getBancoDeDados());
    ProcessadorEntity processadorInstance = ProcessadorEntity.getInstance();
    
    public void findHistoricoProcessador(){
        
        HistoricoProcessadorEntity historicoProcessador = 
                new HistoricoProcessadorEntity(processador.getUso(),
                        processadorInstance.getIdProcessador());
        
        historicoProcessador.insertHistoricoProcessador();
    }
    
}
