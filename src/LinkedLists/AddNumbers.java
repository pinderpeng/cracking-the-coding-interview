package LinkedLists;

public class AddNumbers {

	public static Node addNumbers(Node list1, Node list2){
		int carry = 0;
		Node cur1 = list1, cur2 = list2;
		Node head = null;
		Node cur = null;
		while(cur1 != null || cur2 != null || carry != 0){
			int value = (cur1!=null?cur1.data:0) + (cur2!=null?cur2.data:0) + carry;
			Node node = new Node(value%10);
			if(cur == null){
				head = cur = node;
			}else{
				cur.next = node;
				cur = cur.next;
			}
			carry = value / 10;
			
			if(cur1 != null) cur1 = cur1.next;
			if(cur2 != null) cur2 = cur2.next;
		}
		return head;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node h1 = new Node(2);	h1.appendToTail(1); h1.appendToTail(1);
		Node h2 = new Node(5);	h2.appendToTail(3); h2.appendToTail(1);		
		Node head = addNumbers(h1, h2);
		
		Node cur = head;
		while(cur != null){
			System.out.println(cur.data);
			cur = cur.next;
		}
	}

}
