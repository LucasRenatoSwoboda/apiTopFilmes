import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        // Fazer comunicação HTTP
        String urlApi = "https://imdb-api.com/en/API/Top250Movies/k_ykhu4ypa";
        URI encereco = URI.create(urlApi);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(encereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        // Extrair os dados que interessam
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = body;

        // Exibir e manipular os dados

    }
}
