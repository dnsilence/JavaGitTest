package threadtest;

/*
 * ��ϰ���������̰߳�ȫ�����⣺
 * 
 * ʹ��Thread�ഴ�������̣߳���ͬ��ӡ1-100�����ǵ�����ӡ0-99�����Ǻ���ʵ��
 * 
 * 
 */
public class printnum {
	
	int i = 0;//����ȫ�ֱ���

	public static void main(String[] args) {
		
		printnum pr = new printnum();
		numthread th1 = new numthread("�߳�1+",pr);
		numthread th2 = new numthread("�߳�2+",pr);//�����������̶߳���,���ǹ���ͬһ��������ͬͬһ��i
		
	
		th1.start();
		th2.start();//�����߳�
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