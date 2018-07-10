package com.thread.synchorized;

/**
 * 线程安全
 * 多个线程，写操作的时候，可能会受到其他线程的干扰。
 * 全局变量
 * 
 * synchronized
 *  对象锁
 *  同步函数：this锁
 *  静态同步函数：不使用this锁。字节码文件。类.class
 *   真正产生共享同一个
 * lock
 * 
 * 
 * @author Yin
 *
 */
public class ThreadDemo {
	
	public static void main(String[] args) {
		Thread1 thread=new Thread1();
		Thread thread1=new Thread(thread,"窗口1");
		Thread thread2=new Thread(thread1,"窗口2");//两个线程
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
		System.out.println(Thread.currentThread().getName()+"出售第"+(100-count+1)+"票");
		count--;
	   }
		
	}
}