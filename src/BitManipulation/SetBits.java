package BitManipulation;

public class SetBits {

	public static int setBits(int N, int M, int i, int j){
		for(int k = i; k <= j; ++k){
			if(((M>>(k-i))&1) == 1){
				N |= 1<<k;
			}else{
				N &= ~(1<<k);
			}
		}
		return N;
	}
	
	public static int setBits2(int N, int M, int i, int j){
		N &= ~(((1<<(j-i+1))-1)<<i);
		N |= M<<i;
		return N;
	}
	
	public static int setBits3(int N, int M, int i, int j){
		N &= (~0 - ((1<<j)-1)) | (1<<i-1);
		N |= M<<i;
		return N;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(setBits((int) Math.pow(2, 10), 1+4+16, 2, 6));
		System.out.println(setBits2((int) Math.pow(2, 10), 1+4+16, 2, 6));
		System.out.println(setBits3((int) Math.pow(2, 10), 1+4+16, 2, 6));
	}

}
