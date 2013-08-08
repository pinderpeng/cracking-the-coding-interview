package Mathmetical;

import java.util.ArrayList;

public class FindKthNumber {

	public static int findKthNumber(int k){
		int ia = 0, ib = 0, ic = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(3*5*7);
		for(int i = 1; i < k; ++i){
			while(list.get(ia)*3 <= list.get(i-1)) ++ia;
			while(list.get(ib)*5 <= list.get(i-1)) ++ib;
			while(list.get(ic)*7 <= list.get(i-1)) ++ic;		
			list.add(Math.min(Math.min(list.get(ia)*3, list.get(ib)*5), list.get(ic)*7));
		}
		return list.get(k-1);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 1; i <= 20; ++i)
			System.out.println(findKthNumber(i)/(3*5*7));
	}

}
