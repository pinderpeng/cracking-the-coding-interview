package LinkedLists;

public class Node {

	Node next = null;
	int data;
	public Node(int data){
		this.data = data;
	}
	
	void appendToTail(int data){
		Node end = new Node(data);
		Node cur = this;
		while(cur.next != null){
			cur = cur.next;
		}
		cur.next = end;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
