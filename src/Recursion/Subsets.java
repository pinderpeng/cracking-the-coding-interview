package Recursion;

import java.util.ArrayList;

public class Subsets {
	
	public static void print(ArrayList<ArrayList<Integer>> src){
		System.out.println("size: " + src.size());
		for(ArrayList<Integer> arr : src){
			for(Integer i : arr){
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	
	////擦，java的ArrayList<ArrayList<Integer>>不支持对另外一个ArrayList<ArrayList<Integer>>的深拷贝，只是拷贝了ArrayList<Integer>指针
	public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> list, int n){		
		if(n < 0){
			ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
			ans.add(new ArrayList<Integer>());
			return ans;
		}
		
		ArrayList<ArrayList<Integer>> sub = getSubsets(list, n-1);
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		for(ArrayList<Integer> arr : sub){
			ans.add(new ArrayList<Integer>(arr));
			arr.add(list.get(n));
			ans.add(arr);
		}
		return ans;
	}
	
	public static ArrayList<ArrayList<Integer>> getSubsets2(ArrayList<Integer> list){
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		int n = list.size();
		for(int i = 0; i < (1<<n); ++i){
			ArrayList<Integer> arr = new ArrayList<Integer>();
			for(int j = 0; j < n; ++j){
				if(((i>>j)&1) == 1){
					arr.add(list.get(j));
				}
			}
			ans.add(arr);
		}
		return ans;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < 1; ++i){
			list.add(i);
		}
		
		ArrayList<ArrayList<Integer>> ans = getSubsets(list, list.size()-1);
		print(ans);		
		
		ArrayList<ArrayList<Integer>> ans2 = getSubsets2(list);
		print(ans2);		
	}

}
