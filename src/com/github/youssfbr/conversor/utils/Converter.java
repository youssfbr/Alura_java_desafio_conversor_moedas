package com.github.youssfbr.conversor.utils;

import com.github.youssfbr.conversor.dtos.CurrencyDTO;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Converter {
    private static final String YOUR_API_KEY = System.getenv("YOUR_API_KEY");

    public CurrencyDTO getConverter(String currency) {

        URI uri = URI.create("https://v6.exchangerate-api.com/v6/" + YOUR_API_KEY + "/latest/" + currency);

        try (HttpClient client = HttpClient.newHttpClient()) {

            HttpRequest request = HttpRequest.newBuilder().uri(uri).build();

            HttpResponse<String> response = client
                    .send(request , HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body() , CurrencyDTO.class);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
