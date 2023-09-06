package lesson12Task1;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WebsiteSaver {
    public static void main(String[] args) throws Exception {
        String url = "https://en.wikipedia.org/wiki/Main_Page";
        String filename = "Data";

        HttpClient httpClient = HttpClient.newBuilder().build();

        HttpRequest httpRequest =
                HttpRequest.newBuilder(new URI(url))
                        .GET()
                        .build();

        HttpResponse<String> httpResponse = httpClient
                .send(httpRequest, HttpResponse.BodyHandlers.ofString());

        int statusCode = httpResponse.statusCode();
        String content = httpResponse.body();


        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
            System.out.println("Web page saved as " + filename);
        } catch (IOException e) {
            System.out.println("problem with saving a file!! " + e.getMessage());
        }


        System.out.println(statusCode);
        System.out.println(httpResponse.headers());
        System.out.println(content);
    }
}
