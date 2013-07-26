package TreesAndGraphs;

public class CreateMinHeightTree {

	public static TreeNode createMinHeightTreeHelper(int []arr, int i, int j){
		if(i > j){
			return null;
		}
		
		int mid = i + (j-i)/2;
		TreeNode root = new TreeNode(arr[mid]);
		root.left = createMinHeightTreeHelper(arr, i, mid-1);
		root.right = createMinHeightTreeHelper(arr, mid+1, j);
		return root;
	}
	
	public static TreeNode createMinHeightTree(int []arr){
		return createMinHeightTreeHelper(arr, 0, arr.length);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[]{1,2,3,4,5,6,7,8};
		TreeNode root = createMinHeightTree(arr);		
	}

}
