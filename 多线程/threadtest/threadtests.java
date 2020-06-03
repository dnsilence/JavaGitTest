package threadtest;

public class threadtests {
	
	/*
	 * 关于线程：
	 * 1.在JAVA中，Thread类代表一个线程
	 * 
	 * 
	 * 2.实现线程有两种方式：
	 * 2.1继承thread类
	 * 2.2实现runnable接口
	 * 
	 * 
	 * 3.继承thread类：
	 * 3.1必须重写run方法，里面放的是实际的线程体
	 * 
	 * 4.启动线程
	 * 4.1创建thread对象
	 * 4.2调用对象的start方法启动，而不是run方法
	 * 
	 * 5.实现runnable接口的方式：
	 * 5.1创建实现接口的实现类
	 * 5.2创建5.1的对应的Runnable接口的实现类对象
	 * 5.3创建thread对象，利用thread（runnable t）
	 * 5.4调用start方法启动
	 * 
	 * 
	 * 6.线程声明周期相关的几个方法：
	 * 6.1 yield（）方法：若当前线程调用该方法，则由执行状态变为可运行状态。
	 * 6.2 join()方法：当前线程调用另一个线程的该方法，当前线程进入阻塞状态，当另一个线程执行完毕时，此线程回到可执行状态
	 * 6.3 sleep（）方法：使当前线程休眠一段时间，以毫秒为单位
	 * 
	 * 
	 * 7.线程安全的问题：
	 * 7.1 理解并编写出线程不安全的示例代码：多个线程访问一个共享的资源，若每个资源都有单独的副本则不存在这个问题
	 * 7.2 使用synchronized 代码块解决线程安全的问题：需要在代码块中参照共同的一个对象（this)
	 * 
	 * 8.关于线程通信
	 * 8.1 wait()/notify()/notifyall()
	 * 8.2 这些方法在 同步方法中 调用
	 */
	public static void main(String[] args) throws InterruptedException {
		
		//1.创建线程对象
		Thread th = new firstthread("baobaojiu");
		//2.调用线程对象的start方法启动线程
		th.start();
		System.out.println(th.isAlive());
		for(int i = 0; i <100;i++) {
			
			System.out.print(Thread.currentThread().getName());
			System.out.println(i);
			
			if(i==10) {
				th.join();//调用其它线程的join方法，当前线程进入阻塞状态
			}
		}
	System.out.println(th.isAlive());
	}
}

class firstthread extends Thread{
	
	public firstthread(String name) {
		super(name);
	}
	/*
	 * 线程体在run（）方法中
	 * 
	 */
	@Override
	public void run() {
		for(int i = 0; i <100;i++) {
			
			System.out.print(Thread.currentThread().getName());
			System.out.println(i);
		}
	}
}
