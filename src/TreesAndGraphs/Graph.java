package TreesAndGraphs;

import java.util.ArrayList;

public class Graph {

	private ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	
	public void addEdge(int u, int v){
		while(list.size()-1 < u){
			list.add(new ArrayList<Integer>());
		}
		
		while(list.size()-1 < v){
			list.add(new ArrayList<Integer>());
		}
		
		list.get(u).add(v);
	}
	
	public ArrayList<Integer> getAdj(int u){
		return list.get(u);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
