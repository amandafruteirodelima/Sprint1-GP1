package slack;

import com.github.seratch.jslack.Slack;
import com.github.seratch.jslack.api.webhook.Payload;
import com.github.seratch.jslack.api.webhook.WebhookResponse;

public class IntegracaoSlack {
    
    private String webHooksURL = "https://hooks.slack.com/services/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";
    private String token = "xoxb-2750374347075-2762998716865-KnH4Bcg0A1Py6IMJ3O4JyfqQ";
    private String canalSlack = "integracao-slack";

    public void enviarMensagem(String mensagem) {

        try {
            StringBuilder mensagemBuilder = new StringBuilder();

            mensagemBuilder.append(mensagem);

            Payload payload = Payload.builder().channel(canalSlack).text(mensagemBuilder.toString()).build();

            WebhookResponse wbResp = Slack.getInstance().send(webHooksURL, payload);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
