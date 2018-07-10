package com.thread.threaddemo;

import javax.xml.stream.events.StartDocument;

/**
 * 进程与线程
 * 进程是线程的集合，线程是进程的一条执行路径。
 * 为什么使用多线程？
 *  提高程序效率。
 *  
 *  多线程应用场景
 *  多线程下载
 *  爬虫
 *  分布式job,同一时刻执行多个任务调度。
 *  
 *  
 *  创建线程的方式:
 *  1.继承Thread类
 *  2.实现Runnable接口
 *  3.匿名内部类
 *  4.callable
 *  5.使用线程池创建线程
 * 
 * 
 * 守护线程
 * 		和main相关，gc线程
 * 
 * 非守护线程 
 * 		用户线程
 * 
 * @author Yin
 *
 */
public class ThreadDemo {
	public static void main(String[] args) {
		
		//继承thread类时候的启动
/*		CreateThread createThread = new	CreateThread();
		createThread.start(); //createThread.run()启动方式的不同。调用run单线程
		for (int i = 0; i <30; i++) {
			System.out.println("main ==>"+i);
		}
		*/
		
		
	//实现runnable接口的启动
/*	CreateThread createThread = new	CreateThread();
	Thread thread=new Thread(createThread);
	thread.start(); //createThread.run()启动方式的不同。调用run单线程
	for (int i = 0; i <30; i++) {
		System.out.println("main ==>"+i);
	}*/
	
	
	
	//匿名类创建线程
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
	
		
		//多线程API
		/*for (int i = 0; i <2; i++) {
			CreateThread createThread = new	CreateThread();
			createThread.start();
			System.out.println(Thread.currentThread().getId()+" main==>"+i);  //获取主线程id
		}*/
		
		//sleep
	/*	CreateThread createThread = new	CreateThread();
		createThread.start();
		*/
		//stop方法 不建议使用。因为不安全
		
		
		
		//守护线程
	/*	Thread thread=new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i <300; i++) {
					System.out.println(Thread.currentThread().getId()+" thread==>"+i);  //获取主线程id
				}
			}
		});
		thread.setDaemon(true);//设置守护线程
		thread.start();
		for (int i = 0; i <2; i++) {
			System.out.println(Thread.currentThread().getId()+" main==>"+i);  //获取主线程id
		}
	*/
		
		
		/**
		 * 当一个线程中，依赖另外一个线程时，可以把另一个线程作为构造函数，传入使用。
		 * 
		 * join方法只能用在run方法中。
		 */
		CreateThread createThread = new	 CreateThread();
		CreateThread1 createThread1 = new	 CreateThread1(createThread);
		createThread.start();
		createThread1.start();
	
		
		
		
	}
}


//使用thread类开启线程
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

//实现Runnable接口执行
/*class CreateThread implements Runnable{
	@Override
	public void run() {
		for (int i = 0; i <30; i++) {
			System.out.println("thread==>"+i);
		}
		
	}
	
}*/

//多线程API
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



//join方法
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
			thread.join(); //让其他线程变为等待线程
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}		
		
		for (int i = 0; i <10; i++) {			
			System.out.println(getId()+"thread2==>"+i);
		}
	}
}