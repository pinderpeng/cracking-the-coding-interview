package SortingAndSearching;

public class FindElementInRotatedArray {

	public static int findElementInRoatedArray(int arr[], int target){
		int low = 0, high = arr.length-1;
		while(low <= high){
			int mid = low + (high - low)/2;
			if(target == arr[mid]){
				return mid;
			}
			
			if(arr[low] <= arr[mid]){
				if(target >= arr[low] && target < arr[mid]){
					high = mid-1;
				}else{
					low = mid+1;
				}
			}else{
				if(target > arr[mid] && target <= arr[high]){
					low = mid+1;
				}else{
					high = mid-1;
				}
			}
		}
		return -1;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[]{15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
		System.out.println(findElementInRoatedArray(arr, 5));
	}

}
