package lib2;

import java.util.Scanner;



public class myLibraryBegin {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		LibraryManagement lm = LibraryManagement.getInstance("�Ӳӵ�ͼ����");
		
		
		System.out.println("��ӭ��¼" + lm.getName() + "ϵͳ");
		info(lm);
		//չʾͼ������е���
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
	
	//ͼ������Լ�����ѡ�����
	private static void selectFunction(LibraryManagement l) throws IDNotFoundExtception {
		
		while (true) {
			System.out.println("---------------------------");
			System.out.println("------�����¼��ֹ���-----------");
			System.out.println("------A.����ͼ��-------------");
			System.out.println("------B.ɾ��ͼ��-------------");
			System.out.println("------C.�޸���Ϣ-------------");
			System.out.println("------D.����ͼ��-------------");
			System.out.println("------E.��ͼ��-------------");
			System.out.println("------F.��ͼ��-------------");
			System.out.println("------G.ͨ��ͼ��ID��������---");
			System.out.println("------H.ͨ��ͼ��۸��������---");
			System.out.println("------I.չʾͼ��------------");
			System.out.println("------J.�˳�ϵͳ------------");
			System.out.println("---------------------------");
			String choose = sc.next();
			switch (choose) {
					case "A":
						System.out.println("��ֱ�����ͼ������֡����ߡ��۸�");
						System.out.print("������ͼ������֣� ");
						String n = sc.next();
						System.out.print("������ͼ������ߣ� ");
						String a = sc.next();
						System.out.print("������ͼ��ļ۸� ");
						int p = sc.nextInt();		
						l.addBook(new Library(n, a, p));
						break;
						
					case "B":
						System.out.println("����������Ҫɾ�����id");
						int d = sc.nextInt();
						l.deleteBook(d);
						break;
					case "C":
						System.out.println("����������Ҫ�޸����id");
						int id = sc.nextInt();
						l.updateBook(id);
						break;
					case "D":
						System.out.println("����������Ҫ�������id");
						int id2 = sc.nextInt();
						l.findBook(id2);
						
						break;
					case "E":
						System.out.println("��������Ҫ���ͼ���ID");
						int jid = sc.nextInt();
						l.borrowsBooks(jid);
						break;
					case "F":
						System.out.println("��������Ҫ�黹��ͼ���ID");
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

	//ͼ������е���
	private static void info(LibraryManagement lm) {
		Library l1 = new Library("������", "β����һ��", 100);
		Library l2 = new Library("��Ӱ����", "������ʷ", 20);
		Library l3 = new Library("��ͥ��ʦ", "��Ұ��", 65);
		Library l4 = new Library("������", "��ɽ��", 22);
		Library l5 = new Library("������β��", "�浺��", 43);
		Library l6 = new Library("�����³³��", "�ȿ�����", 89);
		Library l7 = new Library("High DXD School", "ʯ̤һ��", 34);
		Library l8 = new Library("��������Ļ���", "�´�ֱ˾ ", 54);
		Library l9 = new Library("����", "��֪Ӣ��", 12);
		Library l10 = new Library("���ΰ���", "�����岩", 34);
		
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
