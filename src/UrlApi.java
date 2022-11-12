
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public abstract class UrlApi {

    private static String url = "https://imdb-api.com/en/API/Top250Movies/";

    public static String retornaURL(int chave) {
        if (chave == 1) {
            url += "k_ykhu4ypa";
            return url;
        }
        if (chave == 2) {
            url += "k_2a9w6lm5";
            return url;
        }
        return url;
    }

}
