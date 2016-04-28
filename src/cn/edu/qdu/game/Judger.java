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
		boolean flag=true;
		while(flag){
			System.out.print("请选择对方的姓名（1：刘备2：孙权3：曹操）：");
			computer.setPlayName(computer.inputName());
			if(computer.getPlayName()!=null){
				flag=false;
			}
		}
		System.out.print("请输入你的姓名:");
	    person.setPlayName(person.inputName());
		System.out.println(person.getPlayName()+" VS"+computer.getPlayName()+" 对战");		
	}
	
	//开始游戏
	public void playGame(){
		String conti="y";
		boolean flag=true;//设置布尔值，若不输入y/n,则重新输入
		
		Scanner input=new Scanner(System.in);		
		String start;	
		//判断是否开始，输入字符一定为y/n,否则一直循环
		do{
			System.out.print("要开始吗？（y/n）：");
			start=input.next();	
			if(start.equals("y")||start.equals("n")){	
				flag=false;
			}
			else{
				System.out.println("输入字符不对，请重新输入！");
			}
		}while(flag);
		if(start.equals("n")){
			System.out.println("已退出");
			System.out.println("---------------------------------------------------------------");
		}
		//如果开始，则双方出拳
		while(start.equals("y")&&conti.equals("y")){
			boolean flag2=true;
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
			System.out.print(computer.getPlayName()+"出拳：");
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
			//判断谁赢
			if(personChoice==1 && computerChoice==3){
				System.out.println("^_^ ^_^ ^_^哈哈，你赢了");	
				person.setWinningTimes(person.getWinningTimes()+1);
			}
			else if(personChoice==3 &&computerChoice==1){
				System.out.println("^_^,你输了，真笨！");
				computer.setWinningTimes(computer.getWinningTimes()+1);
			}
			else if(personChoice==computerChoice){
				System.out.println("平局，继续加油");	
			}
			else if(personChoice>computerChoice){
				System.out.println("^_^ ^_^ ^_^哈哈，你赢了");
				person.setWinningTimes(person.getWinningTimes()+1);
			}
			else{
				System.out.println("^_^,你输了，真笨！");
				computer.setWinningTimes(computer.getWinningTimes()+1);
			}
			total=total+1;
			System.out.println();
			//判断是否进行下一轮
			do{
				System.out.print("是否进行下一轮（y/n）：");
				conti=input.next();	
				if(conti.equals("y")||conti.equals("n")){	
					flag2=false;
				}
				else{
					System.out.println("输入字符不对，请重新输入！");
				}
			}while(flag2);

			if(conti.equals("n")){
				this.finalResult();
			}
		}

	}
	
	//游戏结果
	public void finalResult(){
		System.out.println("---------------------------------------------------------------\n"
				+computer.getPlayName()+"VS"+person.getPlayName()+"\n"
				+"对战次数"+total+"\n\n"
				+"姓名             得分\n"
				+person.getPlayName()+"      "+person.getWinningTimes()+"\n"
				+computer.getPlayName()+"      "+computer.getWinningTimes()+"\n"
				);
		if(person.getWinningTimes()<computer.getWinningTimes()){
			System.out.println("结果：呵呵，笨笨，下次加油啊！");
		}
		else if(person.getWinningTimes()>computer.getWinningTimes()){
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
