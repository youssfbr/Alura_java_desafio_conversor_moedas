package com.github.youssfbr.conversor.utils;

import com.github.youssfbr.conversor.dtos.ExchangeRate;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Converter {
    private static final String YOUR_API_KEY = System.getenv("YOUR_API_KEY");

    public ExchangeRate exchangeConverter(String baseCode , String targetCode , Double value) {

        URI uri = URI.create("https://v6.exchangerate-api.com/v6/"
                + YOUR_API_KEY + "/pair/" + baseCode + "/" + targetCode + "/" + value);

        try (HttpClient client = HttpClient.newHttpClient()) {

            HttpRequest request = HttpRequest.newBuilder().uri(uri).build();

            HttpResponse<String> response = client
                    .send(request , HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body() , ExchangeRate.class);

        } catch (JsonSyntaxException | IllegalStateException e) {
            throw new RuntimeException("JsonSyntaxException " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
