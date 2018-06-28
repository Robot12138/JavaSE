package com.javase.thread;
/**
 * 线程实现的方法:
 * 1.继承Thread类
 * Thread类内部结构：
 * public class Thread implements Runnable
 * 
 * 
 * 2.实现runnable接口
 *  Java单继承性，故实现runnable扩展性更强
 * 
 * 
 * @author Yin
 *
 */

//示例1：
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
		System.out.println("线程运行结束");
	}

}*/
//以上案例输出结果：
//main
//线程运行结束
//MyThread
/**
 * 以上示例说明：CPU以不确定的方式，或者说是随机的时间来调用线程中的run方法。所以会有以上结果。
 */

//示例2：
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
	//  tp.run();//单线程
		tp.start();//多线程
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
 * 运行结果：
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
 * 以上案例说明了线程的随机性，表现出cpu执行哪个线程具有不确定性。
 * Thread类中的start()方法通知“线程规划器”此线程已经准备就绪，等待调用线程对象的run方法
 * 这个过程其实就是让系统安排一个时间来调用Thread中的run方法，使线程得到运行，
 * 启动线程，具有异步执行的的效果。
 * 
 * 如果调用run方法，就不是异步执行，而是同步，此线程对象并不交给“线程规划器”来进行处理。
 * 而是由main主线程来调用run方法，也就是必须等run方法中的代码执行完后，才可以执行后面的代码。
 * 
 * 此外，start()方法顺序不代表线程启动的顺序。
 */


//示例3：runnable接口
/*public class ThreadPractice implements Runnable{

	@Override
	public void run() {
		System.out.println("运行中");
	}
	
	public static void main(String[] args) {
		ThreadPractice tp=new ThreadPractice();
		Thread td=new Thread(tp);
		td.start();
		System.out.println("运行结束");
	}
	
}*/
/**
 * 运行结果：
     运行结束
     运行中
 */
//线程的随机性

//示例4：实例变量与线程安全
//1.不共享数据的情况
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
			System.out.println("由"+this.currentThread().getName()+"计算,count="+count);
			
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
运行结果：
由A计算,count=4
由B计算,count=4
由C计算,count=4
由B计算,count=3
由B计算,count=2
由A计算,count=3
由B计算,count=1
由C计算,count=3
由B计算,count=0
由C计算,count=2
由A计算,count=2
由A计算,count=1
由A计算,count=0
由C计算,count=1
由C计算,count=0
 */
/*
 创建了3个线程，每个线程都有各自的count变量,变量不共享
 */
//2.共享变量的情况
/*public class ThreadPractice extends Thread{
	
	private int count=5;
	
	@Override
	public void run() {
	//synchronized public void run() {
		super.run();
		count--;
		System.out.println("由"+Thread.currentThread().getName()+"计算,count="+count);
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
运算结果：
由A计算,count=3
由B计算,count=3
由C计算,count=2
由D计算,count=1
由E计算,count=0
A,B的count同时为3，说明A,B同时对count进行了处理。

改进增加synchronized关键字

非线程安全主要是值多个线程对同一个对象中的同一个实例变量进行操作时，会出现值被更改，值不同步的情况。
*/

//示例：非线程安全
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
//解决这个非线程安全的使用synchronized关键字

//示例：i--与System.out.println()
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
//虽然结果正确，但是存在发生非线程安全问题的概率。i--的操作在println之前发生。