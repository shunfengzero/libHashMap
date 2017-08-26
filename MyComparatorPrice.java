package lib2;

import java.util.Comparator;

public class MyComparatorPrice implements Comparator<Library>{
	@Override
	public int compare(Library o1, Library o2) {
		// TODO Auto-generated method stub
		return o2.getPrice() - o1.getPrice();
	}
}
