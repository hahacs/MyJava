package com.hahacs.util.test;

public class Test03 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.getProperties().get("java.library.path");
		System.out.println("javaLibrary������ʲô?"+System.getProperties().get("java.library.path").toString());
	}

}
