package com.thread.synchorized;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * jvm�ڴ�ģ�����
 * volatie: �߳�֮��Ŀɼ���
 * �����ڴ�����ڴ�֮��ɼ���
 * ����֤ԭ���ԣ�ֻ��֤�ɼ���
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
		System.out.println("���߳̿�ʼִ�С���");
		while (flag) {
			
		}
		System.out.println("���߳�ִ�н�������");
		
		
	}
	public void setFlag(boolean flag){
		this.flag=flag;
	}
}
*/



public class ThreadVolatie extends Thread {
	//10���̹߳���count
	//private static  int count=0; //static���ιؼ��֣������߳��й���ֻ���һ�Ρ�
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
		ThreadVolatie[] thread=	new ThreadVolatie[10];//����10���߳�
		for (int i = 0; i < thread.length; i++) {
			thread[i]=new ThreadVolatie();
		}
		for (ThreadVolatie threadVolatie : thread) {
			threadVolatie.start();
		}
	}
}