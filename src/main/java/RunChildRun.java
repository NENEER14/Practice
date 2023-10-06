class SampleClass1 extends Thread {
//class SampleClass1 implements Runnable {	
	public void run() {
		System.out.println("This method is executed by: "+Thread.currentThread().getName());
	}
}

public class RunChildRun {
	public static void main (String[] args) {
		SampleClass1 sc1 = new SampleClass1();
		Thread th1 = new Thread(sc1);
		//sc1.start();
		//sc1.start();
		th1.run();
		sc1.run();
		//th1.start();
		
		Runnable r = new SampleClass1();
		Thread th2 = new Thread(r);
		//th2.start();
		th2.run();
	}

}
