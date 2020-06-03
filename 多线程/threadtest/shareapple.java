package threadtest;

/*
 * 练习：
 * 1、编写出一个安全的示例代码
 * 2.使用同步代码块解决线程安全的问题。
 */

public class shareapple implements Runnable{

	private int applecount = 5;

	//拿苹果
	boolean getApple() {
		
		synchronized(this) {
			
		
		if(applecount>0) {
			applecount--;
			System.out.print(Thread.currentThread().getName()+
					"拿走了一个苹果。");
			System.out.println("还剩下"+applecount+"个苹果");
			return true;
		}
		
		return false;
		}
	}
	
	//线程体
	@Override
	public void run() {
		
		boolean flag = getApple();
		while(flag) {
			flag = getApple();
		}
		System.out.println(Thread.currentThread().getName()+
				"线程结束了");
		
	}
	
	public static void main(String[] args) {
		
		
		System.out.println("这里有五个苹果");
		shareapple a1 = new shareapple();
		
		Thread th1 = new Thread(a1);
		Thread th2 = new Thread(a1);
		
		th1.setName("香酒酒");
		th2.setName("臭宁宁");
		
		th1.start();
		th2.start();
		
	}
	
}
