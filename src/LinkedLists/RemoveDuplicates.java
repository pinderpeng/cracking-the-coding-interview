package LinkedLists;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class RemoveDuplicates {

	public static void removeDupllicates(Node head){
		if(head == null){
			return;
		}
		
		//version 1
		/*HashSet<Integer> set = new HashSet<Integer>();
		Node pre = null;
		Node cur = head;
		while(cur != null){
			if(set.contains(cur.data)){
				if(pre != null){
					pre.next = cur.next;
					cur = cur.next;
				}else{
					head = cur.next;
					cur = cur.next;
				}
			}else{
				set.add(cur.data);
				pre = cur;
				cur = cur.next;
			}
		}*/
		
		//version2
		//模拟在数组上的思路
		HashSet<Integer> set = new HashSet<Integer>();
		Node pre = null;
		Node cur = head;
		while(cur != null){
			if(set.contains(cur.data)){
					pre.next = cur.next;
			}else{
				set.add(cur.data);
				pre = cur;				
			}
			cur = cur.next;
		}
	}
	
	public static void removeDupllicates2(Node head){
		if(head == null){
			return;
		}
		
		Node cur = head;
		while(cur != null){
			Node pre = cur;
			Node last = cur.next;
			while(last != null){
				if(last.data == cur.data){
					pre.next = last.next;
				}else{
					pre = last;
				}
				last = last.next;
			}
			cur = cur.next;
		}
	}
	 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(0);
		head.appendToTail(1); head.appendToTail(1);
		head.appendToTail(1); head.appendToTail(2);
		head.appendToTail(3);head.appendToTail(1);
		removeDupllicates2(head);
		Node cur = head;
		while(cur != null){
			System.out.println(cur.data);
			cur = cur.next;
		}
	}

}
