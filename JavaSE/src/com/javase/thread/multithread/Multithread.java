package com.javase.thread.multithread;



/**
 * ��������������
 * 
 * ������Դ��res����
 * ʹ��synchorized����res���󼴿ɡ����ǲ���ʵ�������ߺ�������ģʽ��
 * 
 * synchorized��ʹ��
 * wait:����״̬ת��Ϊ����״̬���ͷ�����Դ
 * notify:����ת��Ϊ���У��ͷ�����Դ
 * һ��Ҫ��ͬ����ʹ�ã�ͬһ������Դ��
 * 
 * waitͬ���У������ͷ�����Դ��
 * sleep ���ͷ�����Դ��
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
		//д����
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
					res.setName("С��");
					res.setSex("Ů");
				}else{
					res.setName("С��");
					res.setSex("��");
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
		//д����
		while(true){
			synchronized (res) {
				if(!res.flag){
					try {
						res.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("����==>"+res.getName());
				System.out.println("�Ա�==>"+res.getSex());
				res.flag=false;
				res.notify();
			}
			
		}
		
	}
}