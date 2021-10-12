package com.mycompany.devtime;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class Criacao {

    public static void main(String[] args) {
        ConfiguracaoBanco configuracaoBanco = new ConfiguracaoBanco();

        JdbcTemplate assistente = new JdbcTemplate(
                configuracaoBanco.getBancoDeDados());

        assistente.execute("drop table disco");
        
        String createDisco = "CREATE TABLE DISCO ("
                + "  idDisco INT NOT NULL AUTO_INCREMENT,"
                + "  nomeDisco VARCHAR(45),"
                + "  modelo varchar(80),"
                + "  tamanhoDisco Double,"
                + "  PRIMARY KEY (idDisco)"
                + ");";

        assistente.execute(createDisco);
        
                assistente.execute("drop table historicodisco");
        
        String createHistoricoDisco = "CREATE TABLE HISTORICODISCO ("
                + "  idHistoricoDisco INT NOT NULL AUTO_INCREMENT,"
                + "  ARMAZENAMENTO DOUBLE,"
                + "  DATA_HORA DATETIME,"
                + "  PRIMARY KEY (idHistoricoDisco)"
                + ");";

        assistente.execute(createHistoricoDisco);
    }

}
