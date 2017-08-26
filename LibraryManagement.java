package lib2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class LibraryManagement {
	
	private String name;
	private static LibraryManagement lm = null;
	
	//Library l = new Library();
	HashMap<Integer,Library> map2;
	HashMap<Integer,Library> map4 = new HashMap<Integer,Library>();//������Ž����
	//HashMap<Integer,HashMap<Integer,Library>> map;
	static boolean status= false;//�����״̬ false��ʾ��δ�����
	
	
	 private LibraryManagement(String name) {
		 this.name = name;
		 map2 = new HashMap<Integer,Library>();
	 }
 
	 
	 public String getName() {
		return name;
	}

	public static LibraryManagement getInstance(String name) {
		 if (lm == null) {
			 lm = new LibraryManagement(name);
		 }
		 return lm; 
	 }
	 
	 //��
	 public void addBook(Library lib) {
		 map2.put(lib.getId(), lib);
	 }
	 
	 //ɾ
	 public void deleteBook(int id) {
		 
		 if (map2.containsKey(id))
		 {
			 map2.remove(id);
		 System.out.println("�����Ѿ����ɹ�ɾ��");
		 } else {
			 System.out.println("ɾ����ͼ�鲻����");
		 }
	 }
	 
	 //��
	 public void updateBook(int id) {
		 
		 
		 Scanner sc = new Scanner(System.in);
		
		 while (true) {
			 System.out.println("ͼ��ID :" + id + "����Ϣ���£�");
			 System.out.println("ͼ������:" + map2.get(id).getName());
			 System.out.println("ͼ������:" + map2.get(id).getAuthor());
			 System.out.println("ͼ��۸�:" + map2.get(id).getPrice());	
			 System.out.println("����������Ҫ�޸ĵ���Ϣ��1. ͼ������; 2. ͼ������; 3.ͼ��۸�; 4. �˳��޸�");
			 int update = sc.nextInt();
			 
			 switch (update) {
			 		case 1:
			 			System.out.println("����������Ҫ�޸ĵ�����");
			 			String name = sc.next();
			 			map2.get(id).setName(name);
			 			map2.put(id, map2.get(id));
			 		break;
			 		
			 		case 2:
			 			System.out.println("����������Ҫ�޸ĵ��������");
			 			String author = sc.next();
			 			map2.get(id).setAuthor(author);
			 			map2.put(id, map2.get(id));
			 		break;
			 		
			 		case 3:
			 			System.out.println("����������Ҫ�޸ĵļ۸�");
			 			int price = sc.nextInt();
			 			map2.get(id).setPrice(price);
			 			map2.put(id, map2.get(id));
			 		break;
			 		case 4:
			 		return;
			 		
			 		default:
			 		break;
			 		
			} 
		 }
	
	 }
	 
	 
	 //��
	public void findBook(int id) throws IDNotFoundExtception {
		if (id == 0 || id < 0) {
			throw new IDNotFoundExtception("����id���Ϸ�");
		}
		 
		 System.out.println(map2.get(id));
		 
	 }
	
	//ID����������
	public void showId() {
		
	
		TreeMap<Library,Integer> map3 = new  TreeMap<Library,Integer>(new MyComparatorID());
		//����
		Set<Integer> set = map2.keySet();	
		Iterator<Integer> it = set.iterator();
		while (it.hasNext()) {
			
			int i = it.next();
			map3.put(map2.get(i),map2.get(i).getId());
		}
		

		Set<Library> set2 = map3.keySet();
		Iterator<Library> it2 = set2.iterator();
		while (it2.hasNext()) {
			Library i = it2.next();
			System.out.println(" ͼ��ID: " + i.getId()  + " ͼ������ ��"  + i.getName() + " ͼ������ �� " + 
					i.getAuthor() + " ͼ��۸� �� " + i.getPrice() + "\r\n");
		}	
		
	
	}
	
	//��ļ۸� �������� 
	public void showPrice() {

		ArrayList<Library> list = new ArrayList<Library>();
		
		//���
		Collection<Library> c = map2.values();	
		Iterator<Library> it = c.iterator();
		while (it.hasNext()) {					
			Library i = it.next();
			list.add(i);
		}
		
		Collections.sort(list,new MyComparatorPrice());
		//����
		for (Library library : list) {
			System.out.println(library.toString());
		}
	
	}
	
	//���� status flase δ�����
	public void borrowsBooks(int id) {
	
		 if (status) {
			 System.out.println("�������Ϣ����");
			 System.out.println(map4.get(id));
			 System.out.println("�Բ��𣬸����Ѿ������");
		 } else {
			 System.out.println("�������Ϣ����");
			 System.out.println(map2.get(id));
			 map4.put(id, map2.get(id));
			 map2.remove(id);
			 status = true;	
			 System.out.println("���Ѿ������ͼ��,��ǵü�ʱ�黹");
		 }	
	}
	
	//����
	public void returnBook(int id) {
			map2.put(id, map4.get(id));
			status = false;
			System.out.println("�����Ѿ����黹");
	}
	
	//չʾ
	public void show() {
		Set<Integer> set = map2.keySet();
		
		Iterator<Integer> it = set.iterator();
		while (it.hasNext()) {
			Library i = map2.get(it.next());
			System.out.println(" ͼ��ID: " + i.getId()  + " ͼ������ ��"  + i.getName() + " ͼ������ �� " + 
					i.getAuthor() + " ͼ��۸� �� " + i.getPrice() + "\r\n");
		}	
	}
	
}
