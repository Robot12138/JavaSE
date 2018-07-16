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
 *Vectory:�̰߳�ȫ��.ͨ��synchronizedʵ���̰߳�ȫ��.
 *ArrayList:�߳��ǲ���ȫ�ģ�Ч�ʸ���
 *ʵ��ԭ��������ʵ�֣���ѯ�ٶȿ죬�����޸ģ�ɾ���ٶ���
 *�����̰߳�ȫ����
 *
 *
 *HashTable:�̰߳�ȫ�ġ�synchronized�ؼ��֡�ȫ�ּ�synchronized
 *HashMap:�̲߳���ȫ�ģ�����̰߳�ȫ����Conllections.synchronizedMap(hashmap)
 *ʵ��ԭ������+����ʵ�ֵġ�hashcodeȡģ�õ��±�λ�ã�һ����ȡģ�㷨��
 *
 *���򷽷���Conllections.sort(); list����
 *
 *ConcurrentHashMap�ֶ�����������
 *��һ�������ֳɶ��С��HashTable��Ĭ�Ϸֳ�16��
 *
 *
 *CountDownLatch --������ʹ��
 *
 *CyclicBarrier �߳�ִ����Ϻ�ͬʱִ��һ�δ���
 *
 *��������
 *�н���޽�
 *�����ͷ�������
 *����������д������ʱ�򣬾ͻ����������
 *������Ϊ�գ�������Ҳ��ȴ���
 *�Ƚ��ȳ���������
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
			System.out.println("����ʼִ��---------------");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			countDownLatch.countDown();//ÿ�μ�1
			System.out.println("����ִ�н���---------------");
		}
	}).start();
	
	new Thread(new Runnable() {
		
		@Override
		public void run() {
			System.out.println("����ʼִ��---------------");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			countDownLatch.countDown();//ÿ�μ�1
			System.out.println("����ִ�н���---------------");
		}
	}).start();
	try {
		countDownLatch.await();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}//�ȴ��������Ϊ0����ִ�У�һֱ�ȴ�	
	System.out.println("���߳�");
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
		System.out.println("��ʼд��");
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
		System.out.println("д�����ݳɹ�");
	}
}
*/