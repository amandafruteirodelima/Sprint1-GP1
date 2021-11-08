package implantation;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.mycompany.devtime.ConfiguracaoBanco;
import entities.Componente;
import entities.MaquinaEntity;
import org.springframework.jdbc.core.JdbcTemplate;

public class RamImpl {

    Looca looca = new Looca();
    ConfiguracaoBanco configuracaoBanco = new ConfiguracaoBanco();
    JdbcTemplate assistente = new JdbcTemplate(
            configuracaoBanco.getBancoDeDados());
    Memoria memoria = looca.getMemoria();
    MaquinaEntity maquinaInstance = MaquinaEntity.getInstance();

    public void findRam() {
        Double convertido = (double)memoria.getTotal();
        Componente ram = new Componente("RAM", convertido, "", "", "GB", 
                maquinaInstance.getIdMaquina());
        ram.insertComponente();
    }
}
