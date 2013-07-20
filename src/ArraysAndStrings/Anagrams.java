package ArraysAndStrings;


public class Anagrams {
	
	public static boolean anagrams(String s, String t){
		if(s.length() != t.length())
			return false;
		
		int []cmap = new int[256];
		for(int i = 0; i < cmap.length; ++i){
			cmap[i] = 0;
		}
		
		int numOfBin = 0;
		for(int i = 0; i < s.length(); ++i){
			if(cmap[s.charAt(i)] == 0)
				numOfBin++;
			cmap[s.charAt(i)]++;
		}
		
		for(int i = 0; i < t.length(); ++i){
			cmap[t.charAt(i)]--;
			if(cmap[t.charAt(i)] < 0){
				return false;
			}else if(cmap[t.charAt(i)] == 0){
				numOfBin--;
			}
		}
		return numOfBin == 0? true:false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(anagrams("abcde", "abedc"));
		System.out.println(anagrams("ababab", "baaabb"));
		System.out.println(anagrams("aaaa", "aaaa"));
	}

}
