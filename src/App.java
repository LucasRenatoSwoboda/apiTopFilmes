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
        // https://imdb-api.com/en/API/MostPopularMovies/k_ykhu4ypa (Filmes mais
        // populares, criar classe para gerir as escolhas da API a buscar)
        URI encereco = URI.create(urlApi);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(encereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        // Extrair os dados que interessam
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        // Exibir e manipular os dados
        for (Map<String, String> filme : listaDeFilmes) {
            System.out.println(filme.get("title"));
            System.out.println(filme.get("image"));
            System.out.println(filme.get("imDbRating"));
            System.out.println();
        }

        // Desafios propostos na aula

        // 1 - Mudar a visualização do terminal com o resultado (Exibir cores e estrela)

        // 2 - Esconder a chave da URL pois é uma chave particular (buscar de um arquivo
        // de configuração)

        // 3 - Usar uma outra biblioteca como Jackson ou outra para fazer o parseamento

        // 4 - Criar método para o usuário avaliar o filme

    }
}
