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
			name=null;
			System.out.println("输入字符不对，请重新输入！");
			break;
		}
		return name;
	}

	
	public int myFist() {
		Random r=new Random();
		int fist=r.nextInt(3)+1;
		return fist;
	}
    
}
