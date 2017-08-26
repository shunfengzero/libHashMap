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
	HashMap<Integer,Library> map4 = new HashMap<Integer,Library>();//用来存放借的书
	//HashMap<Integer,HashMap<Integer,Library>> map;
	static boolean status= false;//借书的状态 false表示书未被借出
	
	
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
	 
	 //增
	 public void addBook(Library lib) {
		 map2.put(lib.getId(), lib);
	 }
	 
	 //删
	 public void deleteBook(int id) {
		 
		 if (map2.containsKey(id))
		 {
			 map2.remove(id);
		 System.out.println("该书已经被成功删除");
		 } else {
			 System.out.println("删除的图书不存在");
		 }
	 }
	 
	 //改
	 public void updateBook(int id) {
		 
		 
		 Scanner sc = new Scanner(System.in);
		
		 while (true) {
			 System.out.println("图书ID :" + id + "的信息如下：");
			 System.out.println("图书名字:" + map2.get(id).getName());
			 System.out.println("图书作者:" + map2.get(id).getAuthor());
			 System.out.println("图书价格:" + map2.get(id).getPrice());	
			 System.out.println("请输入你想要修改的信息：1. 图书名字; 2. 图书作者; 3.图书价格; 4. 退出修改");
			 int update = sc.nextInt();
			 
			 switch (update) {
			 		case 1:
			 			System.out.println("请输入你想要修改的名字");
			 			String name = sc.next();
			 			map2.get(id).setName(name);
			 			map2.put(id, map2.get(id));
			 		break;
			 		
			 		case 2:
			 			System.out.println("请输入你想要修改的输的作者");
			 			String author = sc.next();
			 			map2.get(id).setAuthor(author);
			 			map2.put(id, map2.get(id));
			 		break;
			 		
			 		case 3:
			 			System.out.println("请输入你想要修改的价格");
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
	 
	 
	 //查
	public void findBook(int id) throws IDNotFoundExtception {
		if (id == 0 || id < 0) {
			throw new IDNotFoundExtception("输入id不合法");
		}
		 
		 System.out.println(map2.get(id));
		 
	 }
	
	//ID按升序排列
	public void showId() {
		
	
		TreeMap<Library,Integer> map3 = new  TreeMap<Library,Integer>(new MyComparatorID());
		//遍历
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
			System.out.println(" 图书ID: " + i.getId()  + " 图书名字 ："  + i.getName() + " 图书作者 ： " + 
					i.getAuthor() + " 图书价格 ： " + i.getPrice() + "\r\n");
		}	
		
	
	}
	
	//书的价格按 降序排列 
	public void showPrice() {

		ArrayList<Library> list = new ArrayList<Library>();
		
		//添加
		Collection<Library> c = map2.values();	
		Iterator<Library> it = c.iterator();
		while (it.hasNext()) {					
			Library i = it.next();
			list.add(i);
		}
		
		Collections.sort(list,new MyComparatorPrice());
		//遍历
		for (Library library : list) {
			System.out.println(library.toString());
		}
	
	}
	
	//借书 status flase 未被借出
	public void borrowsBooks(int id) {
	
		 if (status) {
			 System.out.println("该书的信息如下");
			 System.out.println(map4.get(id));
			 System.out.println("对不起，该书已经被借出");
		 } else {
			 System.out.println("该书的信息如下");
			 System.out.println(map2.get(id));
			 map4.put(id, map2.get(id));
			 map2.remove(id);
			 status = true;	
			 System.out.println("你已经借出此图书,请记得及时归还");
		 }	
	}
	
	//还书
	public void returnBook(int id) {
			map2.put(id, map4.get(id));
			status = false;
			System.out.println("该书已经被归还");
	}
	
	//展示
	public void show() {
		Set<Integer> set = map2.keySet();
		
		Iterator<Integer> it = set.iterator();
		while (it.hasNext()) {
			Library i = map2.get(it.next());
			System.out.println(" 图书ID: " + i.getId()  + " 图书名字 ："  + i.getName() + " 图书作者 ： " + 
					i.getAuthor() + " 图书价格 ： " + i.getPrice() + "\r\n");
		}	
	}
	
}
