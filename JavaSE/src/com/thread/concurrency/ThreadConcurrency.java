package com.thread.concurrency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * 
 * @author Yin
 *
 *Vectory:线程安全的.通过synchronized实现线程安全的.
 *ArrayList:线程是不安全的，效率更高
 *实现原理都是数组实现，查询速度快，增加修改，删除速度慢
 *区别线程安全问题
 *
 *
 *HashTable:线程安全的。synchronized关键字。全局加synchronized
 *HashMap:线程不安全的，解决线程安全问题Conllections.synchronizedMap(hashmap)
 *实现原理链表+数组实现的。hashcode取模得到下表位置，一致性取模算法。
 *
 *排序方法：Conllections.sort(); list排序
 *
 *ConcurrentHashMap分段锁，并发包
 *将一个整体拆分成多个小的HashTable，默认分成16段
 *
 *
 *CountDownLatch --计数器使用
 *
 *CyclicBarrier 线程执行完毕后，同时执行一段代码
 *
 *并发队列
 *有界和无界
 *阻塞和非阻塞：
 *区别：生产者写入满的时候，就会进入阻塞。
 *当队列为空，消费者也会等待。
 *先进先出，后进后出
 *
 *
 *
 *
 *
 */
public class ThreadConcurrency {
public static void main(String[] args) {

	/*CountDownLatch countDownLatch=new CountDownLatch(3);
	new Thread(new Runnable() {
		
		@Override
		public void run() {
			System.out.println("任务开始执行---------------");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			countDownLatch.countDown();//每次减1
			System.out.println("任务执行结束---------------");
		}
	}).start();
	
	new Thread(new Runnable() {
		
		@Override
		public void run() {
			System.out.println("任务开始执行---------------");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			countDownLatch.countDown();//每次减1
			System.out.println("任务执行结束---------------");
		}
	}).start();
	try {
		countDownLatch.await();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}//等待，如果不为0，不执行，一直等待	
	System.out.println("主线程");
	for (int i = 0; i < 10; i++) {
		System.out.println("main");
	}*/
	
	
/*	CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
	for (int i = 0; i < 5; i++) {
		new Writer(cyclicBarrier).start();
	}
*/
	
	ConcurrentLinkedDeque<Object> concurrentLinkedDeque = new ConcurrentLinkedDeque<Object>();

	
}
}

/*class Writer extends Thread{
	private CyclicBarrier cyclicBarrier;
	public  Writer(CyclicBarrier cyclicBarrier) {
		this.cyclicBarrier=cyclicBarrier;
	}
	
	@Override
	public void run() {
		super.run();
		System.out.println("开始写入");
		try {
			Thread.sleep(30);
		
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			cyclicBarrier.await();
			System.out.println("111111111");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
		System.out.println("写入数据成功");
	}
}
*/