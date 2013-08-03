package BitManipulation;

public class SameOneBits {

	public static void printBits(int n){
		for(int i = 0; i < 32; ++i){
			System.out.print((int)(n>>(31-i))&1);			
		}
		System.out.println();
	}
	
	public static int preSameOneBits(int n){
		int firstzero2one = -1;
		int firstzero = -1;
		for(int i = 0; i < 32; ++i){
			if(((n>>i) & 1) == 0){
				firstzero = i;
				break;
			}
		}
		
		if(firstzero == -1){
			System.out.println("do not contain zero.");
			return n;
		}
		
		for(int i = 0; i < 31; ++i){
			if((((n>>i) & 1) == 0 && ((n>>(i+1)) & 1) == 1) == true){
				firstzero2one = i;
				break;
			}
		}
		
		if(firstzero2one == -1){
			System.out.println("have not pre same one bits number.");
			return n;
		}
		
		n |= (1<<firstzero2one);
		n &= ~(1<<(firstzero2one+1));
		if(firstzero == firstzero2one){
			return n;
		}else{
			n |= ((1<<firstzero)-1);
			return n;
		}
	}
	
	public static int nextSameOneBits(int n){
		int firstone2zero = -1;
		int firstone = -1;
		for(int i = 0; i < 32; ++i){
			if(((n>>i) & 1) == 1){
				firstone = i;
				break;
			}
		}
		
		if(firstone == -1){
			System.out.println("do not contain one.");
			return n;
		}
		
		for(int i = 0; i < 31; ++i){
			if((((n>>i) & 1) == 1 && ((n>>(i+1)) & 1) == 0) == true){
				firstone2zero = i;
				break;
			}
		}
		
		if(firstone2zero == -1){
			System.out.println("have not next same one bits number.");
			return n;
		}
		
		n &= ~(1<<firstone2zero);
		n |= 1<<(firstone2zero+1);		
		if(firstone == firstone2zero){
			return n;
		}else{
			n &= ~0 - ((1<<firstone2zero)-1);
			n |= ((1<<(firstone2zero-firstone))-1);
			return n;
		}
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int v = 31;
		printBits(v);
		printBits(nextSameOneBits(v));
		printBits(preSameOneBits(v));
	}

}
