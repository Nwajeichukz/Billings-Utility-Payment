package com.example.springsecurityjpa.service;


import com.example.springsecurityjpa.configuration.AppConfig;
import com.example.springsecurityjpa.dto.AppResponse;
import com.example.springsecurityjpa.dto.BillsDto;
import com.example.springsecurityjpa.dto.BillsPaymentResponse;
import com.example.springsecurityjpa.exception.ApiException;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Service
public class BillsService {
    String apiUrl = AppConfig.getApiUrl();

    String billCategories = AppConfig.getApiCategory();

    String apiKey = AppConfig.getApiKey();

    public String createBill(BillsDto billsDto){
        HttpResponse<String> response = null;


        HttpClient httpClient = HttpClient.newHttpClient();

        // Create an HTTP request with POST method
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .header("Authorization", "Bearer " + apiKey)
                .header("Content-Type", "application/json")
                .POST(buildHttpRequestBodyFromMap(billsDto))
                .build();

        try {
            // Send the HTTP request and get the response
            response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            // Print the response status code and body
            System.out.println("Status Code: " + response.statusCode());
            log.info("--> THIS IS THE RESPONSE BODY {}", response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response.body();
    }


    public String getBillCategory(){
        HttpResponse<String> response = null;

        HttpClient httpClient = HttpClient.newHttpClient();

        // Create an HTTP request
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(billCategories))
                .header("Authorization", "Bearer " + apiKey)
                .header("Content-Type", "application/json")
                .GET()
                .build();

        try {
            // Send the HTTP request and get the response
            response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            // Print the response status code and body
            log.info("--> THIS IS THE RESPONSE BODY {}", response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response.body();
    }

    private static HttpRequest.BodyPublisher buildHttpRequestBodyFromMap(BillsDto data) {
        // Convert the Map to a JSON string
        String jsonBody = new Gson().toJson(data);

        // Build the request body
        return HttpRequest.BodyPublishers.ofString(jsonBody);
    }
}
