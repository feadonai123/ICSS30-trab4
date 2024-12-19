package services.request;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

import utils.Log;
import utils.Format;

public class RequestService {

    private final HttpClient client;

    public RequestService() {
      this.client = HttpClient.newHttpClient();
    }

    public <T> T get(String url, Map<String, String> headers, Class<T> valueType) throws RequestError, IOException, InterruptedException {
        Log.info("REQUEST_SERVICE", "GET request to " + url);
        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder().uri(URI.create(url)).GET();
        if (headers != null) {
            headers.forEach(requestBuilder::header);
        } else {
            requestBuilder.header("Content-Type", "application/json");
        }

        HttpRequest request = requestBuilder.build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() >= 200 && response.statusCode() < 300) {
            Log.info("REQUEST_SERVICE", "GET request to " + url + " was successful");
            try{
                return Format.deserialize(response.body(), valueType);
            } catch (Exception e) {
                throw new RequestError("Erro ao deserializar objeto: " + e.getMessage());
            }
        } else {
            Log.error("REQUEST_SERVICE", "GET request to " + url + " failed with status code: " + response.statusCode());
            throw new RequestError("Request failed with status code: " + response.statusCode());
        }
    }

    public <T> T post(String url, Object body, Map<String, String> headers, Class<T> valueType) throws RequestError, IOException, InterruptedException {
        Log.info("REQUEST_SERVICE", "POST request to " + url);
        String bodyStr = null;
        try{
            bodyStr = Format.serialize(body);
        } catch (Exception e) {
            throw new RequestError("Erro ao serializar objeto");
        }
        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder().uri(URI.create(url)).POST(HttpRequest.BodyPublishers.ofString(bodyStr));
                
        if (headers != null) {
            headers.forEach(requestBuilder::header);
        } else {
            requestBuilder.header("Content-Type", "application/json");
        }
         
        HttpRequest request = requestBuilder.build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() >= 200 && response.statusCode() < 300) {
            Log.info("REQUEST_SERVICE", "POST request to " + url + " was successful");
            try{
                return Format.deserialize(response.body(), valueType);
            } catch (Exception e) {
                throw new RequestError("Erro ao deserializar objeto");
            }
        } else {
            Log.error("REQUEST_SERVICE", "POST request to " + url + " failed with status code: " + response.statusCode());
            throw new RequestError("Request failed with status code: " + response.statusCode());
        }
    }

    public <T> T put(String url, Object body, Map<String, String> headers, Class<T> valueType) throws RequestError, IOException, InterruptedException {
        Log.info("REQUEST_SERVICE", "PUT request to " + url);
        String bodyStr = null;
        try{
            bodyStr = Format.serialize(body);
        } catch (Exception e) {
            throw new RequestError("Erro ao serializar objeto");
        }
        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder().uri(URI.create(url)).PUT(HttpRequest.BodyPublishers.ofString(bodyStr));

        if (headers != null) {
            headers.forEach(requestBuilder::header);
        } else {
            requestBuilder.header("Content-Type", "application/json");
        }

        HttpRequest request = requestBuilder.build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() >= 200 && response.statusCode() < 300) {
            Log.info("REQUEST_SERVICE", "PUT request to " + url + " was successful");
            try{
                return Format.deserialize(response.body(), valueType);
            } catch (Exception e) {
                throw new RequestError("Erro ao deserializar objeto");
            }     
        } else {
            Log.error("REQUEST_SERVICE", "PUT request to " + url + " failed with status code: " + response.statusCode());
            throw new RequestError("Request failed with status code: " + response.statusCode());
        }
    }

    public <T> T delete(String url, Map<String, String> headers, Class<T> valueType) throws RequestError, IOException, InterruptedException {
        Log.info("REQUEST_SERVICE", "DELETE request to " + url);
        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder().uri(URI.create(url)).DELETE();
        
        if (headers != null) {
            headers.forEach(requestBuilder::header);
        } else {
            requestBuilder.header("Content-Type", "application/json");
        }

        HttpRequest request = requestBuilder.build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    
       if (response.statusCode() >= 200 && response.statusCode() < 300) {
            Log.info("REQUEST_SERVICE", "DELETE request to " + url + " was successful");
            try{
                return Format.deserialize(response.body(), valueType);
            } catch (Exception e) {
                throw new RequestError("Erro ao deserializar objeto");
            }
       } else {
            Log.error("REQUEST_SERVICE", "DELETE request to " + url + " failed with status code: " + response.statusCode());
           throw new RequestError("Request failed with status code: " + response.statusCode());
       }
    }
}