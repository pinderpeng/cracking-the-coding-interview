package SortingAndSearching;

import java.util.Arrays;
import java.util.Comparator;

import ArraysAndStrings.Anagrams;

public class AnagramsSort {

	public class AnagramComparator implements Comparator<String> {

		public String sortChars(String s){
			char []arr = s.toCharArray();
			Arrays.sort(arr);
			return new String(arr);
		}
		
		@Override
		public int compare(String arg0, String arg1) {
			// TODO Auto-generated method stub
			return sortChars(arg0).compareTo(sortChars(arg1));
		}
		
	}
	
	public static void anagramSort(String[] strs){
		Arrays.sort(strs, new AnagramsSort().new AnagramComparator());
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []strs = new String[]{"abcd", "bacd", "bbd"};
		anagramSort(strs);
		for(String s : strs){
			System.out.println(s);
		}
	}

}
