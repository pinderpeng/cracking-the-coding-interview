package BitManipulation;

public class SwapOddEvenBits {

	public static void printBits(int n){
		for(int i = 0; i < 32; ++i){
			System.out.print((int)(n>>(31-i))&1);			
		}
		System.out.println();
	}
	
	public static int setBit(int n, int i, boolean b){
		if(b == true){
			n |= (1<<i);
		}else{
			n &= ~(1<<i);
		}
		return n;
	}
	
	public static int swapOddEvenBits(int n){
		for(int i = 0; i < 32; i += 2){
			boolean even = (((n>>i)&1) == 1);
			boolean odd = (((n>>(i+1))&1) == 1);
			n = setBit(n, i, odd == true);
			n = setBit(n, i+1, even == true);
		}
		return n;
	}
	
	//可以这样搞，尼玛。。这不科学
	public static int swapOddEvenBits2(int n){
		return ((n&0xaaaaaaaa)>>1) | ((n&0x55555555)<<1);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int v = 324;
		printBits(v);
		printBits(swapOddEvenBits(v));
		printBits(swapOddEvenBits2(v));
	}

}
