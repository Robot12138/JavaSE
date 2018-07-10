package com.thread.tereadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;



/**
 * ThreadLocal
 * �����̱߳�����
 * ʵ��ԭ��ͨ��map���ϣ�map.put("��ǰ�߳�",ֵ);
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
	
	//���ñ��ؾֲ�������������������Ӱ��
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



/**�̳߳�
 *Ϊʲôʹ���̳߳�
 *ʹ���̳߳��������̣߳���Ϊ������ֹͣһ���̣߳��ǳ�����Դ��
 *���Խ��߳̽����̳߳���������Լ�ڴ档
 *һ������ҵ�����������Ƕ�ʹ���̳߳ء�
 *spring�����̳߳أ��첽ע�⡣ 
 * @author Yin
 * 
 * Executors jdk1.5������
 * 
 * newCachedThreadPool ����һ���ɻ����߳�
 * 
 * newFixedThreadPool �����̡߳�����ķŶ��С�
 * 
 * newSchedulerThreadPool ��ʱ����
 * 
 * newSingleThreadExecutor ���߳�
 * 
 *
 */
public class ThreadPool {
	public static void main(String[] args) {
		
/*		//�����ɻ�����̳߳�
		ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
		int index=i;
			//executeִ��һ�Σ���ʾ����һ���߳�
			newCachedThreadPool.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName()+"==>"+index);
					}
				});
			}
	   newCachedThreadPool.shutdown(); //д��forѭ�����档���̹߳ر�
*/	
	
/*	ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(3); //�̸߳���
	
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
			System.out.println("һ��ִ��һ��");
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



















