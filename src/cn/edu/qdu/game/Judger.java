package cn.edu.qdu.game;

import java.util.Scanner;

public class Judger {
	int total;
//	Person person;
//	Computer computer;
	Person person=new Person();
	Computer computer=new Computer();
	
	
	//��ʼ��Ϸ
	public void startGame(){
		System.out.println("\t\t\t******************\n"
				          +"\t\t\t**  ��ȭ����ʼ      **\n"
				          +"\t\t\t******************\n\n"
				          +"��ȭ�������ȭ��1������2��ʯͷ3������"		          
				);
	}
	
    //ѯ������
	public void askName(){	
		System.out.print("��ѡ��Է���������1������2����Ȩ3���ܲ٣���");
		computer.playName=computer.inputName();
		System.out.print("�������������:");
	    person.playName=person.inputName();
		System.out.println(person.playName+" VS"+computer.playName+" ��ս");		
	}
	
	//��ʼ��Ϸ
	public void playGame(){
		String conti = "y";
		System.out.print("Ҫ��ʼ�𣿣�y/n����");
		Scanner input=new Scanner(System.in);
		String start=input.next();
		if(start.equals("n")){
			System.out.println("���˳�");
			System.out.println("---------------------------------------------------------------");
		}
		while(start.equals("y")&&conti.equals("y")){
			
			int personChoice=person.myFist();
			int computerChoice=computer.myFist();
			System.out.print("���ȭ:");
			switch (personChoice) {
			case 1:
				System.out.println("����");
				break;
			case 2:
				System.out.println("ʯͷ");
				break;
			case 3:
				System.out.println("��");
				break;
			default:
				break;
			}
			System.out.print(computer.playName+"��ȭ��");
			switch (computerChoice) {
			case 1:
				System.out.println("����");
				break;
			case 2:
				System.out.println("ʯͷ");
				break;
			case 3:
				System.out.println("��");
				break;
			default:
				break;
			}
			if(personChoice==1 && computerChoice==3){
				System.out.println("^_^ ^_^ ^_^��������Ӯ��");	
				person.winningTimes=person.winningTimes+1;
			}
			else if(personChoice==3 &&computerChoice==1){
				System.out.println("^_^,�����ˣ��汿��");
				computer.winningTimes=computer.winningTimes+1;
			}
			else if(personChoice==computerChoice){
				System.out.println("ƽ�֣���������");	
			}
			else if(personChoice>computerChoice){
				System.out.println("^_^ ^_^ ^_^��������Ӯ��");
				person.winningTimes=person.winningTimes+1;
			}
			else{
				System.out.println("^_^,�����ˣ��汿��");
				computer.winningTimes=computer.winningTimes+1;
			}
			total=total+1;
			System.out.println();
			System.out.print("�Ƿ������һ�֣�y/n����");
			conti=input.next();
			if(conti.equals("n")){
				this.finalResult();
			}
		}

	}
	
	//��Ϸ���
	public void finalResult(){
		System.out.println("---------------------------------------------------------------\n"
				+computer.playName+"VS"+person.playName+"\n"
				+"��ս����"+total+"\n\n"
				+"����             �÷�\n"
				+person.playName+"      "+person.winningTimes+"\n"
				+computer.playName+"      "+computer.winningTimes+"\n"
				);
		if(person.winningTimes<computer.winningTimes){
			System.out.println("������Ǻǣ��������´μ��Ͱ���");
		}
		else if(person.winningTimes>computer.winningTimes){
			System.out.println("������ϴϲ�����Ӯ�ˣ���");
		}
		else{
			System.out.println("�����ƽ�֣��ٽ�����Ŷ��");
		}
		System.out.println("---------------------------------------------------------------");
		
	}
	
    public static void main(String[] args) {
		Judger judger=new Judger();
		judger.startGame();
		judger.askName();
		judger.playGame();
	}
}
