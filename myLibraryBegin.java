package lib2;

import java.util.Scanner;



public class myLibraryBegin {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		LibraryManagement lm = LibraryManagement.getInstance("灿灿的图书室");
		
		
		System.out.println("欢迎登录" + lm.getName() + "系统");
		info(lm);
		//展示图书馆现有的书
		lm.show();
		
	   
		try {
			selectFunction(lm);
		} catch (IDNotFoundExtception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
	}
	
	//图书管理以及功能选择界面
	private static void selectFunction(LibraryManagement l) throws IDNotFoundExtception {
		
		while (true) {
			System.out.println("---------------------------");
			System.out.println("------有如下几种功能-----------");
			System.out.println("------A.增加图书-------------");
			System.out.println("------B.删除图书-------------");
			System.out.println("------C.修改信息-------------");
			System.out.println("------D.查找图书-------------");
			System.out.println("------E.借图书-------------");
			System.out.println("------F.还图书-------------");
			System.out.println("------G.通过图书ID进行排序---");
			System.out.println("------H.通过图书价格进行排序---");
			System.out.println("------I.展示图书------------");
			System.out.println("------J.退出系统------------");
			System.out.println("---------------------------");
			String choose = sc.next();
			switch (choose) {
					case "A":
						System.out.println("请分别输入图书的名字、作者、价格");
						System.out.print("请输入图书的名字： ");
						String n = sc.next();
						System.out.print("请输入图书的作者： ");
						String a = sc.next();
						System.out.print("请输入图书的价格： ");
						int p = sc.nextInt();		
						l.addBook(new Library(n, a, p));
						break;
						
					case "B":
						System.out.println("请输入你想要删除书的id");
						int d = sc.nextInt();
						l.deleteBook(d);
						break;
					case "C":
						System.out.println("请输入你想要修改书的id");
						int id = sc.nextInt();
						l.updateBook(id);
						break;
					case "D":
						System.out.println("请输入你想要查找书的id");
						int id2 = sc.nextInt();
						l.findBook(id2);
						
						break;
					case "E":
						System.out.println("请输入你要借的图书的ID");
						int jid = sc.nextInt();
						l.borrowsBooks(jid);
						break;
					case "F":
						System.out.println("请输入你要归还的图书的ID");
						int gid = sc.nextInt();
						l.returnBook(gid);
						break;
					case "G":
						l.showId();
						break;
					case "H":
						l.showPrice();
						break;
					case "I":
						l.show();
						break;
					case "J":
						System.exit(0);
						break;
									
			}
			
		}
		
	}

	//图书馆现有的书
	private static void info(LibraryManagement lm) {
		Library l1 = new Library("海贼王", "尾田荣一郎", 100);
		Library l2 = new Library("火影忍者", "岸本齐史", 20);
		Library l3 = new Library("家庭教师", "天野明", 65);
		Library l4 = new Library("七龙珠", "鸟山明", 22);
		Library l5 = new Library("妖精的尾巴", "真岛浩", 43);
		Library l6 = new Library("叛逆的鲁鲁修", "谷口悟朗", 89);
		Library l7 = new Library("High DXD School", "石踏一荣", 34);
		Library l8 = new Library("四月是你的谎言", "新川直司 ", 54);
		Library l9 = new Library("银魂", "空知英秋", 12);
		Library l10 = new Library("幽游白书", "富坚义博", 34);
		
		lm.addBook(l1);
		lm.addBook(l2);
		lm.addBook(l3);
		lm.addBook(l4);
		lm.addBook(l5);
		lm.addBook(l6);
		lm.addBook(l7); 
		lm.addBook(l8);
		lm.addBook(l9);
		lm.addBook(l10);
	}
}
