package lib2;

import java.util.Comparator;

public class MyComparatorID implements Comparator<Library>{
	@Override
	public int compare(Library o1, Library o2) {
		// TODO Auto-generated method stub
		return o1.getId() - o2.getId();
	}
		
}
