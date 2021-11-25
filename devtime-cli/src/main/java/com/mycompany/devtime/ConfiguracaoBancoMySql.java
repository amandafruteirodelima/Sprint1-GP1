package com.mycompany.devtime;

import org.apache.commons.dbcp2.BasicDataSource;

public class ConfiguracaoBancoMySql {

    private BasicDataSource bancoDeDadosMySql;

    public ConfiguracaoBancoMySql() {
        this.bancoDeDadosMySql = new BasicDataSource();

        this.bancoDeDadosMySql​.setDriverClassName("com.mysql.cj.jdbc.Driver");
        this.bancoDeDadosMySql​.setUrl("jdbc:mysql://172.17.0.3:3306/banco1?autoReconnect=true&useSSL=false");
        this.bancoDeDadosMySql​.setUsername("devTime");
        this.bancoDeDadosMySql​.setPassword("urubu100");
    }    
    
    public BasicDataSource getBancoDeDadosMySql() {
        return bancoDeDadosMySql;
    }
}
