import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Main {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://rickandmortyapi.com/api/character");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Affichez la réponse
            System.out.println("Réponse : " + response.toString());

            // Fermez la connexion
            conn.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}