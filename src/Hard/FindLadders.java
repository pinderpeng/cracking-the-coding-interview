package Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class FindLadders {

	public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
		ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();
		HashMap<String, HashSet<String>> previous = new HashMap<String, HashSet<String>>();		
		HashMap<String, Integer> level = new HashMap<String, Integer>();
		Queue<String> queue = new LinkedList<String>();
		queue.add(start);
		level.put(start, 1);
		while(!queue.isEmpty()){
			String pop = queue.remove();
			int popDepth = level.get(pop);	
			if(pop.equals(end)){
				break;
			}
			
			for(int i = 0; i < pop.length(); ++i){
				for(char ch = 'a'; ch <= 'z'; ++ch){
					if(ch != pop.charAt(i)){
						StringBuilder tmp = new StringBuilder(pop);
						tmp.setCharAt(i, ch);
						String word = tmp.toString();
						if(dict.contains(word)){
							if(previous.containsKey(word)){
								if(popDepth+1 == level.get(word)){
									queue.add(word);
									HashSet<String> arr = previous.get(word);
									arr.add(pop);
									previous.put(word, arr);
								}
							}else{
								queue.add(word);
								HashSet<String> arr = new HashSet<String>();
								arr.add(pop);
								previous.put(word, arr);
								level.put(word, popDepth+1);
							}
						}
					}
				}
			}
		}
		if(!previous.containsKey(end)){
			return ans;
		}
		
		ArrayList<String> cur = new ArrayList<String>();
		cur.add(0, end);
		getResult(start, end, cur, ans, previous);
		return ans;
	}
	
	public void getResult(String start, String end, ArrayList<String> cur, ArrayList<ArrayList<String>> ans,
			HashMap<String, HashSet<String>> previous){
		if(end.equals(start)){
			ans.add(new ArrayList<String>(cur));
			return;
		}
		
		HashSet<String> arr = previous.get(end);
		for(String pre : arr){
			cur.add(0, pre);
			getResult(start, pre, cur, ans, previous);
			cur.remove(0);
		}		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//"hot", "dog", ["hot","cog","dog","tot","hog","hop","pot","dot"]
		String start = "red";
		String end = "tax";
		//["ted","tex","red","tax","tad","den","rex","pee"]	
		HashSet<String> dict = new HashSet<String>();
		dict.add("ted");dict.add("tex");dict.add("red");
		dict.add("tax");dict.add("tad");dict.add("den");
		dict.add("rex");dict.add("pee");
		FindLadders fl = new FindLadders();
		ArrayList<ArrayList<String>> ans = fl.findLadders(start, end, dict);
		for(ArrayList<String> l : ans){
			for(String s : l){
				System.out.print(s + " ");
			}
			System.out.println();
		}
	}

}