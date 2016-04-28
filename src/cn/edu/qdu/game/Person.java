package cn.edu.qdu.game;

import java.util.Scanner;

public class Person extends Player{

	
	public String inputName() {
		Scanner input=new Scanner(System.in);
		String name=input.next();
		return name;
	}

	
	public int myFist() {
		boolean flag=true;
		int choice=0;
		while(flag){
			System.out.print("请出拳（1：剪刀2：石头3：布）：");
			Scanner input=new Scanner(System.in);
			choice=input.nextInt();
			if(1<=choice&&choice<=3){
				flag=false;		
			}
			else{
				System.out.println("输入字符不对，请重新输入！");
			}
		}		
		return choice;
	}

}
