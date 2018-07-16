package com.javase.thread.multithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者与消费者
 * 
 * Lock锁1.5 线程安全问题
 * 
 * lock与synchronized
 * lock手动
 * synchronized 自动
 * 
 * 使用同一个Condition保证线程同步
 * 
 * @author Yin
 *
 */

public class ThreadLock{
	public static void main(String[] args) {
		Res1 res = new Res1();
		Condition newCondition = res.lock.newCondition();
		InPutThread1 inPutThread = new InPutThread1(res,newCondition);
		OutPutThread1 outPutThread = new OutPutThread1(res,newCondition);
		inPutThread.start();
		outPutThread.start();
		
	}
}
class Res1{
	 private String name;
	 private String sex;
	 public boolean flag=false;
     Lock lock=new ReentrantLock();
     
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	@Override
	public String toString() {
		return "Res [name=" + name + ", sex=" + sex + "]";
	}
	 
}


class InPutThread1 extends Thread{
	 private Res1 res;
	 private Condition newCondition;
	 public InPutThread1(Res1 res,Condition newCondition) {
		this.res=res;
		this.newCondition=newCondition;
	}
	@Override
	public void run() {
		super.run();
		int count=0;
		//写操作
		while(true){
	
			res.lock.lock();
		   
			if (res.flag) {
				try {
					newCondition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			try {
				if (count ==0) {
					res.setName("小红");
					res.setSex("女");
				}else{
					res.setName("小明");
					res.setSex("男");
				}
				count=(count+1)%2;
				res.flag=true;
				newCondition.signal();
			} finally {
				res.lock.unlock();					
			}
		}
		
	}
}


class OutPutThread1 extends Thread{
	 private Res1 res;
	 private Condition newCondition;
	 public OutPutThread1(Res1 res,Condition newCondition) {
		this.res=res;
		this.newCondition=newCondition;
	}
	@Override
	public void run() {
		super.run();
		//写操作
		while(true){
			
			try {
				res.lock.lock();
				if (!res.flag) {
					try {
						newCondition.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("姓名==>"+res.getName());
				System.out.println("性别==>"+res.getSex());
				res.flag=false;
				newCondition.signal();
			} finally {
				res.lock.unlock();
			}
				
		}
		
	}
}
