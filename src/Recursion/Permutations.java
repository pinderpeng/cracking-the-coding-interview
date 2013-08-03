package Recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutations {

	public static void getPermutations(String str, int n, String cur, ArrayList<Boolean> visited, 
			ArrayList<String> ans){
		if(n >= str.length()){
			ans.add(cur);
			return;
		}
		
		for(int i = 0; i < str.length(); ++i){
			if(visited.get(i) == false){
				visited.set(i, true);
				getPermutations(str, n+1, cur + str.charAt(i), visited, ans);
				visited.set(i, false);
				while(i+1 < str.length() && str.charAt(i) == str.charAt(i+1))
					i++;
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abccd";
		ArrayList<String> ans = new ArrayList<String>();
		ArrayList<Boolean> visited = new ArrayList<Boolean>();
		for(int i = 0; i < str.length(); ++i){
			visited.add(false);
		}
		String cur = "";
		
		char[] arr = str.toCharArray();
		Arrays.sort(arr);
		str = String.valueOf(arr);
		
		getPermutations(str, 0, cur, visited, ans);
		System.out.println("cnt: " + ans.size());
		for(String s : ans){
			System.out.println(s);
		}
	}

}
