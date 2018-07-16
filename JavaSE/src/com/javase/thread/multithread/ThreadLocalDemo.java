package com.javase.thread.multithread;

import java.util.concurrent.locks.ReentrantLock;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 *ThreadLocal
 *本地线程变量
 * 
 *  ThreadLoca通过map集合
 *  Map.put(“当前线程”,值)；
 *
*
 * 原理是map
 * 
 * @author Yin
 *
 */

public class ThreadLocalDemo{
	public static void main(String[] args) {
		ResNumber number=new ResNumber();
 		LocalThreadDemo localThreadDemo1 = new LocalThreadDemo(number);
 		LocalThreadDemo localThreadDemo2 = new LocalThreadDemo(number);
 		LocalThreadDemo localThreadDemo3 = new LocalThreadDemo(number); //多线程共享同一个对象
 		localThreadDemo1.start();
 		localThreadDemo2.start();
 		localThreadDemo3.start();
	
	}
}

class ResNumber{
    public int count=0;
  //使用ThreadLocal
    ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
		protected Integer initialValue() {
			return 0;
		};
	};
	
	public int getNumber() {
		count=threadLocal.get()+1;
		threadLocal.set(count);
		return count;
	}

	public void setNumber(int count) {
		this.count = count;
	}
	
}

class LocalThreadDemo extends Thread{
	private ResNumber resNumber;

	public LocalThreadDemo(ResNumber resNumber) {
		super();
		this.resNumber = resNumber;
	}
	
	@Override
	public void run() {
		super.run();
		for (int i = 0; i <3; i++) {
			System.out.println(getName()+","+resNumber.getNumber());
			
		}
	}
}