package TreesAndGraphs;


public class InsertNode {

	public static void insertNode(TreeNode root, int v){
		TreeNode cur = root;
		TreeNode newNode = new TreeNode(v);
		while(cur != null){
			if(v <= cur.v){
				if(cur.left != null)
					cur = cur.left;
				else{
					cur.left = newNode;
					break;
				}
			}else{
				if(cur.right != null)
					cur = cur.right;
				else{
					cur.right = newNode;
					break;
				}
			}
		}
	}
	
	public static void printTree(TreeNode root){
		if(root == null)
			return;
		
		printTree(root.left);
		System.out.println(root.v);
		printTree(root.right);
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
		//printTree(t[8]);
		insertNode(t[8], 2);
		insertNode(t[8], 4);
		printTree(t[8]);
	}

}
