package SortingAndSearching;

public class MergeSortedArrays {

	public static void mergeSortedArrays(int A[], int m, int B[], int n){
		int i = m-1, j = n-1;
		int index = m+n-1;
		while(i >= 0 && j >= 0){
			if(A[i] >= B[j]){
				A[index--] = A[i--];
			}else{
				A[index--] = B[j--];
			}
		}
		
		while(j >= 0){
			A[index--] = B[j--];
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []A = new int[]{2, 4, 8, 10, 0, 0, 0, 0};
		int []B = new int[]{3, 6, 12, 15};
		mergeSortedArrays(A, 4, B, 4);
		for(int i = 0; i < A.length; ++i){
			System.out.println(A[i]);
		}
	}

}
