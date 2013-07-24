package StacksAndQueues;

import java.util.Stack;

public class SortStack {

	public static void sortStack(Stack<Integer> stack){
		Stack<Integer> tmp = new Stack<Integer>();
		while(!stack.isEmpty()){
			int top = stack.pop();
			while(!tmp.isEmpty() && top > tmp.peek()){
				stack.push(tmp.pop());
			}
			tmp.push(top);
		}
		
		while(!tmp.isEmpty()){
			stack.push(tmp.pop());
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(3); stack.push(2); stack.push(1);
		sortStack(stack);
		
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
	}

}
