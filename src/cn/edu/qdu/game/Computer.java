package cn.edu.qdu.game;

import java.util.Random;
import java.util.Scanner;

public class Computer extends Player {

	
	public String inputName() {
		String name=null;
		Scanner input=new Scanner(System.in);
		int choice=input.nextInt();
		switch (choice) {
		case 1:	
			name="刘备";
			break;
        case 2:	
        	name="孙权";
			break;
        case 3:	
        	name="曹操";
			break;
		default:
//			System.out.println("输入字符不对，只能输入y/n");
			break;
		}
		return name;
	}

	
	public int myFist() {
		Random r=new Random();
		int fist=r.nextInt(3)+1;
		return fist;
	}
    public static void main(String[] args) {
		Computer c=new Computer();
		String name=c.inputName();
		System.out.println(name);
	}
}
