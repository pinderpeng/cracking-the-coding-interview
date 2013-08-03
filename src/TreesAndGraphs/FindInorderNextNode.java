package TreesAndGraphs;

public class FindInorderNextNode {

	public static TreeNodeWithParent findInorderNextNode(TreeNodeWithParent node){
		if(node.right != null){
			TreeNodeWithParent cur = node.right;
			while(cur.left != null){
				cur = cur.left;
			}
			return cur;
		}else{
			TreeNodeWithParent cur = node;			
			while(cur.parent != null && cur.parent.right == cur){
				cur = cur.parent;
			}
			return cur.parent;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
