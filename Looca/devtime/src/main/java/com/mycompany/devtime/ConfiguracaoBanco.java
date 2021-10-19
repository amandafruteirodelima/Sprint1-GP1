package com.mycompany.devtime;

import org.apache.commons.dbcp2.BasicDataSource;

public class ConfiguracaoBanco {

    private BasicDataSource bancoDeDados;

    public ConfiguracaoBanco() {
        this.bancoDeDados = new BasicDataSource();

        this.bancoDeDados​.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        this.bancoDeDados​.setUrl("jdbc:sqlserver://servidor-grupo1-devtime.database.windows.net:1433;database=grupo1-Devtime;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net");
        this.bancoDeDados​.setUsername("Grupo01");
        this.bancoDeDados​.setPassword("@#grupo1");
    }

    public BasicDataSource getBancoDeDados() {
        return bancoDeDados;
    }
}
