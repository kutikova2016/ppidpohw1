package com.example.ppidpo.server;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
@RequestMapping("/convert/from/RUB/to/USD")
public class publicBalancer {
    private int producer_id = 1;

    private void next_producer_id() {
        producer_id = producer_id % 3 + 1;
    }

    @GetMapping("/")
    public ResponseEntity getHand1(HttpServletRequest request) throws IOException {
        String value = request.getParameter("value");

        next_producer_id();

        URL url = new URL("http://localhost:8080/private/producer/a"+String.valueOf(producer_id)+"?value="+value);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        System.out.println(response.toString());
        return ResponseEntity.badRequest().body(response.toString());
    }
}
