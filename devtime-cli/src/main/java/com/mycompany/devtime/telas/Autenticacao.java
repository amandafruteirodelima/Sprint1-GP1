package com.mycompany.devtime.telas;

import com.mycompany.devtime.ConfiguracaoBanco;
import com.mycompany.devtime.Executor;
import entities.FuncionarioEntity;
import java.util.List;
import java.util.Scanner;
import logging.LogErro;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author bmath
 */
public class Autenticacao {

    LogErro logErro = new LogErro();
    Scanner leitor = new Scanner(System.in);
    Executor executor = new Executor();

    ConfiguracaoBanco configuracaoBanco = new ConfiguracaoBanco();

    JdbcTemplate assistente = new JdbcTemplate(
            configuracaoBanco.getBancoDeDados());

    FuncionarioEntity funcionarioEntity = FuncionarioEntity.getInstance();

    String email;
    String senha;

    public void autenticar() {

        System.out.println("Bem vindo!");
        System.out.println("Digite seu email");
        email = leitor.next();
        System.out.println("Digite sua senha");
        senha = leitor.next();

        try {
            List<FuncionarioEntity> funcionario = assistente.query("SELECT * "
                    + "FROM Funcionario where email = '" + email + "' and senha = '"
                    + senha + "'",
                    new BeanPropertyRowMapper<>(FuncionarioEntity.class));

            FuncionarioEntity funcionarioDaVez = null;

            for (int i = 0; i < funcionario.size(); i++) {
                funcionarioDaVez = funcionario.get(i);
            }

            if (funcionarioDaVez.getEmail().equals(email)
                    && funcionarioDaVez.getSenha().equals(senha)) {

                funcionarioEntity.setIdFuncionario(funcionarioDaVez.getIdFuncionario());
                System.out.println("Coleta de dados iniciada");
                executor.Executor();
            }
        } catch (Exception erro) {
            logErro.mensagemErroSelect(erro);
            System.out.println("Falha no Login\n");
            autenticar();
        }
    }
}
