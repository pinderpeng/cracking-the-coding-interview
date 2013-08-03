package BitManipulation;

import java.util.ArrayList;

public class FindMissingInteger {

	public static int findMissingInteger(int A[]){
		int v = 0;
		for(int i = 0; i <= A.length; ++i){
			v ^= i;
		}
		
		for(int i = 0; i < A.length; ++i){
			v ^= A[i];
		}
		return v;
	}
	
	public class BitInteger{
		private int v;
		public static final int INTEGER_SIZE = 32;
		
		public BitInteger(int v){
			this.v = v;
		}
		
		public boolean fetch(int i){
			return ((v>>i)&1) == 1;
		}
	}
	
	public static int findMissingInteger2(ArrayList<BitInteger> arr){
		return findMissingInteger2Helper(arr, BitInteger.INTEGER_SIZE-1);
	}
	
	public static int findMissingInteger2Helper(ArrayList<BitInteger> arr, int col){
		if(col < 0) return 0;
		ArrayList<BitInteger> zero = new ArrayList<FindMissingInteger.BitInteger>();
		ArrayList<BitInteger> one = new ArrayList<FindMissingInteger.BitInteger>();
		for(BitInteger i : arr){
			if(i.fetch(col) == true){
				one.add(i);
			}else{
				zero.add(i);
			}
		}
		if(zero.size() >= one.size()){
			return findMissingInteger2Helper(arr, col-1)<<1 | 0;
		}else{
			return findMissingInteger2Helper(arr, col-1)<<1 | 1;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = new int[]{0,1,2,3,5,6};
		System.out.println(findMissingInteger(A));
	}

}
