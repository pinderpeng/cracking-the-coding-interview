package Recursion;

public class EightQueens {

	public static boolean isOk(int []arr, int line, int col){
		for(int k = 0; k < line; ++k){
			if(arr[k] == col || Math.abs(line-k) == Math.abs(col-arr[k])){
				return false;
			}
		}
		return true;
	}
	
	public static void eightQueens(int n, int []arr, int i){
		if(i >= n){
			for(int k = 0; k < arr.length; ++k){
				System.out.print(arr[k] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int k = 0; k < n; ++k){
			if(isOk(arr, i, k)){
				arr[i] = k;
				eightQueens(n, arr, i+1);
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr = new int[8];
		eightQueens(8, arr, 0);
	}

}
