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
			name="����";
			break;
        case 2:	
        	name="��Ȩ";
			break;
        case 3:	
        	name="�ܲ�";
			break;
		default:
//			System.out.println("�����ַ����ԣ�ֻ������y/n");
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
