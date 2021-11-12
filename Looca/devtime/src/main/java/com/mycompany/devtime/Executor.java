package com.mycompany.devtime;

import com.github.britooo.looca.api.core.Looca;
import entities.FuncionarioEntity;
import entities.MaquinaEntity;
import implantation.DiscoImpl;
import implantation.HistoricoDiscoImpl;
import implantation.HistoricoProcessadorImpl;
import implantation.HistoricoRamImpl;
import implantation.MaquinaImpl;
import implantation.MaquinaSoftwareImpl;
import implantation.ProcessadorImpl;
import implantation.RamImpl;
import implantation.SoftwareImpl;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
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
    MaquinaSoftwareImpl maquinaSoftware = new MaquinaSoftwareImpl();
    SoftwareImpl software = new SoftwareImpl();
    MaquinaEntity maquinaInstance = MaquinaEntity.getInstance();
    FuncionarioEntity funcionario = FuncionarioEntity.getInstance();
    Timer timer = new Timer();

    public void Executor() {

        List<MaquinaEntity> maquinaid = assistente.query("Select idMaquina"
                + " from Maquina where fk_Funcionario = '"
                + funcionario.getIdFuncionario() + "'",
                new BeanPropertyRowMapper<>(MaquinaEntity.class));
        MaquinaEntity maquinaDaVez = null;
        for (int i = 0; i < maquinaid.size(); i++) {
            maquinaDaVez = maquinaid.get(i);
        }

        if (maquinaDaVez == null) {
            maquina.findMaquina();
            disco.findDisco();
            processador.findProcessador();
            ram.findRam();
        }

        if (maquinaInstance.getIdMaquina() == null) {
            maquinaInstance.instanciarMaquina();
        }
        
        coletarLeitura();
//        software.findSoftware();
//        maquinaSoftware.findMaquinaSoftware();
    }

    public void coletarLeitura() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                histProcessador.findHistoricoProcessador();
                histRam.findHistoricoRam();
                 histDisco.findHistoricoDisco();
            }
        }, 1000, 5000);
    }
}
