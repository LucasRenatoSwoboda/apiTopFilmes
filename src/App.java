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
        String urlApi = UrlApi.retornaURL(2);
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
        System.out.println(FormatarFonte.mudaDestaqueFonte("FILMES", 1) +
                FormatarFonte.getREDEFINIR());
        for (Map<String, String> filme : listaDeFilmes) {

            System.out.print("Título: ");
            System.out.println(FormatarFonte.mudaDestaqueFonte(filme.get("title"), 1) + FormatarFonte.getREDEFINIR());
            System.out.print("Poster: ");
            System.out.println(FormatarFonte.mudaDestaqueFonte(filme.get("image"), 1) + FormatarFonte.getREDEFINIR());
            System.out.print(FormatarFonte.mudaCorDestaqueFonteCorFundo("Classificação: ", 7, 1, 6));
            System.out.println(filme.get("imDbRating") + FormatarFonte.getREDEFINIR() + "\n");
        }

        // Desafios propostos na aula

        // 1 - Mudar a visualização do terminal com o resultado (Exibir cores e estrela)
        // Criei classe FormatarFonte onde trabalha com cores padrões
        // (Pode melhorar usando outros padrões de formatação de cores) ver link:
        // https://www.alura.com.br/artigos/decorando-terminal-cores-emojis
        // Criei classe Emotion, porém no meu terminal não está funcionando os testes
        // que fiz.

        // 2 - Esconder a chave da URL pois é uma chave particular (buscar de um arquivo
        // de configuração)
        // Tentei criar um arquivo de configuração ini, mas não consegui fazer a leitura
        // do arquivo para escolher a chave
        // Criei nova classe UrlApi que vai retornar a chave 1 ou 2 para leitura
        // (ajudará no limite de teste diário)

        // 3 - Usar uma outra biblioteca como Jackson ou outra para fazer o parseamento

        // 4 - Criar método para o usuário avaliar o filme

    }
}
