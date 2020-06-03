package threadtest;

public class printletters implements Runnable {

	private char c = 'a';
	
	public boolean print() {
		synchronized(this) {
		if(c<='z') {
			System.out.println(Thread.currentThread().getName()
					+":"+c);
			c++;
			
			notify();//唤醒下一个
			
			try {
				wait();//当前的停下来
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
			
		}
		return false;
	}
	}
	@Override
	public void run() {
		
		boolean flag = print();
		while(flag) {
			flag = print();
		}
		
	}

	
	public static void main(String[] args) {
		
		printletters p1 = new printletters();
		
		Thread th1 = new Thread(p1);
		Thread th2 = new Thread(p1);
		
		th1.setName("线程1");
		th2.setName("线程2");
		
		th1.start();
		th2.start();
	}
}
