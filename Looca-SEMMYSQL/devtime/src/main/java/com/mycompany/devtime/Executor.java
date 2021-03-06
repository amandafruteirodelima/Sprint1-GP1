package com.mycompany.devtime;

import com.github.britooo.looca.api.core.Looca;
import entities.FuncionarioEntity;
import entities.MaquinaEntity;
import entities.TempoLogado;
import implantation.DiscoImpl;
import implantation.HistoricoDiscoImpl;
import implantation.HistoricoProcessadorImpl;
import implantation.HistoricoRamImpl;
import implantation.MaquinaImpl;
import implantation.HistoricoUsoSoftwareImpl;
import implantation.ProcessadorImpl;
import implantation.RamImpl;
import implantation.SoftwareImpl;
import java.util.List;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import logging.LogErro;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class Executor {

    Looca looca = new Looca();

    ConfiguracaoBanco configuracaoBanco = new ConfiguracaoBanco();

    JdbcTemplate assistente = new JdbcTemplate(
            configuracaoBanco.getBancoDeDados());

    MaquinaImpl maquina = new MaquinaImpl();

    DiscoImpl disco = new DiscoImpl();

    ProcessadorImpl processador = new ProcessadorImpl();

    RamImpl ram = new RamImpl();

    HistoricoDiscoImpl histDisco = new HistoricoDiscoImpl();

    HistoricoProcessadorImpl histProcessador
            = new HistoricoProcessadorImpl();

    HistoricoRamImpl histRam = new HistoricoRamImpl();

    HistoricoUsoSoftwareImpl historicoSoftware = new HistoricoUsoSoftwareImpl();

    SoftwareImpl software = new SoftwareImpl();

    MaquinaEntity maquinaInstance = MaquinaEntity.getInstance();

    FuncionarioEntity funcionario = FuncionarioEntity.getInstance();

    TempoLogado logado = new TempoLogado();

    Timer timer = new Timer();

    LogErro logErro = new LogErro();

    public void Executor() {

        try {
            List<MaquinaEntity> maquinaid = assistente.query("Select *"
                    + " from Maquina where fk_Funcionario = '"
                    + funcionario.getIdFuncionario() + "'",
                    new BeanPropertyRowMapper<>(MaquinaEntity.class));
            MaquinaEntity maquinaDaVez = null;

            for (int i = 0; i < maquinaid.size(); i++) {
                maquinaDaVez = maquinaid.get(i);
            }

            if (Objects.isNull(maquinaDaVez)) {
                maquina.findMaquina();
                disco.findDisco();
                processador.findProcessador();
                ram.findRam();
                software.findSoftware();
            }

            if (Objects.isNull(maquinaInstance.getIdMaquina())) {
                maquinaInstance.instanciarMaquina();
            }

            tempoLogado();
            coletarLeitura();

        } catch (Exception erro) {
            logErro.mensagemErroSelect(erro);
        }

    }

    public void coletarLeitura() {
        histDisco.findHistoricoDisco();

        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                histProcessador.findHistoricoProcessador();
                histRam.findHistoricoRam();
                historicoSoftware.findHistoricoSoftware();
            }
        ;
        }; timer.schedule(tt, 1000, 7000);
    }

    public void tempoLogado() {
        TimerTask tl = new TimerTask() {
            @Override
            public void run() {
                System.out.println("-------------------------------------------");
                logado.insertMinuto();
            }
        ;
        }; timer.schedule(tl, 60000, 60000);
    }

}
