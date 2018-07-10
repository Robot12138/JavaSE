package com.thread.synchorized;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * jvm内存模型相关
 * volatie: 线程之间的可见性
 * 本地内存和主内存之间可见性
 * 不保证原子性，只保证可见。
 * @author Yin
 *
 */
/*public class ThreadVolatie {
	public static void main(String[] args) {
		ThreadDemo1 demo1=new ThreadDemo1();
		demo1.start();
		demo1.setFlag(false);
		
	}
}

class ThreadDemo1 extends Thread{
	private  volatile boolean  flag =true;
	@Override
	public void run() {
		super.run();
		System.out.println("子线程开始执行。。");
		while (flag) {
			
		}
		System.out.println("子线程执行结束。。");
		
		
	}
	public void setFlag(boolean flag){
		this.flag=flag;
	}
}
*/



public class ThreadVolatie extends Thread {
	//10个线程共享count
	//private static  int count=0; //static修饰关键字，所有线程中共享，只存放一次。
	private static AtomicInteger count=new AtomicInteger(0);
	@Override
	public void run() {
		super.run();
		
		for (int i = 0; i < 1000; i++) {
			//count++;
			count.incrementAndGet();
		}
		System.out.println(getName()+","+count);
	}
	public static void main(String[] args) {
		ThreadVolatie[] thread=	new ThreadVolatie[10];//创建10个线程
		for (int i = 0; i < thread.length; i++) {
			thread[i]=new ThreadVolatie();
		}
		for (ThreadVolatie threadVolatie : thread) {
			threadVolatie.start();
		}
	}
}