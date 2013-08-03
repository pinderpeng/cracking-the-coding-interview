package TreesAndGraphs;

import java.util.ArrayList;

public class PrintSumupToValue {

	public static void printsumupToValueHelper(TreeNode root, int target, ArrayList<Integer> list, int sum){

		int tmp = sum;
		for(int i = -1; i < list.size(); ++i){
			if(i == -1)
				tmp = sum;
			else
				tmp -= list.get(i);
			if(tmp == target){
				for(int j = i+1; j < list.size(); ++j){
					System.out.print(list.get(j) + " ");
				}
				System.out.println();
			}
		}
		
		if(root.left != null){
			list.add(root.left.v);
			printsumupToValueHelper(root.left, target, list, sum + root.left.v);
			list.remove(list.size()-1);
		}
		
		if(root.right != null){
			list.add(root.right.v);
			printsumupToValueHelper(root.right, target, list, sum + root.right.v);
			list.remove(list.size()-1);
		}
	}
	
	public static void printSumupToValue(TreeNode root, int target){
		if(root == null){
			return;
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(root.v);
		printsumupToValueHelper(root, target, list, root.v);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode t[] = new TreeNode[11];
		for(int i = 0; i < 11; i++){
			t[i] = new TreeNode(i);
		}
		t[8].left = t[5]; t[8].right = t[10];
		t[5].left = t[3]; t[5].right = t[6];
		t[10].left = t[9];
		t[3].left = t[1];
		//t[1].left = t[4];
	
		printSumupToValue(t[8], 17);
	}

}
