package com.mycompany.devtime;

import implantation.DiscoImpl;
import implantation.HistoricoDiscoImpl;
import implantation.HistoricoProcessadorImpl;
import implantation.HistoricoRamImpl;
import implantation.MaquinaImpl;
import implantation.MaquinaSoftwareImpl;
import implantation.ProcessadorImpl;
import implantation.RamImpl;
import implantation.SoftwareImpl;

public class Executor {

    public void Executor() {

        MaquinaImpl maquina = new MaquinaImpl();
        DiscoImpl disco = new DiscoImpl();
        ProcessadorImpl processador = new ProcessadorImpl();
        RamImpl ram = new RamImpl();
        HistoricoDiscoImpl histDisco = new HistoricoDiscoImpl();
        HistoricoProcessadorImpl histProcessador
                = new HistoricoProcessadorImpl();
        HistoricoRamImpl histRam = new HistoricoRamImpl();
        MaquinaSoftwareImpl maquinaSoftware = new MaquinaSoftwareImpl();
        SoftwareImpl software = new SoftwareImpl();

        maquina.findMaquina();
        disco.findDisco();
        processador.findProcessador();
        ram.findRam();

        histDisco.findHistoricoDisco();
        histProcessador.findHistoricoProcessador();
        histRam.findHistoricoRam();
        maquinaSoftware.findMaquinaSoftware();
        software.findSoftware();
    }
}
