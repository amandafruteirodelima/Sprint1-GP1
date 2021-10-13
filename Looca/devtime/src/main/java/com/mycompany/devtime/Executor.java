package com.mycompany.devtime;

import implantation.DiscoImpl;
import implantation.HistoricoDiscoImpl;
import implantation.MaquinaImpl;
import implantation.ProcessadorImpl;
import implantation.RamImpl;

public class Executor {
    public static void main(String[] args) {
        
        MaquinaImpl maquina = new MaquinaImpl();
        DiscoImpl disco = new DiscoImpl();
        ProcessadorImpl processador = new ProcessadorImpl();
        RamImpl ram = new RamImpl();
        HistoricoDiscoImpl histDisco = new HistoricoDiscoImpl();
        
        maquina.findMaquina();
        disco.findDisco();
        processador.findProcessador();
        ram.findRam();
        
        histDisco.findHistoricoDisco();
        
        
    }
}
