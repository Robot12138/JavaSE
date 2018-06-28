package com.javase.thread;
/**
 * �߳�ʵ�ֵķ���:
 * 1.�̳�Thread��
 * Thread���ڲ��ṹ��
 * public class Thread implements Runnable
 * 
 * 
 * 2.ʵ��runnable�ӿ�
 *  Java���̳��ԣ���ʵ��runnable��չ�Ը�ǿ
 * 
 * 
 * @author Yin
 *
 */

//ʾ��1��
/*public class ThreadPractice extends Thread{
    
	@Override
	public void run() {
		super.run();
		System.out.println("MyThread");
	}
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		ThreadPractice tp=new ThreadPractice();
		tp.start();
		System.out.println("�߳����н���");
	}

}*/
//���ϰ�����������
//main
//�߳����н���
//MyThread
/**
 * ����ʾ��˵����CPU�Բ�ȷ���ķ�ʽ������˵�������ʱ���������߳��е�run���������Ի������Ͻ����
 */

//ʾ��2��
/*public class ThreadPractice extends Thread{
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			for (int i = 0; i < 10; i++) {
				int time=(int)((Math.random()*1000));
				Thread.sleep(time);
				System.out.println("run ="+Thread.currentThread().getName());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ThreadPractice tp=new ThreadPractice();
		tp.setName("MyThread");
	//  tp.run();//���߳�
		tp.start();//���߳�
		try {
			for (int i = 0; i < 10; i++) {
				int time=(int)(Math.random()*1000);
				Thread.sleep(time);
				System.out.println("main="+Thread.currentThread().getName());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
	}
}
*/

/**
 * ���н����
 *  run =MyThread
	run =MyThread
	main=main
	run =MyThread
	main=main
	run =MyThread
	main=main
	run =MyThread
	run =MyThread
	run =MyThread
	main=main
	run =MyThread
	main=main
	run =MyThread
	run =MyThread
	main=main
	main=main
	main=main
	main=main
	main=main
 * 
 *
 * */
/**
 * 
 * ���ϰ���˵�����̵߳�����ԣ����ֳ�cpuִ���ĸ��߳̾��в�ȷ���ԡ�
 * Thread���е�start()����֪ͨ���̹߳滮�������߳��Ѿ�׼���������ȴ������̶߳����run����
 * ���������ʵ������ϵͳ����һ��ʱ��������Thread�е�run������ʹ�̵߳õ����У�
 * �����̣߳������첽ִ�еĵ�Ч����
 * 
 * �������run�������Ͳ����첽ִ�У�����ͬ�������̶߳��󲢲��������̹߳滮���������д���
 * ������main���߳�������run������Ҳ���Ǳ����run�����еĴ���ִ����󣬲ſ���ִ�к���Ĵ��롣
 * 
 * ���⣬start()����˳�򲻴����߳�������˳��
 */


//ʾ��3��runnable�ӿ�
/*public class ThreadPractice implements Runnable{

	@Override
	public void run() {
		System.out.println("������");
	}
	
	public static void main(String[] args) {
		ThreadPractice tp=new ThreadPractice();
		Thread td=new Thread(tp);
		td.start();
		System.out.println("���н���");
	}
	
}*/
/**
 * ���н����
     ���н���
     ������
 */
//�̵߳������

//ʾ��4��ʵ���������̰߳�ȫ
//1.���������ݵ����
/*public class ThreadPractice extends Thread{
	private int count=5;
	 public ThreadPractice(String name) {
		super();
		this.setName(name);
	}
	@Override
	public void run() {
		super.run();
		while (count > 0) {
			count--;
			System.out.println("��"+this.currentThread().getName()+"����,count="+count);
			
		}
	}
	
	public static void main(String[] args) {
		ThreadPractice tp1=new ThreadPractice("A");
		ThreadPractice tp2=new ThreadPractice("B");
		ThreadPractice tp3=new ThreadPractice("C");
		tp1.start();
		tp2.start();
		tp3.start();
	}
}*/
/*
���н����
��A����,count=4
��B����,count=4
��C����,count=4
��B����,count=3
��B����,count=2
��A����,count=3
��B����,count=1
��C����,count=3
��B����,count=0
��C����,count=2
��A����,count=2
��A����,count=1
��A����,count=0
��C����,count=1
��C����,count=0
 */
/*
 ������3���̣߳�ÿ���̶߳��и��Ե�count����,����������
 */
//2.������������
/*public class ThreadPractice extends Thread{
	
	private int count=5;
	
	@Override
	public void run() {
	//synchronized public void run() {
		super.run();
		count--;
		System.out.println("��"+Thread.currentThread().getName()+"����,count="+count);
	}
	
	public static void main(String[] args) {
		ThreadPractice tp=new ThreadPractice();
		Thread th1=new Thread(tp,"A");
		Thread th2=new Thread(tp,"B");
		Thread th3=new Thread(tp,"C");
		Thread th4=new Thread(tp,"D");
		Thread th5=new Thread(tp,"E");
		th1.start();
		th2.start();
		th3.start();
		th4.start();
		th5.start();
	}
}*/
/*
��������
��A����,count=3
��B����,count=3
��C����,count=2
��D����,count=1
��E����,count=0
A,B��countͬʱΪ3��˵��A,Bͬʱ��count�����˴���

�Ľ�����synchronized�ؼ���

���̰߳�ȫ��Ҫ��ֵ����̶߳�ͬһ�������е�ͬһ��ʵ���������в���ʱ�������ֵ�����ģ�ֵ��ͬ���������
*/

//ʾ�������̰߳�ȫ
/*public class ThreadPractice{
	
	public static void main(String[] args) {
		ALogin alogin=new ALogin();
		alogin.start();
		BLogin blogin=new BLogin();
		blogin.start();
	}
}

class ALogin extends Thread{
	@Override
	public void run() {
		super.run();
		LoginServlet.doPost("a", "aa");
	}
}


class BLogin extends Thread{
	@Override
	public void run() {
		super.run();
		LoginServlet.doPost("b", "bb");
	}
}

class LoginServlet{
	private static String usernameRef;
	private static String passwordRef;
	
	 public static void doPost(String username,String password){
		//synchronized public static void doPost(String username,String password){
		try {
			usernameRef=username;
			if (username.equals("a")){
				Thread.sleep(5000);
			}
			passwordRef=password;
			System.out.println("username="+usernameRef+" password="+password);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}*/
//���������̰߳�ȫ��ʹ��synchronized�ؼ���

//ʾ����i--��System.out.println()
public class ThreadPractice {
	public static void main(String[] args) {
		Run tp=new Run();
		Thread t1=new Thread(tp);
		Thread t2=new Thread(tp);
		Thread t3=new Thread(tp);
		Thread t4=new Thread(tp);
		Thread t5=new Thread(tp);
		
			t1.start();
			t2.start();
			t3.start();
			t4.start();
			t5.start();
		}
}

class Run extends Thread{
	private int i=5;
	@Override
	synchronized public void run() {
		super.run();
		System.out.println("i="+(i--)+" threadName="+Thread.currentThread().getName());
	}
	
}
/*

i=5 threadName=Thread-1
i=2 threadName=Thread-4
i=3 threadName=Thread-2
i=4 threadName=Thread-3
i=1 threadName=Thread-5
 */
//��Ȼ�����ȷ�����Ǵ��ڷ������̰߳�ȫ����ĸ��ʡ�i--�Ĳ�����println֮ǰ������