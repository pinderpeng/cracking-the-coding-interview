package SortingAndSearching;

public class FindElementInMatrix {

	public static boolean findElementInMatrix(int [][]matrix, int target){
		int row = 0, col = matrix[0].length-1;
		while(row < matrix.length && col >= 0){
			if(matrix[row][col] == target){
				System.out.println(row + " " + col);
				return true;
			}else if(matrix[row][col] > target){
				col--;
			}else{
				row++;
			}
		}
		return false;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
