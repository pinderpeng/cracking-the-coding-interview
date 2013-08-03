package BitManipulation;

public class CheckPowerOfTwo {

	public static boolean checkPowerOfTwo(int n){
		return ((n&(n-1))==0);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(checkPowerOfTwo(32));
		System.out.println(checkPowerOfTwo(31));
	}

}
