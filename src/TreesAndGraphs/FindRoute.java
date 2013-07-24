package TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FindRoute {

	public static boolean findRoute(Graph g, int u, int v){
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(u);
		while(!q.isEmpty()){
			int front = q.remove();
			if(front == v){
				return true;
			}
			
			ArrayList<Integer> arr = g.getAdj(front);			
			for(Integer i : arr){
				q.add(i);
			}
		}
		return false;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = new Graph();
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 6);
		g.addEdge(3, 4);
		int u = 0, v = 5;
		System.out.println(findRoute(g, u, v) || findRoute(g, v, u));
	}

}
