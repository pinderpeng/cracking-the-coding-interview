package Recursion;

import java.util.ArrayList;
import java.util.HashSet;

public class Parentheses {

	//µİ¹é°æ±¾1
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
	
	//µİ¹é°æ±¾1-1
	public static void generateParenttheses11(int n, String cur, int N, HashSet<String> ans){
		if(n >= N){
			ans.add(cur);
			return;
		}
		
		generateParenttheses11(n+1, cur + "()", N, ans);
		generateParenttheses11(n+1, "()" + cur, N, ans);
		generateParenttheses11(n+1, "(" + cur + ")", N, ans);
	}
	
	//µİ¹é°æ±¾2
	public static void generateParenttheses2(int n, int lcnt, String str, int N, HashSet<String> ans){
		if(n >= 2*N){
			ans.add(str);
			return;
		}
		
		if(n+1-lcnt <= N && lcnt >= n+1-lcnt){
			generateParenttheses2(n+1, lcnt, str + ")", N, ans);
		}
		
		if(lcnt+1 <= N){
			generateParenttheses2(n+1, lcnt+1, str + "(", N, ans);
		}
	}
	
	//µü´ú°æ±¾
	public static HashSet<String> generateParenttheses3(int n){
		HashSet<String> org = new HashSet<String>();
		org.add("()");
		for(int i = 1; i < n; ++i){
			HashSet<String> ans = new HashSet<String>();
			for(String s : org){
				ans.add("()" + s);
				ans.add(s + "()");
				ans.add("(" + s + ")");
			}
			org = ans;
		}
		return org;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> ans = generateParenttheses(3);
		System.out.println("ans size: " + ans.size());
		for(String s : ans){
			System.out.println(s);
		}
		
		HashSet<String> ans11 = new HashSet<String>();		
		generateParenttheses11(0, "", 3, ans11);
		System.out.println("ans11 size: " + ans11.size());
		for(String s : ans11){
			System.out.println(s);
		}
		
		HashSet<String> ans2 = new HashSet<String>();		
		generateParenttheses2(0, 0, "", 3, ans2);
		System.out.println("ans2 size: " + ans2.size());
		for(String s : ans2){
			System.out.println(s);
		}
		
		HashSet<String> ans3 = generateParenttheses3(3);
		System.out.println("ans3 size: " + ans3.size());
		for(String s : ans3){
			System.out.println(s);
		}
	}

}