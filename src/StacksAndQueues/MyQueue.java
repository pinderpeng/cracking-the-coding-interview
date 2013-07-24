package StacksAndQueues;

import java.util.Stack;

public class MyQueue<T> {

	private Stack<T> stack1 = new Stack<T>();
	private Stack<T> stack2 = new Stack<T>();
	
	public void add(T v){
		stack2.push(v);
	}
	
	public int size(){
		return stack2.size() + stack1.size();
	}
	
	public T remove(){
		if(stack1.isEmpty()){
			while(!stack2.isEmpty()){
				stack1.push(stack2.pop());
			}
		}
		return stack1.pop();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyQueue<Integer> myQueue = new MyQueue<Integer>();
		myQueue.add(0); myQueue.add(1);
		myQueue.add(2); myQueue.add(3);
		System.out.println(myQueue.remove());
	}

}
