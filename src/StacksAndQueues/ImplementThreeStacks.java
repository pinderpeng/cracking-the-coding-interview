package StacksAndQueues;

public class ImplementThreeStacks {

	public class Node{
		public int v;
		public Node next = null;
		
		public Node(){
		}
		
		public Node(int v){
			this.v = v;
		}
	}
	
	public class ThreeStacks{
		public Node []array;
		public Node []stacks = new Node[3];		
		public Node freelist;
		
		public ThreeStacks(int size){
			array = new Node[size];
			for(int i = 0; i < size; ++i){ //Attention! There needs allocate new space for each index.
				array[i] = new Node();
			}
			for(int i = 0; i < size-1; ++i){
				array[i].next = array[i+1];
			}
			freelist = array[0];
			for(int i = 0; i < 3; ++i)
				stacks[i] = null;
		}
		
		public void push(int stackid, int v){
			Node tmp = freelist;
			if(freelist == null){
				System.out.println("there is no free space.");
				return;
			}else{
				freelist = freelist.next;
			}
			
			tmp.v = v;
			tmp.next = stacks[stackid];
			stacks[stackid] = tmp;
		}
		
		public int pop(int stackid){
			Node tmp = stacks[stackid];
			if(tmp == null){
				System.out.println("the stack is empty.");
				return 0;
			}
			
			stacks[stackid] = stacks[stackid].next;
			tmp.next = freelist;
			freelist = tmp;
			return tmp.v;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreeStacks ts = (new ImplementThreeStacks()).new ThreeStacks(100);
		ts.push(0, 0); ts.push(1, 1); ts.push(2, 2);
		ts.push(0, 3); ts.push(1, 4); ts.push(2, 5);
		System.out.println(ts.pop(1));
		System.out.println(ts.pop(2));
		System.out.println(ts.pop(0));
	}

}
