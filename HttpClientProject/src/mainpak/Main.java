package mainpak;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.concurrent.CompletableFuture;

public class Main {

	public static void main(final String[] args) {
		
		try {
			final HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create("http://localhost:8080/math/add/3/4"))
					.GET()
					.build();
			
			final HttpClient client = HttpClient.newBuilder().build();
			
//			final HttpResponse<String> reponse = client.send(request, BodyHandlers.ofString());
//			
//			System.out.println(String.format("Status=%s Nachricht=%s", reponse.statusCode(), reponse.body()));
			
			
			final CompletableFuture<HttpResponse<String>> future =  client.sendAsync(request, BodyHandlers.ofString());
			
			future.thenAccept(reponse->System.out.println(String.format("Status=%s Nachricht=%s", reponse.statusCode(), reponse.body()))).join();
			
		} catch (final Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}
