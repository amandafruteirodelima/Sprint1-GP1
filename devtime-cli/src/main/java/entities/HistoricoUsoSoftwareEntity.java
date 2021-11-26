package entities;

import com.mycompany.devtime.ConfiguracaoBanco;
import com.mycompany.devtime.ConfiguracaoBancoMySql;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.jdbc.core.JdbcTemplate;

public class HistoricoUsoSoftwareEntity {

    private Integer idHistoricoUsoSoftware;
    private Date dataHora;
    private Double consumo;
    private Integer fk_Software;
    private Integer fk_Maquina;

   
    ConfiguracaoBanco configuracaoBanco = new ConfiguracaoBanco();
    JdbcTemplate assistente = new JdbcTemplate(
            configuracaoBanco.getBancoDeDados());

    ConfiguracaoBancoMySql configuracaoBancoMySql = new ConfiguracaoBancoMySql();
    JdbcTemplate assistenteMySql = new JdbcTemplate(
            configuracaoBancoMySql.getBancoDeDadosMySql());

    SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
    Date date = new Date();

    public HistoricoUsoSoftwareEntity(Double consumo, Integer fk_Software, Integer fk_Maquina) {
        this.consumo = consumo;
        this.fk_Software = fk_Software;
        this.fk_Maquina = fk_Maquina;
    }

    public void insertHistoricoUsoSoftware() {

        
            assistente.update("INSERT INTO Historico_Uso_Software(dataHora, "
                    + "consumo, fk_Software, fk_Maquina) "
                    + "VALUES(?,?,?,?)",
                    formatter.format(date), consumo, fk_Software, fk_Maquina);

        
    }
    
     //   public void insertHistoricoUsoSoftwareMySql() {

       
       //     assistenteMySql.update("INSERT INTO Historico_Uso_Software("
         //           + "dataHora, consumo, fk_Software, fk_Maquina) "
           //         + "VALUES(?,?,?,?)",
             //       formatter.format(date), consumo, fk_Software, fk_Maquina);
    //}

}
