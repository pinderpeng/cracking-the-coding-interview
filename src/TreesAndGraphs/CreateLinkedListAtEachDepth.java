package TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CreateLinkedListAtEachDepth {

	public static ArrayList<LinkedList<TreeNode>> createLinkedListAtEachDepth(TreeNode root){
		ArrayList<LinkedList<TreeNode>> ans = new ArrayList<LinkedList<TreeNode>>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		queue.add(null);
		LinkedList<TreeNode> cur = new LinkedList<TreeNode>();
		while(!queue.isEmpty()){
			TreeNode front = queue.remove();
			if(front == null){
				if(!queue.isEmpty())
					queue.add(null);
				ans.add(new LinkedList<TreeNode>(cur));
				cur.clear();
			}else{
				cur.add(front);
				if(front.left != null) queue.add(front.left);
				if(front.right != null) queue.add(front.right);
			}
		}
		return ans;
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
		ArrayList<LinkedList<TreeNode>> ans = createLinkedListAtEachDepth(t[8]);
		for(LinkedList<TreeNode> list : ans){
			for(TreeNode node : list){
				System.out.print(node.v + " ");
			}
			System.out.println();
		}
	}

}
