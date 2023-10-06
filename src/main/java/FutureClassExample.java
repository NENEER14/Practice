import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class Task implements Runnable {
	CyclicBarrier cb;
	public Task(CyclicBarrier cb) {
		this.cb = cb;
	}
	@Override
	public void run() {
		try {
			cb.await();
			cb.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}
}

class Workers implements Runnable {

	private CountDownLatch cdl;
	
	public Workers(CountDownLatch cdl) {
		this.cdl = cdl;
	}
	
	@Override
	public void run() {
		cdl.countDown();
		//Multiple countdown does not make difference
		cdl.countDown();
		cdl.countDown();
		cdl.countDown();
		cdl.countDown();
		cdl.countDown();
		System.out.println("Down one");
	}
	
}

public class FutureClassExample {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService execServ = Executors.newFixedThreadPool(5);
		Future<String> fuStr = execServ.submit(()-> {
			Thread.sleep(1000);
			return "hello";
		});
		try {
			fuStr.get(2, TimeUnit.SECONDS);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fuStr.cancel(true);
		System.out.println(fuStr.isDone());
		
		CountDownLatch cdl = new CountDownLatch(5);
		
		List<Thread> workers = Stream
				.generate(()-> new Thread(new Workers(cdl)))
				.limit(5)
				.collect(Collectors.toList());
		workers.forEach(Thread :: start);
	}
}
