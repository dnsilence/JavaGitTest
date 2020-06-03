package threadtest;

public class threadtests {
	
	/*
	 * �����̣߳�
	 * 1.��JAVA�У�Thread�����һ���߳�
	 * 
	 * 
	 * 2.ʵ���߳������ַ�ʽ��
	 * 2.1�̳�thread��
	 * 2.2ʵ��runnable�ӿ�
	 * 
	 * 
	 * 3.�̳�thread�ࣺ
	 * 3.1������дrun����������ŵ���ʵ�ʵ��߳���
	 * 
	 * 4.�����߳�
	 * 4.1����thread����
	 * 4.2���ö����start����������������run����
	 * 
	 * 5.ʵ��runnable�ӿڵķ�ʽ��
	 * 5.1����ʵ�ֽӿڵ�ʵ����
	 * 5.2����5.1�Ķ�Ӧ��Runnable�ӿڵ�ʵ�������
	 * 5.3����thread��������thread��runnable t��
	 * 5.4����start��������
	 * 
	 * 
	 * 6.�߳�����������صļ���������
	 * 6.1 yield��������������ǰ�̵߳��ø÷���������ִ��״̬��Ϊ������״̬��
	 * 6.2 join()��������ǰ�̵߳�����һ���̵߳ĸ÷�������ǰ�߳̽�������״̬������һ���߳�ִ�����ʱ�����̻߳ص���ִ��״̬
	 * 6.3 sleep����������ʹ��ǰ�߳�����һ��ʱ�䣬�Ժ���Ϊ��λ
	 * 
	 * 
	 * 7.�̰߳�ȫ�����⣺
	 * 7.1 ��Ⲣ��д���̲߳���ȫ��ʾ�����룺����̷߳���һ���������Դ����ÿ����Դ���е����ĸ����򲻴����������
	 * 7.2 ʹ��synchronized ��������̰߳�ȫ�����⣺��Ҫ�ڴ�����в��չ�ͬ��һ������this)
	 * 
	 * 8.�����߳�ͨ��
	 * 8.1 wait()/notify()/notifyall()
	 * 8.2 ��Щ������ ͬ�������� ����
	 */
	public static void main(String[] args) throws InterruptedException {
		
		//1.�����̶߳���
		Thread th = new firstthread("baobaojiu");
		//2.�����̶߳����start���������߳�
		th.start();
		System.out.println(th.isAlive());
		for(int i = 0; i <100;i++) {
			
			System.out.print(Thread.currentThread().getName());
			System.out.println(i);
			
			if(i==10) {
				th.join();//���������̵߳�join��������ǰ�߳̽�������״̬
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
	 * �߳�����run����������
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
