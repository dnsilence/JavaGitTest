package threadtest;

/*
 * ��ϰ��
 * 1����д��һ����ȫ��ʾ������
 * 2.ʹ��ͬ����������̰߳�ȫ�����⡣
 */

public class shareapple implements Runnable{

	private int applecount = 5;

	//��ƻ��
	boolean getApple() {
		
		synchronized(this) {
			
		
		if(applecount>0) {
			applecount--;
			System.out.print(Thread.currentThread().getName()+
					"������һ��ƻ����");
			System.out.println("��ʣ��"+applecount+"��ƻ��");
			return true;
		}
		
		return false;
		}
	}
	
	//�߳���
	@Override
	public void run() {
		
		boolean flag = getApple();
		while(flag) {
			flag = getApple();
		}
		System.out.println(Thread.currentThread().getName()+
				"�߳̽�����");
		
	}
	
	public static void main(String[] args) {
		
		
		System.out.println("���������ƻ��");
		shareapple a1 = new shareapple();
		
		Thread th1 = new Thread(a1);
		Thread th2 = new Thread(a1);
		
		th1.setName("��ƾ�");
		th2.setName("������");
		
		th1.start();
		th2.start();
		
	}
	
}
