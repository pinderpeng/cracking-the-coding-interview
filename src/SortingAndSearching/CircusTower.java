package SortingAndSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class CircusTower {
	
	public static int maxCircusTower(ArrayList<Person> ps){
		Collections.sort(ps, new PersonComparator());
		for(Person p : ps){
			System.out.println("(" + p.ht + ", " + p.wt + ")");
		}
		
		int []maxLen = new int[ps.size()];
		maxLen[0] = 1;
		for(int i = 1; i < ps.size(); ++i){
			maxLen[i] = 1;
			for(int j = i-1; j >= 0; --j){
				if(ps.get(i).ht != ps.get(j).ht && ps.get(i).wt > ps.get(j).wt){
					maxLen[i] = Math.max(maxLen[i], maxLen[j]+1);
				}
			}
		}
		
		int ans = maxLen[ps.size()-1];
		for(int i = ps.size()-2; i >= 0; --i){
			if(ps.get(i).ht == ps.get(ps.size()-1).ht){
				ans = Math.max(ans, maxLen[i]);
			}
		}
		return ans;
	}
	
	public static int bsearch(int []arr, int low, int high, int target){
		while(low <= high){
			int mid = low + (high-low)/2;
			if(target == arr[mid]){
				return mid;
			}else if(target < arr[mid]){
				high = mid-1;
			}else{
				low = mid+1;
			}
		}
		return low;
	}
	
	//temp code, it's wrong to solve this problem
	public static int maxCircusTower2(ArrayList<Person> ps){
		Collections.sort(ps, new PersonComparator());
		
		int []maxLen = new int[ps.size()];
		int []len = new int[ps.size()+1];
		int curMaxLen = 1;
		maxLen[0] = 1;
		len[1] = ps.get(0).wt;
		for(int i = 1; i < ps.size(); ++i){
			maxLen[i] = 1;
			int curv = ps.get(i).wt;
			int index = bsearch(len, 1, curMaxLen, curv);
			if(index < curMaxLen){
				maxLen[i] = index+1;
				if(curv < len[index+1]){
					curv = len[index+1];				
				}				
			}else{
				maxLen[i] = index+1;
				len[index+1] = curv;
				curMaxLen++;				
			}
		}
		
		int ans = maxLen[ps.size()-1];
		for(int i = ps.size()-2; i >= 0; --i){
			if(ps.get(i).ht == ps.get(ps.size()-1).ht){
				ans = Math.max(ans, maxLen[i]);
			}
		}
		return ans;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Person> ps = new ArrayList<Person>();
		ps.add(new Person(65, 100));
		ps.add(new Person(70, 150));
		ps.add(new Person(56, 90));
		ps.add(new Person(75, 190));
		//ps.add(new Person(60, 95));
		ps.add(new Person(56, 95));
		ps.add(new Person(68, 110));
		System.out.println(maxCircusTower(ps));
	}

}
