package SystemDesignAndMemoryLimits;

public class DuplicateElements {

	public class BitSet{
		int []bitmap;
		public BitSet(int size){
			bitmap = new int[(size>>5)+1];
		}
		
		public void setBit(int n){
			bitmap[n>>5] |= 1<<(n&0x1f);
		}
		
		public boolean getBit(int n){
			return ((bitmap[n>>5]&(1<<(n&0x1f))) == 1);
		}		
	}
	
	public static void dumplicateElements(int []arr){
		BitSet bs = new DuplicateElements().new BitSet(32000);
		for(int i = 0; i < arr.length; ++i){
			if(bs.getBit(arr[i]-1)){ //Notice: start from 1 to N
				System.out.println(arr[i]);
			}else{
				bs.setBit(arr[i]-1);
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
