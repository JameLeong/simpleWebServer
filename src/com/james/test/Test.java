package com.james.test;

import java.lang.reflect.Field;

public class Test {

	public static void main(String[] args) {
		Integer a = 3,b=20;
		System.out.println("Before : a="+a+" , b="+b);
		swap(a, b);
		System.out.println("After  : a="+a+" , b="+b);
	}
	public static void swap(Integer a,Integer b){
		int tmp = new Integer(a.intValue());
		setIntegerValue(a,b);
		setIntegerValue(b,tmp);
	}
	
	public static void setIntegerValue(Integer i,int val){
		try {
			Field field = i.getClass().getDeclaredField("value");
			field.setAccessible(true);
			field.set(i, new Integer(val));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
