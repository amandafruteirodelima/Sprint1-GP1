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

public class Executor {

    public static void main(String[] args) {

        MaquinaImpl maquina = new MaquinaImpl();
        DiscoImpl disco = new DiscoImpl();
        ProcessadorImpl processador = new ProcessadorImpl();
        RamImpl ram = new RamImpl();
        HistoricoDiscoImpl histDisco = new HistoricoDiscoImpl();
        HistoricoProcessadorImpl histProcessador
                = new HistoricoProcessadorImpl();

        Scanner leitor = new Scanner(System.in);
        Integer teste = leitor.nextInt();
        if (teste == 1) {
            System.out.println("Area de teste");
        } else {
            maquina.findMaquina();
            disco.findDisco();
            processador.findProcessador();
            ram.findRam();

            histDisco.findHistoricoDisco();
            histProcessador.findHistoricoProcessador();
        }

    }
}
