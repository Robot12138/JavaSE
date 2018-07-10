package com.thread.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public  class ThreadDemo{
	public static void main(String[] args) {
		//��ȡ���е��û�����
		List<UserEntity> list = init();
		//�趨ÿ���̷߳����ٸ��û�
		int threadSendUser=20;
		//�����û��������߳�����������
		List<List<UserEntity>> splitList = ListUtils.splitList(list, threadSendUser);
		//������Ϣ
	
		for (List<UserEntity> list2 : splitList) {
			Send send=new Send(list2);
			send.start();
		}
		
	}
	
	

	//��ȡ���е��û�����
	private static List<UserEntity> init() {
		List<UserEntity> list=new ArrayList<UserEntity>();
		for (int i = 0; i < 100; i++) {
			UserEntity entity=new UserEntity();
			entity.setAge(""+i);
			entity.setName(""+i);
			list.add(entity);
		}	
			
		return list;
		
		
	}
}

class Send extends Thread{
	private List<UserEntity> userEntity;
	public Send(List<UserEntity> userEntity) {
		this.userEntity=userEntity;
	}
	@Override
	public void run() {
		super.run();
		for (UserEntity userEntity2 : userEntity) {
			System.out.println("name==>"+getName()+"=ID==>"+getId()+"=send==>"+userEntity2.toString());			
		}
		
	}
}


class UserEntity{
	private String name;
	private String age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "UserEntity [name=" + name + ", age=" + age + "]";
	}
	
	
}