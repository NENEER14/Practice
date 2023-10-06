//780 miliseconds
class SampleClass extends Thread {
	
	public synchronized void run() {
		for(int i = 0; i < 5; i++) {
			try {
				sleep(100);
			} catch(Exception e) {
				e.printStackTrace();
			}
			//System.out.println("Thread class");
		}
	}
}


public class MultiThreadingTask {
	public static void main(String args[]) throws InterruptedException {
		SampleClass sc1 = new SampleClass();
		long time1 = System.currentTimeMillis();
		Thread th1 = new Thread(sc1);
		///*
		Thread th2 = new Thread(sc1);
		Thread th3 = new Thread(sc1);
		Thread th4 = new Thread(sc1);
		Thread th5 = new Thread(sc1);
		Thread th6 = new Thread(sc1);
		Thread th7 = new Thread(sc1);
		Thread th8 = new Thread(sc1);
		Thread th9 = new Thread(sc1);
		Thread th10 = new Thread(sc1);
		//*/
		th1.start();
		/*
		th2.start();
		th3.start();
		th4.start();
		th5.start();
		th6.start();
		th7.start();
		th8.start();
		th9.start();
		th10.start();
		*/
		th1.join();
		/*
		th2.join();
		th3.join();
		th4.join();
		th5.join();
		th6.join();
		th7.join();
		th8.join();
		th9.join();
		th10.join();
		*/
		//System.out.println("Total Exec time :"+ (System.nanoTime() - time1));
		/*
		ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
		exec.scheduleAtFixedRate(new Runnable() {
		  @Override
		  public void run() {
		    // do stuff
		  }
		}, 0, 50, TimeUnit.SECONDS);
		*/
		System.out.println("Total Exec time :"+ (System.currentTimeMillis() - time1));
		
	}
}
