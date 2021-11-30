package entities;

import com.mycompany.devtime.ConfiguracaoBanco;
import java.text.SimpleDateFormat;
import java.util.Date;
import logging.LogErro;
import org.springframework.jdbc.core.JdbcTemplate;

public class TempoLogado {

    private Date dia;

    LogErro logErro = new LogErro();
    ConfiguracaoBanco configuracaoBanco = new ConfiguracaoBanco();
    JdbcTemplate assistente = new JdbcTemplate(
            configuracaoBanco.getBancoDeDados());

    SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

    FuncionarioEntity funcionario = FuncionarioEntity.getInstance();

    public void insertMinuto() {
        Date date = new Date();
        try {
            assistente.update("INSERT INTO TEMPO_LOGADO(fk_Funcionario, dia) "
                    + "VALUES(?,?)",
                    funcionario.getIdFuncionario(), formatter.format(date));

        } catch (Exception erro) {
            logErro.mensagemErroInsert(erro);
        }
    }
}
