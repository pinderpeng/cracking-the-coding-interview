package Recursion;

import java.util.ArrayList;

public class Parentheses {

	public static ArrayList<String> generateParenttheses(int n){
		if(n == 1){
			ArrayList<String> ans = new ArrayList<String>();
			ans.add("()");
			return ans;
		}
		
		ArrayList<String> sub = generateParenttheses(n-1);
		ArrayList<String> ans = new ArrayList<String>();
		for(String s : sub){
			ans.add("(" + s + ")");
			ans.add("()" + s);
			ans.add(s + "()");
		}
		return ans;
	}
	
	//(()(
	public static ArrayList<String> generateParenttheses2(int n, int lcnt){
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> ans = generateParenttheses(3);
		for(String s : ans){
			System.out.println(s);
		}
	}

}