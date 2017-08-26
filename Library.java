package lib2;

public class Library {
	
	private int id;
	private String name;
	private int price;
	private String author;
	
	private static int count = 1;
	
	{
		id = count;
		count++;
	}
	
	public Library(String name, String author, int price) {
		setName(name);
		setAuthor(author);
		setPrice(price);
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	 
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return " [图书ID: " + this.getId()  + " 图书名字 ："  + this.getName() + " 图书作者 ： " + 
					this.getAuthor() + " 图书价格 ： " + this.getPrice() + "]\r\n";
	}
	
}
