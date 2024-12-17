package services.request;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

import utils.Log;

public class RequestService {

    private final HttpClient client;

    public RequestService() {
      this.client = HttpClient.newHttpClient();
    }

    public String get(String url, Map<String, String> headers) throws RequestError, IOException, InterruptedException {
        Log.info("REQUEST_SERVICE", "GET request to " + url);
        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder().uri(URI.create(url)).GET();
        if (headers != null) {
            headers.forEach(requestBuilder::header);
        }

        HttpRequest request = requestBuilder.build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() >= 200 && response.statusCode() < 300) {
            Log.info("REQUEST_SERVICE", "GET request to " + url + " was successful");
            return response.body();
        } else {
            Log.error("REQUEST_SERVICE", "GET request to " + url + " failed with status code: " + response.statusCode());
            throw new RequestError("Request failed with status code: " + response.statusCode());
        }
    }

    public String post(String url, String body, Map<String, String> headers) throws RequestError, IOException, InterruptedException {
        Log.info("REQUEST_SERVICE", "POST request to " + url);
        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder().uri(URI.create(url)).POST(HttpRequest.BodyPublishers.ofString(body));
                
        if (headers != null) {
            headers.forEach(requestBuilder::header);
        }
         
        HttpRequest request = requestBuilder.build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() >= 200 && response.statusCode() < 300) {
            Log.info("REQUEST_SERVICE", "POST request to " + url + " was successful");
            return response.body();
        } else {
            Log.error("REQUEST_SERVICE", "POST request to " + url + " failed with status code: " + response.statusCode());
            throw new RequestError("Request failed with status code: " + response.statusCode());
        }
    }

    public String put(String url, String body, Map<String, String> headers) throws RequestError, IOException, InterruptedException {
        Log.info("REQUEST_SERVICE", "PUT request to " + url);
        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder().uri(URI.create(url)).PUT(HttpRequest.BodyPublishers.ofString(body));

        if (headers != null) {
            headers.forEach(requestBuilder::header);
        }

        HttpRequest request = requestBuilder.build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() >= 200 && response.statusCode() < 300) {
            Log.info("REQUEST_SERVICE", "PUT request to " + url + " was successful");
            return response.body();
        } else {
            Log.error("REQUEST_SERVICE", "PUT request to " + url + " failed with status code: " + response.statusCode());
            throw new RequestError("Request failed with status code: " + response.statusCode());
        }
    }

    public String delete(String url, Map<String, String> headers) throws RequestError, IOException, InterruptedException {
        Log.info("REQUEST_SERVICE", "DELETE request to " + url);
        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder().uri(URI.create(url)).DELETE();
        
        if (headers != null) {
            headers.forEach(requestBuilder::header);
        }

        HttpRequest request = requestBuilder.build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    
       if (response.statusCode() >= 200 && response.statusCode() < 300) {
            Log.info("REQUEST_SERVICE", "DELETE request to " + url + " was successful");
           return response.body();
       } else {
            Log.error("REQUEST_SERVICE", "DELETE request to " + url + " failed with status code: " + response.statusCode());
           throw new RequestError("Request failed with status code: " + response.statusCode());
       }
    }
}