package TreesAndGraphs;

public class DecideSubtree {

	public static boolean isSubtreeHelper(TreeNode T1, TreeNode T2){
		if(T1 == null && T2 == null)
			return true;
		else if(T1 == null || T2 == null){
			return false;
		}
		
		if(T1.v != T2.v)
			return false;
		else
			return isSubtreeHelper(T1.left, T2.left) && isSubtreeHelper(T1.right, T2.right);
	}
	
	public static boolean isSubtree(TreeNode T1, TreeNode T2){
		if(isSubtreeHelper(T1, T2)){
			return true;
		}else{
			return isSubtree(T1.left, T2) || isSubtree(T1.right, T2);
		}
	}
	
	//Attention: have not consider this situation, etc. T2 == null
	public static boolean isSubtree2(TreeNode T1, TreeNode T2){
		if(T2 == null){
			return true;
		}
		return isSubtree(T1, T2);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
