package LinkedLists;

public class GetBeginningNode {

	public static Node getBeginningNode(Node head){
		//version 1
		/*if(head == null)
			return null;
		
		Node cur = head;
		Node last = head;
		while(cur != null && last != null){			
			cur = cur.next;
			if(last.next != null){
				last = last.next.next;
			}else{
				break;
			}
			
			if(cur == last){
				break;
			}
		}
		
		if(cur != last){
			return null;
		}
		
		cur = head;
		while(cur != null){
			Node runner = last;
			do{
				if(cur == runner){
					return cur;
				}
				runner = runner.next;
			}while(runner != last);
			cur = cur.next;
		}
		return null;*/
		
		//version 2
		if(head == null)
			return null;
		
		Node cur = head;
		Node last = head;
		while(cur != null && last != null){			
			cur = cur.next;
			if(last.next != null){
				last = last.next.next;
			}else{
				break;
			}
			
			if(cur == last){
				break;
			}
		}
		
		if(cur != last || cur == null){
			return null;
		}
		
		cur = head;
		while(cur != last){
			cur = cur.next;
			last = last.next;
		}
		return cur;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(0);
		Node n1 = new Node(1); head.next = n1;
		Node n2 = new Node(2); n1.next = n2;
		Node n3 = new Node(3); n2.next = n3;
		n3.next = n1;
		System.out.println(getBeginningNode(head).data);
	}

}
