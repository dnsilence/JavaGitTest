package threadtest;

public class myrunnable implements Runnable {

	int i = 0;
	@Override
	public void run() {
		for(; i <100;i++) {
			try {
				Thread.sleep(100);//½øÈë×èÈû×´Ì¬
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print(Thread.currentThread().getName()+":");
			System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		
		myrunnable mr = new myrunnable();
		
		Thread th1 = new Thread(mr);
		Thread th2 = new Thread(mr);
		
		th1.start();
		th2.start();
	}

}
