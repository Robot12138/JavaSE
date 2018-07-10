package com.thread.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public  class ThreadDemo{
	public static void main(String[] args) {
		//获取所有的用户数量
		List<UserEntity> list = init();
		//设定每个线程发多少个用户
		int threadSendUser=20;
		//根据用户数量和线程总数，计算
		List<List<UserEntity>> splitList = ListUtils.splitList(list, threadSendUser);
		//发送信息
	
		for (List<UserEntity> list2 : splitList) {
			Send send=new Send(list2);
			send.start();
		}
		
	}
	
	

	//获取所有的用户数量
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