package StacksAndQueues;

import java.util.ArrayList;
import java.util.Stack;

public class GetMinimumStack{
	//version 1
	/*public class MinimumStack{
		ArrayList<Integer> arr = new ArrayList<Integer>();
		ArrayList<Integer> min = new ArrayList<Integer>();
		
		public void push(int v){
			if(arr.size() <= 0){
				arr.add(v);
				min.add(v);
				return;
			}
			
			if(v < arr.get(arr.size()-1)){
				min.add(v);
			}else{
				min.add(arr.get(arr.size()-1));
			}
			arr.add(v);
		}
		
		public void pop(){
			if(arr.size() <= 0){
				System.out.println("the stack is empty.");
				return;
			}
			arr.remove(arr.size()-1);
			min.remove(min.size()-1);
		}
		
		public int getMin(){
			if(arr.size() <= 0){
				System.out.println("the stack is empty.");
				return Integer.MAX_VALUE;
			}
			return min.get(min.size()-1);
		}
	}*/
	
	//version 2
	/*public class MinimumStack{
		ArrayList<Integer> arr = new ArrayList<Integer>();
		ArrayList<Integer> min = new ArrayList<Integer>();
		public void push(int v){
			if(arr.size() <= 0){
				arr.add(v);
				min.add(v);
				return;
			}
			
			if(v <= arr.get(arr.size()-1)){
				min.add(v);
			}
			arr.add(v);
		}
		
		public void pop(){
			if(arr.size() <= 0){
				System.out.println("the stack is empty.");
				return;
			}
			if(arr.get(arr.size()-1) == min.get(min.size()-1)){
				min.remove(min.size()-1);
			}
			arr.remove(arr.size()-1);
		}
		
		public int getMin(){
			if(arr.size() <= 0){
				System.out.println("the stack is empty.");
				return Integer.MAX_VALUE;
			}
			return min.get(min.size()-1);
		}
	}*/
	
	//version 3
	public class MinimumStack extends Stack<Integer>{
		
		Stack<Integer> stack2 = new Stack<Integer>();
		public void push(int v){
			if(v <= min()){
				stack2.push(v);
			}
			super.push(v);
		}
		
		public Integer pop(){
			int v = super.pop();
			if(v == min()){
				stack2.pop();
			}
			return v;
		}
		
		public int min(){
			if(stack2.isEmpty()){
				return Integer.MAX_VALUE;
			}else{
				return stack2.peek();
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*MinimumStack ms = (new GetMinimumStack()).new MinimumStack();
		ms.push(1); ms.push(1); ms.push(3); ms.push(0); 
		System.out.println(ms.getMin());
		
		ms.pop();
		System.out.println(ms.getMin());*/
	}

}
