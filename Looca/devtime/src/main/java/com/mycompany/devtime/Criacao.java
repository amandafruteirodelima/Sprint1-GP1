package com.mycompany.devtime;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class Criacao {

    public static void main(String[] args) {
        ConfiguracaoBanco configuracaoBanco = new ConfiguracaoBanco();

        JdbcTemplate assistente = new JdbcTemplate(
                configuracaoBanco.getBancoDeDados());
        
        assistente.execute("drop table maquina");
        
        String createMaquina = "CREATE TABLE MAQUINA ("
                + "  idMaquina INT NOT NULL AUTO_INCREMENT,"
                + "  sistemaOperacional VARCHAR(45),"
                + "  arquiteturaSO varchar(5),"
                + "  fabricanteSO varchar(45),"
                + "  PRIMARY KEY (idMaquina)"
                + ");";

        assistente.execute(createMaquina);

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
        
        assistente.execute("drop table processador");
        
        String createProcessador = "CREATE TABLE PROCESSADOR ("
                + "  idProcessador INT NOT NULL AUTO_INCREMENT,"
                + "  fabricante VARCHAR(45),"
                + "  nomeProcessador VARCHAR(80),"
                + "  frequencia DOUBLE,"
                + "  numerocpus INTEGER,"
                + "  PRIMARY KEY (idProcessador)"
                + ");";

        assistente.execute(createProcessador);
        
        assistente.execute("drop table ram");
        
        String createRam = "CREATE TABLE RAM ("
                + "  idRam INT NOT NULL AUTO_INCREMENT,"
                + "  total DOUBLE,"
                + "  PRIMARY KEY (idRam)"
                + ");";

        assistente.execute(createRam);
    }

}
