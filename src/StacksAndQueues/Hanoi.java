package StacksAndQueues;

import java.util.Stack;

public class Hanoi {

	public class Node {
		public int a, b, c, level;
		public Node(int a, int b, int c, int level){
			this.a = a;
			this.b = b;
			this.c = c;
			this.level = level;
		}
	}
	
	public static void hanoi(int n){
		Stack<Node> stack = new Stack<Node>();
		Node cur = (new Hanoi()).new Node(0, 1, 2, 0);
		while(!stack.empty() || cur.level < n){
			while(cur.level < n){
				stack.push((new Hanoi()).new Node(cur.a, cur.b, cur.c, cur.level));
				cur = (new Hanoi()).new Node(cur.a, cur.c, cur.b, cur.level+1);
			}
			
			Node top = stack.pop();
			System.out.println("move from " + top.a + " to " + top.c);
			cur = (new Hanoi()).new Node(top.b, top.a, top.c, top.level+1);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		hanoi(2);
	}

}
