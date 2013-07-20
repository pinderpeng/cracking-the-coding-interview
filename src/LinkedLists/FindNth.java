package LinkedLists;

public class FindNth {

	public static Node findNth(Node head, int n){
		if(head == null || n <= 0)
			return null;
		
		Node cur = head;
		while(cur != null && n > 1){
			cur = cur.next;
			n--;
		}
		
		if(cur == null){
			return null;
		}
		
		Node pre = head;
		while(cur.next != null){
			cur = cur.next;
			pre = pre.next;
		}
		return pre;
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
		System.out.println(findNth(head, 1).data);
	}
}
