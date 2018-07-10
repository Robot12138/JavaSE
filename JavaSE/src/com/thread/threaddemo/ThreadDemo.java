package com.thread.threaddemo;

import javax.xml.stream.events.StartDocument;

/**
 * �������߳�
 * �������̵߳ļ��ϣ��߳��ǽ��̵�һ��ִ��·����
 * Ϊʲôʹ�ö��̣߳�
 *  ��߳���Ч�ʡ�
 *  
 *  ���߳�Ӧ�ó���
 *  ���߳�����
 *  ����
 *  �ֲ�ʽjob,ͬһʱ��ִ�ж��������ȡ�
 *  
 *  
 *  �����̵߳ķ�ʽ:
 *  1.�̳�Thread��
 *  2.ʵ��Runnable�ӿ�
 *  3.�����ڲ���
 *  4.callable
 *  5.ʹ���̳߳ش����߳�
 * 
 * 
 * �ػ��߳�
 * 		��main��أ�gc�߳�
 * 
 * ���ػ��߳� 
 * 		�û��߳�
 * 
 * @author Yin
 *
 */
public class ThreadDemo {
	public static void main(String[] args) {
		
		//�̳�thread��ʱ�������
/*		CreateThread createThread = new	CreateThread();
		createThread.start(); //createThread.run()������ʽ�Ĳ�ͬ������run���߳�
		for (int i = 0; i <30; i++) {
			System.out.println("main ==>"+i);
		}
		*/
		
		
	//ʵ��runnable�ӿڵ�����
/*	CreateThread createThread = new	CreateThread();
	Thread thread=new Thread(createThread);
	thread.start(); //createThread.run()������ʽ�Ĳ�ͬ������run���߳�
	for (int i = 0; i <30; i++) {
		System.out.println("main ==>"+i);
	}*/
	
	
	
	//�����ഴ���߳�
/*		new Thread(new  Runnable() {
			public void run() {
				for (int i = 0; i <30; i++) {
					System.out.println("thread==>"+i);
				}
			}
		}).start();;
		
		for (int i = 0; i <30; i++) {
			System.out.println("main==>"+i);
		}
	*/
	
		
		//���߳�API
		/*for (int i = 0; i <2; i++) {
			CreateThread createThread = new	CreateThread();
			createThread.start();
			System.out.println(Thread.currentThread().getId()+" main==>"+i);  //��ȡ���߳�id
		}*/
		
		//sleep
	/*	CreateThread createThread = new	CreateThread();
		createThread.start();
		*/
		//stop���� ������ʹ�á���Ϊ����ȫ
		
		
		
		//�ػ��߳�
	/*	Thread thread=new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i <300; i++) {
					System.out.println(Thread.currentThread().getId()+" thread==>"+i);  //��ȡ���߳�id
				}
			}
		});
		thread.setDaemon(true);//�����ػ��߳�
		thread.start();
		for (int i = 0; i <2; i++) {
			System.out.println(Thread.currentThread().getId()+" main==>"+i);  //��ȡ���߳�id
		}
	*/
		
		
		/**
		 * ��һ���߳��У���������һ���߳�ʱ�����԰���һ���߳���Ϊ���캯��������ʹ�á�
		 * 
		 * join����ֻ������run�����С�
		 */
		CreateThread createThread = new	 CreateThread();
		CreateThread1 createThread1 = new	 CreateThread1(createThread);
		createThread.start();
		createThread1.start();
	
		
		
		
	}
}


//ʹ��thread�࿪���߳�
/*class CreateThread extends Thread{
	@Override
	public void run() {
		
		super.run();
		for (int i = 0; i <30; i++) {
			System.out.println("thread==>"+i);
		}
	}
}
*/

//ʵ��Runnable�ӿ�ִ��
/*class CreateThread implements Runnable{
	@Override
	public void run() {
		for (int i = 0; i <30; i++) {
			System.out.println("thread==>"+i);
		}
		
	}
	
}*/

//���߳�API
/*class CreateThread extends Thread{
	@Override
	public void run() {
		super.run();
		
		for (int i = 0; i <30; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(getId()+"thread==>"+i);
		}
	}
}*/



//join����
class CreateThread extends Thread{
	@Override
	public void run() {
		super.run();
		
		for (int i = 0; i <20; i++) {
			System.out.println(getId()+"thread1==>"+i);
		}
	}
}

class CreateThread1 extends Thread{
	private CreateThread thread;
	public CreateThread1(CreateThread thread){
		this.thread=thread;
	}
	@Override
	public void run() {
		super.run();
		try {
			thread.join(); //�������̱߳�Ϊ�ȴ��߳�
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}		
		
		for (int i = 0; i <10; i++) {			
			System.out.println(getId()+"thread2==>"+i);
		}
	}
}