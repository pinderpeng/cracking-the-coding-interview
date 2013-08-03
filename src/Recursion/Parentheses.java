package Recursion;

import java.util.ArrayList;
import java.util.HashSet;

public class Parentheses {

	public static HashSet<String> generateParenttheses(int n){
		if(n == 1){
			HashSet<String> ans = new HashSet<String>();
			ans.add("()");
			return ans;
		}
		
		HashSet<String> sub = generateParenttheses(n-1);
		HashSet<String> ans = new HashSet<String>();
		for(String s : sub){
			ans.add("(" + s + ")");
			ans.add("()" + s);
			ans.add(s + "()");
		}
		return ans;
	}
	
	public static void generateParenttheses2(int n, int lcnt, String str, int N, HashSet<String> ans){
		if(n >= N){
			ans.add(str);
			return;
		}
		
		if(n+1-lcnt <= N/2 && lcnt >= n+1-lcnt){
			generateParenttheses2(n+1, lcnt, str + ")", N, ans);
		}
		
		if(lcnt+1 <= N/2){
			generateParenttheses2(n+1, lcnt+1, str + "(", N, ans);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> ans = generateParenttheses(3);
		System.out.println("size: " + ans.size());
		for(String s : ans){
			System.out.println(s);
		}
		
		HashSet<String> ans2 = generateParenttheses(3);
		System.out.println("size: " + ans2.size());
		generateParenttheses2(1, 0, "", 3, ans2);
		for(String s : ans2){
			System.out.println(s);
		}
	}

}