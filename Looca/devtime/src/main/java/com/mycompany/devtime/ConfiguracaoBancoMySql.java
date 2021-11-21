package com.mycompany.devtime;

import org.apache.commons.dbcp2.BasicDataSource;

public class ConfiguracaoBancoMySql {

    private BasicDataSource bancoDeDadosMySql;

    public ConfiguracaoBancoMySql() {
        this.bancoDeDadosMySql = new BasicDataSource();

        this.bancoDeDadosMySql​.setDriverClassName("");
        this.bancoDeDadosMySql​.setUrl("");
        this.bancoDeDadosMySql​.setUsername("");
        this.bancoDeDadosMySql​.setPassword("");
    }    
    
    public BasicDataSource getBancoDeDadosMySql() {
        return bancoDeDadosMySql;
    }
}
