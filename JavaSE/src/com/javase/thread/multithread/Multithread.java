package com.javase.thread.multithread;



/**
 * 生产者与消费者
 * 
 * 共享资源是res对象，
 * 使用synchorized锁定res对象即可。但是不能实现生产者和消费者模式。
 * 
 * synchorized中使用
 * wait:运行状态转换为休眠状态。释放锁资源
 * notify:休眠转换为运行，释放锁资源
 * 一定要在同步中使用，同一个锁资源。
 * 
 * wait同步中，可以释放锁资源。
 * sleep 不释放锁资源。
 * 
 * @author Yin
 *
 */
public class Multithread{
	public static void main(String[] args) {
		Res res = new Res();
		InPutThread inPutThread = new InPutThread(res);
		OutPutThread outPutThread = new OutPutThread(res);
		inPutThread.start();
		outPutThread.start();
	}
}

class Res{
	 private String name;
	 private String sex;
	 public boolean flag=false;
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


class InPutThread extends Thread{
	 private Res res;
	 public InPutThread(Res res) {
		this.res=res;
	}
	@Override
	public void run() {
		super.run();
		int count=0;
		//写操作
		while(true){
			synchronized (res) {
				if (res.flag) {
					try {
						res.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				
				}
				if (count ==0) {
					res.setName("小红");
					res.setSex("女");
				}else{
					res.setName("小明");
					res.setSex("男");
				}
				count=(count+1)%2;
				res.flag=true;
				res.notify();
			}
			
		}
		
	}
}


class OutPutThread extends Thread{
	 private Res res;
	 public OutPutThread(Res res) {
		this.res=res;
	}
	@Override
	public void run() {
		super.run();
		//写操作
		while(true){
			synchronized (res) {
				if(!res.flag){
					try {
						res.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("姓名==>"+res.getName());
				System.out.println("性别==>"+res.getSex());
				res.flag=false;
				res.notify();
			}
			
		}
		
	}
}