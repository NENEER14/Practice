import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class CompletableFutureExample {
	public static void main(String[]  args) throws InterruptedException, ExecutionException {
		CompletableFuture<String> completableFuture = new CompletableFuture<>();
		
		
		Executors.newFixedThreadPool(5).submit(() -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			completableFuture.complete("hello");
			return completableFuture;
		});
		
		//thenApply
		CompletableFuture<String> comFut = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e){
				e.printStackTrace();
			}
			return "world";
		}).thenApply(msg -> "hello "+ msg);
		System.out.println(comFut.get());
		
		//thenAccpet
		CompletableFuture<Void> compFut = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "world";
		}).thenAccept(msg -> System.out.println("hello " + msg));
		
		System.out.println(compFut.get());
		
		//thenRun
		CompletableFuture<Void> compFut2 = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "world";
		}).thenRun(() -> System.out.println("Completed after two seconds"));
		System.out.println(compFut2.get());
		
	}
}
