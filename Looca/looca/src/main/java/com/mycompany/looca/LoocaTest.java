package com.mycompany.looca;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.discos.Volume;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.processos.Processo;
import com.github.britooo.looca.api.group.processos.ProcessosGroup;
import com.github.britooo.looca.api.group.servicos.Servico;
import com.github.britooo.looca.api.group.servicos.ServicosGroup;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.group.temperatura.Temperatura;
import com.github.britooo.looca.api.util.Conversor;
import java.util.List;

public class LoocaTest {

    public static void main(String[] args) {
        Looca looca = new Looca();

        Sistema sistema = looca.getSistema();
        Memoria memoria = looca.getMemoria();
        Processador processador = looca.getProcessador();
        Temperatura temperatura = looca.getTemperatura();
        DiscosGroup grupoDeDiscos = looca.getGrupoDeDiscos();
        ServicosGroup grupoDeServicos = looca.getGrupoDeServicos();
        ProcessosGroup grupoDeProcessos = looca.getGrupoDeProcessos();

////////////////////////////////////////////////////////////////////////////////
//      Sistema
//
//        System.out.println(sistema.getArquitetura());
//        System.out.println(sistema.getFabricante());
//        System.out.println(sistema.getInicializado());
//        System.out.println(sistema.getPermissao());
//        System.out.println(sistema.getSistemaOperacional());
//        System.out.println(sistema.getTempoDeAtividade());
//        System.out.println(sistema.toString());
//
////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////
//      Memoria
//
//        System.out.println(memoria.getDisponivel());
//        System.out.println(memoria.getEmUso());
//        System.out.println(memoria.getTotal());
//        System.out.println(memoria.toString());
//
////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////
//      Processador
//
//        System.out.println("Fabricante: " + processador.getFabricante());
//        System.out.println("Frequencia: " + processador.getFrequencia());
//        System.out.println("Id: " + processador.getId());
//        System.out.println("Identificador: " + processador.getIdentificador());
//        System.out.println("Microarquitetura: " + processador.getMicroarquitetura());
//        System.out.println("Nome: " + processador.getNome());
//        System.out.println("Cpus Fisicas: " + processador.getNumeroCpusFisicas());
//        System.out.println("Cpu Logicas: " + processador.getNumeroCpusLogicas());
//        System.out.println("Pacotes Fisicos: " + processador.getNumeroPacotesFisicos());
//        System.out.println("Uso: " + processador.getUso());
//        System.out.println(processador.toString());
//
////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////
//      Temperatura  
//
        System.out.println(temperatura);
//
////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////
//      Grupo de Discos
//
//        List<Volume> volumes = grupoDeDiscos.getVolumes();
        List<Disco> discos = grupoDeDiscos.getDiscos();
//        
//        Integer quantidadeDeDiscos = grupoDeDiscos.getQuantidadeDeDiscos();;
//        Integer quantidadeDeVolumes = grupoDeDiscos.getQuantidadeDeVolumes();
//        Long tamanhoTotal = grupoDeDiscos.getTamanhoTotal();
//        
//      
//        for (Disco disco : discos) {
//            System.out.println(disco.getBytesDeEscritas());
//        }
//
//        for (Disco disco : discos) {
//            System.out.println(disco.getBytesDeLeitura());
//        }
//        
//        for (Disco disco : discos) {
//            System.out.println(disco.getEscritas());
//        }
//        
//        for (Disco disco : discos) {
//            System.out.println(disco.getLeituras());
//        }
//        
//        for (Disco disco : discos) {
//            System.out.println(disco.getModelo());
//        }
//        
//        for (Disco disco : discos) {
//            System.out.println(disco.getNome());
//        }
//
//        for (Disco disco : discos) {
//            System.out.println(disco.getSerial());
//        }
//
//        for (Disco disco : discos) {
//            System.out.println(disco.getTamanho());
//        }
//
//        for (Disco disco : discos) {
//            System.out.println(disco.getTamanhoAtualDaFila());
//        }
//
//        for (Disco disco : discos) {
//            System.out.println(disco.getTempoDeTransferencia());
//        }
//        
        for (Disco disco : discos) {
            System.out.println(disco.toString());
        }
//        
//        for (Volume volume : volumes){
//            System.out.println(volume.getDisponivel());
//        }
//       
//        for (Volume volume : volumes){
//            System.out.println(volume.getPontoDeMontagem());
//        }
//      
//        for (Volume volume : volumes){
//            System.out.println(volume.getTipo());
//        }
//
//        for (Volume volume : volumes){
//            System.out.println(volume.getTotal());
//        }
//        
//        for (Volume volume : volumes){
//            System.out.println(volume.getUUID());
//        }
//        
//        System.out.println("Quantidade de discos: " + quantidadeDeDiscos);
//        System.out.println("Quantidade de volumes: " + quantidadeDeVolumes);
//        System.out.println("Tamanho total: " + tamanhoTotal);
//        
////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////
//      Grupo de serviços
//
//        List<Servico> servicos = grupoDeServicos.getServicos();
//        List<Servico> servicos = grupoDeServicos.getServicosAtivos();
//        List<Servico> servicos = grupoDeServicos.getServicosInativos();
//
//        Integer totalServicos = grupoDeServicos.getTotalDeServicos();
//        Integer totalServicosAtivos = grupoDeServicos.getTotalServicosAtivos();
//        Integer totalServicosInativos = grupoDeServicos.getTotalServicosInativos();
//        
//        for (Servico servico : servicos) {
//            System.out.println(servico.getNome());
//        }
//
//          for (Servico servico : servicos) {
//            System.out.println(servico.getPid());
//          }
//          
//          for (Servico servico : servicos) {
//            System.out.println(servico.getEstado());
//          }
//
//        System.out.println("Total de serviços: " + totalServicos);
//        System.out.println("Total de serviços ativos: " + totalServicosAtivos);
//        System.out.println("Total de serviços inativos: " + totalServicosInativos);
//
////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////
//      Grupo de processos
//      List<Processo> processos = grupoDeProcessos.getProcessos();
//      Integer totalProcessos = grupoDeProcessos.getTotalProcessos();
//      Integer totalThreads = grupoDeProcessos.getTotalThreads();
//      String processo = grupoDeProcessos.toString();
//
//        for (Processo processo : processos) {
//            System.out.println(processo.getBytesUtilizados()+"\n");
//        }
//        
//        for (Processo processo : processos) {
//            System.out.println(processo.getMemoriaVirtualUtilizada()+"\n");
//        }
//        
//        for (Processo processo : processos) {
//            System.out.println(processo.getNome()+"\n");
//        }
//        
//        for (Processo processo : processos) {
//            System.out.println(processo.getPid()+"\n");
//        }
//        
//        for (Processo processo : processos) {
//            System.out.println(processo.getUsoCpu()+"\n");
//        }
//        
//        for (Processo processo : processos) {
//            System.out.println(processo.getUsoMemoria()+"\n");
//        }
//        
//        for (Processo processo : processos) {
//            System.out.println(processo.toString()+"\n");
//        }
//        System.out.println(totalProcessos);
//        System.out.println(totalThreads);
//        System.out.println(processo);
//
////////////////////////////////////////////////////////////////////////////////
    }
}
