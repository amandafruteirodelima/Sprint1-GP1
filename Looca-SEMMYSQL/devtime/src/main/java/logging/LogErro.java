package logging;

import com.github.britooo.looca.api.core.Looca;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.File;


public class LogErro {
    
    VersaoApp versao = new VersaoApp();
    Looca looca = new Looca();
    
    public void mensagemErroSelect(Exception erro) {
        
        FileWriter fileWriter = null;
        
        try {
            File arquivoSelecao = new File("Historico-Erro-Select-Banco.txt");
            DateTimeFormatter dataCorreta = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            fileWriter = new FileWriter(arquivoSelecao, true);
            BufferedWriter escrever = new BufferedWriter(fileWriter);
            String original = erroEstilo()
                    + "\nMomento do erro: " + dataCorreta.format(LocalDateTime.now())
                    + "\nVersão da Aplicação: " + versao.pegarVersaoApp()
                    + "\n" + looca.getSistema()
                    + "\nERRO: " + erro + "\n\n";
            String textoCompleto = original.replaceAll(";", "\n");
            escrever.write(textoCompleto);
            escrever.newLine();
            escrever.close();
            fileWriter.close();
        } catch (Exception erroEnviarDados) {
            System.out.println(""
                    + "Erro ao tentar enviar os dados para o arquivo"
                    + "Historico-Erro-Select-Banco.txt");
        } finally {
            System.out.println("ERRO");
        }
    }
    
    public void mensagemErroInsert(Exception erro) {
        
        FileWriter fileWriter = null;
        try {
            File arquivoSelecao = new File("Historico-Erro-Insert-Banco.txt");
            DateTimeFormatter dataCorreta = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            fileWriter = new FileWriter(arquivoSelecao, true);
            BufferedWriter escrever = new BufferedWriter(fileWriter);
            String original = erroEstilo()
                    + "\nMomento do erro: " + dataCorreta.format(LocalDateTime.now())
                    + "\nVersão da Aplicação: " + versao.pegarVersaoApp()
                    + "\n" + looca.getSistema()
                    + "\nERRO: " + erro + "\n\n";
            String textoCompleto = original.replaceAll(";", "\n");
            escrever.write(textoCompleto);
            escrever.newLine();
            escrever.close();
            fileWriter.close();
        } catch (Exception erroEnviarDados) {
            System.out.println(""
                    + "Erro ao tentar enviar os dados para o arquivo"
                    + "Historico-Erro-Insert-Banco.txt");
        } finally {
            System.out.println("ERRO");
        }
    }

    private String erroEstilo() {
        return String.format("----------------------------------"
                + " ERRO "
                + "----------------------------------");
    }
}
