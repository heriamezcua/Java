package _03_intermediate_II._09_concurrence;

import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class _14_CompletableFuture {


	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(5);
		String urlString = "https://jsonplaceholder.typicode.com/todos/1"; // Example API

		// Asynchronous HTTP request using CompletableFuture
		CompletableFuture<HttpResponse<String>> futureResponse = fetchUrlContent(urlString);

		// Handling response asynchronously
		futureResponse.thenApply(HttpResponse::body)
				.thenAccept(response -> System.out.println("Received Response: " + response)).exceptionally(ex -> {
					System.out.println("Error occurred: " + ex.getMessage());
					return null;
				});

		// Custom CompletableFuture with supplyAsync
		CompletableFuture<String> customFuture = CompletableFuture.supplyAsync(() -> {
			try {
				TimeUnit.SECONDS.sleep(2);
				return "Processed Data";
			} catch (InterruptedException e) {
				throw new IllegalStateException(e);
			}
		}, executor);

		// Handling success or failure
		customFuture.whenComplete((result, error) -> {
			if (error == null) {
				System.out.println("Custom Task Result: " + result);
			} else {
				System.out.println("Custom Task Error: " + error.getMessage());
			}
		});

		// Combining multiple CompletableFutures
		CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
		CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "World");

		CompletableFuture<String> combinedFuture = future1.thenCombine(future2, (f1, f2) -> f1 + " " + f2);
		combinedFuture.thenAccept(System.out::println);

		// Using thenCompose to flatten nested CompletableFutures
		CompletableFuture<List<URL>> imageURLs = fetchUrlContent(urlString)
				.thenApply(response -> getImageURLs(response.body())).exceptionally(ex -> List.of());

		// Wait to ensure all async tasks complete before shutting down
		executor.shutdown();
	}

	// Fetch content from a URL asynchronously
	public static CompletableFuture<HttpResponse<String>> fetchUrlContent(String url) {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder(URI.create(url)).GET().build();
		return client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
	}

	// Simulated method to extract image URLs from page content
	public static List<URL> getImageURLs(String pageContent) {
		// Simulating image URL extraction
		return List.of();
	}
}

}
