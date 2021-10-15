package com.mycompany.devtime;

import entities.HistoricoProcessadorEntity;
import entities.ProcessadorEntity;
import implantation.DiscoImpl;
import implantation.HistoricoDiscoImpl;
import implantation.HistoricoProcessadorImpl;
import implantation.MaquinaImpl;
import implantation.ProcessadorImpl;
import implantation.RamImpl;
import java.util.Scanner;
import org.springframework.jdbc.core.JdbcTemplate;

public class Executor {

    public void Executor() {

  

        MaquinaImpl maquina = new MaquinaImpl();
        DiscoImpl disco = new DiscoImpl();
        ProcessadorImpl processador = new ProcessadorImpl();
        RamImpl ram = new RamImpl();
        HistoricoDiscoImpl histDisco = new HistoricoDiscoImpl();
        HistoricoProcessadorImpl histProcessador
                = new HistoricoProcessadorImpl();

        maquina.findMaquina();
        disco.findDisco();
        processador.findProcessador();
        ram.findRam();

        histDisco.findHistoricoDisco();
        histProcessador.findHistoricoProcessador();

    }
}
