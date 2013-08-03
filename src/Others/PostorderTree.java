package Others;

import java.util.Stack;

public class PostorderTree {

	public static void postorderTree(TreeNode root){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<Boolean> rvisited = new Stack<Boolean>();
		TreeNode cur = root;
		while(!stack.empty() || cur != null){
			while(cur != null){
				stack.push(cur);
				rvisited.push(false);
				cur = cur.left;
			}
			
			TreeNode top = stack.pop();
			Boolean topstatus = rvisited.pop();
			if(top != null){
				if(topstatus == false && top.right != null){
					stack.push(top);
					rvisited.push(true);
					cur = top.right;
				}else{
					System.out.println(top.v);
				}
			}
		}
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
		t[0].left = t[1]; t[0].right = t[2];
		t[1].left = t[3]; t[1].right = t[4];
		t[2].left = t[5]; t[2].right = t[6];
		t[3].left = t[7]; t[3].right = t[8];
		t[8].left = t[9]; t[8].right = t[10];
		postorderTree(t[0]);
	}

}
