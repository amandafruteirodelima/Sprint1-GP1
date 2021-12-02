package slack;

public class IntegracaoSlackApp {
    
    public static void main(String[] args) {
        
        IntegracaoSlack integracao = new IntegracaoSlack();
        
//        integracao.enviarMensagem("SALVE RAPAZIADA, BOM FIM DE SEMANA A TODOS!");
        
        integracao.pegarDadosDisco(15.0, 8);
    }
}