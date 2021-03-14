package IOCaldades;

/**
 *
 * @author Xavi
 */
import IOCaltasques.Registre;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import javax.swing.JOptionPane;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONObject;
import org.springframework.http.HttpHeaders;

public class OperacionsServidor {

    static final String URL_SERVIDOR = "http://localhost:8080";

    private String respostaServidor;
    private CodiAccess codiAccess = null;
    Registre registre;
    HttpHeaders headers = new HttpHeaders();

    /**
     * @param dades les dades de l'dadesAcces que vol fer login
     * @return String
     */
    public String login(DadesAcces dades) throws MalformedURLException, IOException, InterruptedException {

        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper
                .writeValueAsString(dades);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL_SERVIDOR + "/login"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        respostaServidor = response.body();
        return respostaServidor;
        

    }

    /**
     * @param contrasenya la contrasenya que vol canviar l'dadesAcces
     *
     */
    public String canviarContrasenya(Contrasenya contrasenya, String codi) throws ClientProtocolException, IOException, InterruptedException {

        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(contrasenya);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL_SERVIDOR + "/canviarContrasenya/" + codi))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        respostaServidor = response.body();

        return respostaServidor;
//        }
    }

    /**
     * @param codi el respostaServidor que permet a l'dadesAcces mantenir la
     * sessió
     * @throws org.apache.http.client.ClientProtocolException
     * @throws java.lang.InterruptedException
     *
     */
    public void desconectar(String codiAccess) throws ClientProtocolException, IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL_SERVIDOR + "/logout/" + codiAccess))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

    }

    public String registrarUsuari(Usuari usuari) throws MalformedURLException, IOException, InterruptedException {

        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper
                .writeValueAsString(usuari);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL_SERVIDOR + "/registre"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        respostaServidor = response.body();
        if (response.statusCode() == 200) {
            return respostaServidor;

        } else {
            JSONObject object = new JSONObject(respostaServidor);
            String missatge = object.getString("message");
            JOptionPane.showMessageDialog(null, missatge);
            return respostaServidor;
        }
    }

}
