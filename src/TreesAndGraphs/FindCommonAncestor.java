package TreesAndGraphs;

public class FindCommonAncestor {

	public static boolean hasNode(TreeNode root, TreeNode node){
		if(root == null){
			return false;
		}
		
		if(root == node)
			return true;
		return hasNode(root.left, node) || hasNode(root.right, node);
	}
	
	
	//version 1
	/*public static TreeNode findCommonAncestorHelper(TreeNode root, TreeNode node1, TreeNode node2){
		if(hasNode(root.left, node1) && hasNode(root.left, node2)){
			return findCommonAncestorHelper(root.left, node1, node2);
		}
		if(hasNode(root.right, node1) && hasNode(root.right, node2)){
			return findCommonAncestorHelper(root.right, node1, node2);
		}
		return root;
	}*/
	
	//version2
	public static TreeNode findCommonAncestorHelper(TreeNode root, TreeNode node1, TreeNode node2){
		boolean b1 = hasNode(root.left, node1);
		boolean b2 = hasNode(root.left, node2);
		if(b1 != b2){
			return root;
		}
		
		if(b1 == true){
			return findCommonAncestorHelper(root.left, node1, node2);
		}else{
			return findCommonAncestorHelper(root.right, node1, node2);
		}
		
	}
	
	public static TreeNode findCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2){
		if(!hasNode(root, node1) || !hasNode(root, node2)){
			return null;
		}
		return findCommonAncestorHelper(root, node1, node2);
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
		
		System.out.println(findCommonAncestor(t[8], t[1], t[6]).v);
		
	}

}
