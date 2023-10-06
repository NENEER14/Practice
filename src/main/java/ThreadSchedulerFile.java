class Mythread extends Thread{
   @Override
   public void run() {
        for(int i=0;i<100;i++){
          System.out.println("This is from child: "+i);
        }
    }
}

public class ThreadSchedulerFile {
    public static void main(String[] args) {
        Mythread mythread=new Mythread();
        mythread.start();
      
      for(int i=0;i<100;i++){
          System.out.println("This is from parent: "+i);
        }
    }
}
