import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import java.util.Random;

public class Client {
    private static final String URL = "http://localhost:8080/convert/from/RUB/to/USD/?value=%d";
    private final Random random = new Random();

    public static void main(String[] args) {
        while (true) {
            int value = random.nextInt(141) + 60; // генерируем случайное значение от 60 до 200
            String url = String.format(URL, value); // формируем URL с параметром value

            try {
                URL url = new URL(URL);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");

                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String response = in.readLine();
                System.out.println(response);
                in.close();

                Thread.sleep(4000); // Подождать 5 секунд перед следующим запросом

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }