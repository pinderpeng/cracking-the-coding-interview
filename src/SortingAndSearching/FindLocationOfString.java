package SortingAndSearching;

public class FindLocationOfString {

	public static int findLoacationOfString(String []strs, String target){
		int low = 0, high = strs.length-1;
		while(low <= high){
			while(low < strs.length && strs[low].equals("")){
				low++;
			}
			if(low >= strs.length){
				return -1;
			}
			while(high >= 0 && strs[high].equals("")){
				high--;
			}
			if(high < 0){
				return -1;
			}
			int mid = low + (high-low)/2;
			while(mid <= high && strs[mid].equals("")){
				mid++;
			}
			
			if(target.compareTo(strs[mid]) == 0){
				return mid;
			}else if(target.compareTo(strs[mid]) > 0){
				low = mid+1;
			}else{
				high = mid-1;
			}
		}
		return -1;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String strs[] = new String[]{"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
		System.out.println(findLoacationOfString(strs, "ball"));
		
		String strs2[] = new String[]{"at", "", "", "", "", "ball", "car", "", "", "dad", "", ""};
		System.out.println(findLoacationOfString(strs2, "ballcar"));
	}

}
