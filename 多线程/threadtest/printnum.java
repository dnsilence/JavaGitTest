package threadtest;

/*
 * 练习：不考虑线程安全的问题：
 * 
 * 使用Thread类创建两个线程，共同打印1-100，不是单独打印0-99，而是合作实现
 * 
 * 
 */
public class printnum {
	
	int i = 0;//创建全局变量

	public static void main(String[] args) {
		
		printnum pr = new printnum();
		numthread th1 = new numthread("线程1+",pr);
		numthread th2 = new numthread("线程2+",pr);//创建了两个线程对象,他们共用同一个对象，则共同同一个i
		
	
		th1.start();
		th2.start();//启动线程
	}
	
}

 class numthread extends Thread{
	 
	 printnum pr;
	 public numthread(String name,printnum pr) {
		 
		 super(name);
		 
		 this.pr = pr;
	 }
	 
	@Override
	public void run() {
		 for(; pr.i <100;pr.i++) {
				
				System.out.print(Thread.currentThread().getName());
				System.out.println(pr.i);
			}
	}
 }