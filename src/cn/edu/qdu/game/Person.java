package cn.edu.qdu.game;

import java.util.Scanner;

public class Person extends Player{

	
	public String inputName() {
		Scanner input=new Scanner(System.in);
		String name=input.next();
		return name;
	}

	
	public int myFist() {
		System.out.print("���ȭ��1������2��ʯͷ3������");
		int fist=0;
		Scanner input=new Scanner(System.in);
		int choice=input.nextInt();
		
		return choice;
	}
	 public static void main(String[] args) {
			Person c=new Person();
			String name=c.inputName();
			System.out.println(name);
		}

}
