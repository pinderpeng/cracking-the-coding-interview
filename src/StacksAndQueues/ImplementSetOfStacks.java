package StacksAndQueues;

import java.util.ArrayList;

public class ImplementSetOfStacks {

	public class Node{
		public int v;
		public Node previous = null, next = null;
		public Node(int v){
			this.v = v;
		}
	}
	
	public class Stack{
		private Node top, below;
		private int capacity;
		private int size;
		public Stack(int capacity){
			top = below = null;
			size = 0;
			this.capacity = capacity;
		}
		
		public void push(int v){
			if(size >= capacity){
				System.out.println("the stack is full.");
				return;
			}
			
			Node tmp = new Node(v);
			size++;
			if(top == null){
				top = below = tmp;
			}else{
				tmp.previous = top;
				top.next = tmp;
				top = tmp;
			}
		}
		
		public int pop(){
			int v = top.v;
			if(top == null){
				System.out.println("the stack is empty.");
				return 0;
			}
			top = top.previous;
			if(top != null) top.next = null; //patch!
			size--;
			return v;
		}
		
		public boolean isEmpty(){
			return size == 0;
		}
		
		public boolean isFull(){
			return size == capacity;
		}
		
		public int removeBottom(){
			int v = below.v;
			below = below.next;
			if(below != null) below.previous = null; //patch!
			size--; //Attention!
			return v;
		}
	}
	
	public class SetOfStacks{
		private ArrayList<Stack> array = new ArrayList<Stack>();
		private int capacity;
		public SetOfStacks(int capacity){
			this.capacity = capacity;
		}
		
		public void push(int v){
			if(array.size() <= 0 || array.get(array.size()-1).isFull()){
					Stack s = new Stack(capacity);
					s.push(v);
					array.add(s);
			}else{
				array.get(array.size()-1).push(v);
			}
		}
		
		public int pop(){
			if(array.size() <= 0){
				System.out.println("the stack is empty.");
				return 0;
			}
			int v = array.get(array.size()-1).pop();
			if(array.get(array.size()-1).isEmpty()){
				array.remove(array.size()-1);
			}
			return v;
		}
		
		public int popAt(int stackid){
			if(stackid >= array.size()){
				System.out.println("can not pop at stackid.");
				return 0;
			}
			
			int tmp = array.get(stackid).pop();
			for(int i = stackid+1; i < array.size(); ++i){
				int v = array.get(i).removeBottom();
				array.get(i-1).push(v);
			}
			if(array.get(array.size()-1).isEmpty()){
				array.remove(array.size()-1);
			}
			return tmp;
		}
		
		public boolean isEmpty(){
			return array.size() == 0;
		}
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		Stack s = (new ImplementSetOfStacks()).new Stack(20);
		s.push(0);
		s.push(1);
		s.push(2);
		s.removeBottom();
		while(!s.isEmpty()){
			System.out.println(s.pop());
		}
		
		SetOfStacks ss = (new ImplementSetOfStacks()).new SetOfStacks(2);
		ss.push(0);
		ss.push(1);
		ss.push(2);
		ss.push(3);
		ss.popAt(0);
		//ss.popAt(1);
		while(!ss.isEmpty()){
			System.out.println(ss.pop());
		}
	}

}
