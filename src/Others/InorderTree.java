package Others;

import java.util.Stack;

public class InorderTree {
	public static void inorderTree(TreeNode root){
		//version 1
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode top = stack.peek();
			while(top.left != null){
				stack.push(top.left);
				top = top.left;
			}
			
			top = stack.pop();
			System.out.println(top.v);
			if(top.right != null){
				stack.push(top.right);
			}else{
				while(!stack.isEmpty() && top.right == null){
					top = stack.pop();
					System.out.println(top.v);
				}
				if(top.right != null)
					stack.push(top.right);
			}
		}
		
		//version 2
		/*Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur = root;
		while(!stack.empty() || cur != null){
			while(cur != null){
				stack.push(cur);
				cur = cur.left;
			}
			
			TreeNode top = stack.peek();
			stack.pop();
			System.out.println(top.v);
			cur = top.right;
		}*/
		
		//version 3
		/*Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		TreeNode cur = root;
		while(!stack.empty() || cur != null){
			while(cur != null && cur.left != null){
				stack.push(cur.left);
				cur = cur.left;
			}
			
			TreeNode top = stack.peek();
			stack.pop();
			System.out.println(top.v);
			cur = top.right;
			if(cur != null)
				stack.push(cur);
		}*/
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
		inorderTree(t[0]);
	}

}
