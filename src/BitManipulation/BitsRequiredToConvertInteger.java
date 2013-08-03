package BitManipulation;

public class BitsRequiredToConvertInteger {

	public static int bitsRequiredToConvertInteger(int m, int n){
		int v = m^n;
		int cnt = 0;
		while(v != 0){
			v &= v-1;
			cnt++;
		}
		return cnt;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(bitsRequiredToConvertInteger(31, 14));
	}

}
