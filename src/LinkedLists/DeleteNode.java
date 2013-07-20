package LinkedLists;

public class DeleteNode {

	public static boolean deleteNode(Node node){
		if(node == null){
			return false;
		}
		
		if(node.next == null){
			return false;
		}
		
		node.data = node.next.data;
		node.next = node.next.next;
		return true;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(0);
		head.appendToTail(1); head.appendToTail(5);
		head.appendToTail(6); head.appendToTail(2);
		head.appendToTail(3);head.appendToTail(4);
		deleteNode(head);
		Node cur = head;
		while(cur != null){
			System.out.println(cur.data);
			cur = cur.next;
		}
	}

}
