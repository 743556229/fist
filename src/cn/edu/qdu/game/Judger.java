package cn.edu.qdu.game;

import java.util.Scanner;

public class Judger {
	int total;
//	Person person;
//	Computer computer;
	Person person=new Person();
	Computer computer=new Computer();
	
	
	//开始游戏
	public void startGame(){
		System.out.println("\t\t\t******************\n"
				          +"\t\t\t**  猜拳，开始      **\n"
				          +"\t\t\t******************\n\n"
				          +"出拳规则：请出拳（1：剪刀2：石头3：布）"		          
				);
	}
	
    //询问姓名
	public void askName(){	
		System.out.print("请选择对方的姓名（1：刘备2：孙权3：曹操）：");
		computer.playName=computer.inputName();
		System.out.print("请输入你的姓名:");
	    person.playName=person.inputName();
		System.out.println(person.playName+" VS"+computer.playName+" 对战");		
	}
	
	//开始游戏
	public void playGame(){
		String conti = "y";
		System.out.print("要开始吗？（y/n）：");
		Scanner input=new Scanner(System.in);
		String start=input.next();
		if(start.equals("n")){
			System.out.println("已退出");
			System.out.println("---------------------------------------------------------------");
		}
		while(start.equals("y")&&conti.equals("y")){
			
			int personChoice=person.myFist();
			int computerChoice=computer.myFist();
			System.out.print("你出拳:");
			switch (personChoice) {
			case 1:
				System.out.println("剪刀");
				break;
			case 2:
				System.out.println("石头");
				break;
			case 3:
				System.out.println("布");
				break;
			default:
				break;
			}
			System.out.print(computer.playName+"出拳：");
			switch (computerChoice) {
			case 1:
				System.out.println("剪刀");
				break;
			case 2:
				System.out.println("石头");
				break;
			case 3:
				System.out.println("布");
				break;
			default:
				break;
			}
			if(personChoice==1 && computerChoice==3){
				System.out.println("^_^ ^_^ ^_^哈哈，你赢了");	
				person.winningTimes=person.winningTimes+1;
			}
			else if(personChoice==3 &&computerChoice==1){
				System.out.println("^_^,你输了，真笨！");
				computer.winningTimes=computer.winningTimes+1;
			}
			else if(personChoice==computerChoice){
				System.out.println("平局，继续加油");	
			}
			else if(personChoice>computerChoice){
				System.out.println("^_^ ^_^ ^_^哈哈，你赢了");
				person.winningTimes=person.winningTimes+1;
			}
			else{
				System.out.println("^_^,你输了，真笨！");
				computer.winningTimes=computer.winningTimes+1;
			}
			total=total+1;
			System.out.println();
			System.out.print("是否进行下一轮（y/n）：");
			conti=input.next();
			if(conti.equals("n")){
				this.finalResult();
			}
		}

	}
	
	//游戏结果
	public void finalResult(){
		System.out.println("---------------------------------------------------------------\n"
				+computer.playName+"VS"+person.playName+"\n"
				+"对战次数"+total+"\n\n"
				+"姓名             得分\n"
				+person.playName+"      "+person.winningTimes+"\n"
				+computer.playName+"      "+computer.winningTimes+"\n"
				);
		if(person.winningTimes<computer.winningTimes){
			System.out.println("结果：呵呵，笨笨，下次加油啊！");
		}
		else if(person.winningTimes>computer.winningTimes){
			System.out.println("结果：聪聪不错啊，赢了！！");
		}
		else{
			System.out.println("结果：平局，再接再厉哦！");
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
