package com.mycompany.devtime;

import org.apache.commons.dbcp2.BasicDataSource;

public class ConfiguracaoBanco {

    private BasicDataSource bancoDeDados;

    public ConfiguracaoBanco() {
        this.bancoDeDados = new BasicDataSource();

        this.bancoDeDados​.setDriverClassName("org.h2.Driver");
        this.bancoDeDados​.setUrl("jdbc:h2:file:./devtime");
        this.bancoDeDados​.setUsername("sa");
        this.bancoDeDados​.setPassword("");
    }

    public BasicDataSource getBancoDeDados() {
        return bancoDeDados;
    }
}
