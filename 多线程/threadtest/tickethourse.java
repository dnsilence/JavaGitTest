package threadtest;

public class tickethourse implements Runnable{

	private int fivecount = 1, tencount = 0, twentycount = 0;
	
	//同步方法
	public synchronized void buy() {
		
		
			
		String name = Thread.currentThread().getName();
		
		//zf:20元
		if("zf".equals(name)) {
			if(fivecount<3) {
				try {
					System.out.println("张飞必须等待");
					wait();
					System.out.println("卖一张票给张飞，找零15");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}else if("gy".equals(name)) {
		
			fivecount++;
			System.out.println("卖一张票给关羽,5元面值"+fivecount);
		
		}else if("lb".equals(name)) {
		
			fivecount++;
			System.out.println("卖一张票给刘备,5元面值"+fivecount);
		
		}
		
		if(fivecount == 3)
		notifyAll();
		
	}
	@Override
	public void run() {
		
		buy();
		
	}
	
	public static void main(String[] args) {
		
		tickethourse r1 = new tickethourse();
		
		Thread th1 = new Thread(r1);
		Thread th2 = new Thread(r1);
		Thread th3 = new Thread(r1);
		
		th1.setName("zf");
		th2.setName("gy");
		th3.setName("lb");
		
		
		th2.start();
		th3.start();
		th1.start();
	}

	
}
