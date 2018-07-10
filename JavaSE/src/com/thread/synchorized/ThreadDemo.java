package com.thread.synchorized;

/**
 * �̰߳�ȫ
 * ����̣߳�д������ʱ�򣬿��ܻ��ܵ������̵߳ĸ��š�
 * ȫ�ֱ���
 * 
 * synchronized
 *  ������
 *  ͬ��������this��
 *  ��̬ͬ����������ʹ��this�����ֽ����ļ�����.class
 *   ������������ͬһ��
 * lock
 * 
 * 
 * @author Yin
 *
 */
public class ThreadDemo {
	
	public static void main(String[] args) {
		Thread1 thread=new Thread1();
		Thread thread1=new Thread(thread,"����1");
		Thread thread2=new Thread(thread1,"����2");//�����߳�
		thread1.start();
		thread2.start();
	}
}


class Thread1 implements Runnable{
	private static int count=100;
	@Override
	public void run() {
		
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		while(count>0){
			sale();
		}
	}
	
	synchronized public void sale(){
	   if(count >0){
		System.out.println(Thread.currentThread().getName()+"���۵�"+(100-count+1)+"Ʊ");
		count--;
	   }
		
	}
}