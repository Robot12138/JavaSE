package com.thread.tereadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;



/**
 * ThreadLocal
 * 本地线程变量。
 * 实现原理：通过map集合，map.put("当前线程",值);
 * 
 * @author Yin
 *
 */
/*public class ThreadPool {
	public static void main(String[] args) {
		Res res1 = new Res();
		ThreadLocalDemo threadLocalDemo1 = new ThreadLocalDemo(res1);
		ThreadLocalDemo threadLocalDemo2 = new ThreadLocalDemo(res1);
		ThreadLocalDemo threadLocalDemo3 = new ThreadLocalDemo(res1);
		threadLocalDemo1.start();
		threadLocalDemo2.start();
		threadLocalDemo3.start();
	}
}

class Res{
	//private int count=0;
	
	//设置本地局部变量和其他变量互不影响
	private ThreadLocal<Integer> count=new ThreadLocal<Integer>(){
		protected Integer initialValue() {
			return 0;
		};
	};
	public int getNum(){
	 int	count=this.count.get()+1;
	 this.count.set(count);
	//count =count+1;
	 return count;
	}
	
}

class ThreadLocalDemo extends Thread{
	private Res res;
 public  ThreadLocalDemo(Res res) {
	this.res=res;
}
	public void run() {
		super.run();
		for (int i = 0; i < 3; i++) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(getName()+" Number "+i+" ==>"+res.getNum());
		}
	}
}*/



/**线程池
 *为什么使用线程池
 *使用线程池来管理线程，因为启动或停止一个线程，非常耗资源。
 *所以将线程交给线程池来管理，节约内存。
 *一般在企业开发当中我们都使用线程池。
 *spring整合线程池，异步注解。 
 * @author Yin
 * 
 * Executors jdk1.5并发包
 * 
 * newCachedThreadPool 创建一个可缓存线程
 * 
 * newFixedThreadPool 定长线程。多余的放队列。
 * 
 * newSchedulerThreadPool 定时周期
 * 
 * newSingleThreadExecutor 单线程
 * 
 *
 */
public class ThreadPool {
	public static void main(String[] args) {
		
/*		//创建可缓存的线程池
		ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
		int index=i;
			//execute执行一次，表示创建一个线程
			newCachedThreadPool.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName()+"==>"+index);
					}
				});
			}
	   newCachedThreadPool.shutdown(); //写在for循环外面。主线程关闭
*/	
	
/*	ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(3); //线程个数
	
	for (int i = 0; i < 10; i++) {
		int index=i;
		newFixedThreadPool.execute(new Runnable() {
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName()+"==>"+index);
		}
	});
	}
	newFixedThreadPool.shutdown();
	*/
	
	/*ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(3);
	newScheduledThreadPool.scheduleAtFixedRate(new Runnable() {
		
		@Override
		public void run() {
			System.out.println("一秒执行一次");
		}
	}, 1, 1, TimeUnit.SECONDS);
	
   */
	
		 ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
		for (int i = 0; i < 10; i++) {
			int index=i;
			newSingleThreadScheduledExecutor.execute(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName()+"==>"+index);
			}
		});
		}
	
		newSingleThreadScheduledExecutor.shutdown();
		
	}
	
}



















