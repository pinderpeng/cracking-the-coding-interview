package TreesAndGraphs;

public class CheckBalanceTree {

	public static class IntegerWrapper{
		public Integer v;
	}
	
	/*public static boolean checkBalanceTree(TreeNode root, IntegerWrapper depth){
		if(root == null){
			depth.v = 0;
			return true;
		}
		
		IntegerWrapper ld = new IntegerWrapper();
		IntegerWrapper rd = new IntegerWrapper();
		if(checkBalanceTree(root.left, ld) && checkBalanceTree(root.right, rd) && Math.abs(ld.v-rd.v) <= 1){
			depth.v = Math.max(ld.v, rd.v)+1;
			return true;
		}
		return false;
	}*/
	
	public static void checkBalanceTreeHepler(TreeNode root, int depth, IntegerWrapper minDepth, IntegerWrapper maxDepth){
		if(root.left == null && root.right == null){
			depth += 1;
			if(depth < minDepth.v){
				minDepth.v = depth;
			}
			if(depth > maxDepth.v){
				maxDepth.v = depth;
			}
			return;
		}else if(root.right == null){
			checkBalanceTreeHepler(root.left, depth+1, minDepth, maxDepth);
		}else if(root.left == null){
			checkBalanceTreeHepler(root.right, depth+1, minDepth, maxDepth);
		}else{
			checkBalanceTreeHepler(root.left, depth+1, minDepth, maxDepth);
			checkBalanceTreeHepler(root.right, depth+1, minDepth, maxDepth);
		}
	}
	
	public static boolean checkBalanceTree(TreeNode root){
		IntegerWrapper minDepth = new IntegerWrapper();
		IntegerWrapper maxDepth = new IntegerWrapper();
		minDepth.v = Integer.MAX_VALUE;
		maxDepth.v = Integer.MIN_VALUE;
		checkBalanceTreeHepler(root, 0, minDepth, maxDepth);
		System.out.println(minDepth.v + " " + maxDepth.v);
		if(maxDepth.v - minDepth.v <= 1)
			return true;
		return false;
	}
	
	public static int maxDepth(TreeNode root){
		if(root == null) return 0;
		return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
	}
	
	public static int minDepth(TreeNode root){
		if(root == null) return 0;
		return Math.min(minDepth(root.left), minDepth(root.right))+1;
	}
	
	public static boolean checkBalanceTree2(TreeNode root){
		return (maxDepth(root)-minDepth(root)<=1);
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
		
		IntegerWrapper depth = new IntegerWrapper();
		System.out.println(checkBalanceTree(t[8]));
		System.out.println(checkBalanceTree2(t[8]));
	}

}
