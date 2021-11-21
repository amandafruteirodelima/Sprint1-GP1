package com.mycompany.devtime;

import org.apache.commons.dbcp2.BasicDataSource;

public class ConfiguracaoBancoMySql {

    private BasicDataSource bancoDeDadosMySql;

    public ConfiguracaoBancoMySql() {
        this.bancoDeDadosMySql = new BasicDataSource();

        this.bancoDeDadosMySql​.setDriverClassName("com.mysql.cj.jdbc.Driver");
        this.bancoDeDadosMySql​.setUrl("jdbc:mysql://0.0.0.0:3306/nomebanco?autoReconnect=true&useSSL=false");
        this.bancoDeDadosMySql​.setUsername("root");
        this.bancoDeDadosMySql​.setPassword("urubu100");
    }    
    
    public BasicDataSource getBancoDeDadosMySql() {
        return bancoDeDadosMySql;
    }
}
