package SortingAndSearching;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person>{

	@Override
	public int compare(Person p1, Person p2) {
		// TODO Auto-generated method stub
		if(p1.ht < p2.ht){
			return -1;
		}else if(p1.ht == p2.ht){
			if(p1.wt < p1.wt){
				return -1;
			}
		}
		return 1;
	}		
}
