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
			System.out.print("���ȭ��1������2��ʯͷ3��������");
			Scanner input=new Scanner(System.in);
			choice=input.nextInt();
			if(1<=choice&&choice<=3){
				flag=false;		
			}
			else{
				System.out.println("�����ַ����ԣ����������룡");
			}
		}		
		return choice;
	}

}
