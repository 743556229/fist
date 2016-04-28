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
		boolean flag=true;
		while(flag){
			System.out.print("��ѡ��Է���������1������2����Ȩ3���ܲ٣���");
			computer.setPlayName(computer.inputName());
			if(computer.getPlayName()!=null){
				flag=false;
			}
		}
		System.out.print("�������������:");
	    person.setPlayName(person.inputName());
		System.out.println(person.getPlayName()+" VS"+computer.getPlayName()+" ��ս");		
	}
	
	//��ʼ��Ϸ
	public void playGame(){
		String conti="y";
		boolean flag=true;//���ò���ֵ����������y/n,����������
		
		Scanner input=new Scanner(System.in);		
		String start;	
		//�ж��Ƿ�ʼ�������ַ�һ��Ϊy/n,����һֱѭ��
		do{
			System.out.print("Ҫ��ʼ�𣿣�y/n����");
			start=input.next();	
			if(start.equals("y")||start.equals("n")){	
				flag=false;
			}
			else{
				System.out.println("�����ַ����ԣ����������룡");
			}
		}while(flag);
		if(start.equals("n")){
			System.out.println("���˳�");
			System.out.println("---------------------------------------------------------------");
		}
		//�����ʼ����˫����ȭ
		while(start.equals("y")&&conti.equals("y")){
			boolean flag2=true;
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
			System.out.print(computer.getPlayName()+"��ȭ��");
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
			//�ж�˭Ӯ
			if(personChoice==1 && computerChoice==3){
				System.out.println("^_^ ^_^ ^_^��������Ӯ��");	
				person.setWinningTimes(person.getWinningTimes()+1);
			}
			else if(personChoice==3 &&computerChoice==1){
				System.out.println("^_^,�����ˣ��汿��");
				computer.setWinningTimes(computer.getWinningTimes()+1);
			}
			else if(personChoice==computerChoice){
				System.out.println("ƽ�֣���������");	
			}
			else if(personChoice>computerChoice){
				System.out.println("^_^ ^_^ ^_^��������Ӯ��");
				person.setWinningTimes(person.getWinningTimes()+1);
			}
			else{
				System.out.println("^_^,�����ˣ��汿��");
				computer.setWinningTimes(computer.getWinningTimes()+1);
			}
			total=total+1;
			System.out.println();
			//�ж��Ƿ������һ��
			do{
				System.out.print("�Ƿ������һ�֣�y/n����");
				conti=input.next();	
				if(conti.equals("y")||conti.equals("n")){	
					flag2=false;
				}
				else{
					System.out.println("�����ַ����ԣ����������룡");
				}
			}while(flag2);

			if(conti.equals("n")){
				this.finalResult();
			}
		}

	}
	
	//��Ϸ���
	public void finalResult(){
		System.out.println("---------------------------------------------------------------\n"
				+computer.getPlayName()+"VS"+person.getPlayName()+"\n"
				+"��ս����"+total+"\n\n"
				+"����             �÷�\n"
				+person.getPlayName()+"      "+person.getWinningTimes()+"\n"
				+computer.getPlayName()+"      "+computer.getWinningTimes()+"\n"
				);
		if(person.getWinningTimes()<computer.getWinningTimes()){
			System.out.println("������Ǻǣ��������´μ��Ͱ���");
		}
		else if(person.getWinningTimes()>computer.getWinningTimes()){
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
