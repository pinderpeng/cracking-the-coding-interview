package Hard;

public class CountNumOfTwo {

	public static int countNumOfTwo(int n){		
		int pow = 1;
		int cnt = 0;
		while(pow < n){
			int digit = n/pow%10;
			int right = n/(pow*10);
			int left = n%pow;
			
			if(digit < 2){
				cnt += right*pow;
			}else if(digit > 2){
				cnt += (right+1)*pow;
			}else{
				cnt += right*pow + (left+1);
			}
			
			pow *= 10;
		}
		return cnt;
	}
	
	public static int countNumofTwoTester(int n){
		int cnt = 0;
		for(int i = 1; i <= n; ++i){
			int cur = i;
			while(cur > 0){
				if(cur%10 == 2){
					cnt++;
				}
				cur = cur/10;
			}
		}
		return cnt;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countNumOfTwo(1) == countNumofTwoTester(1));
		System.out.println(countNumOfTwo(2) == countNumofTwoTester(2));
		System.out.println(countNumOfTwo(100) == countNumofTwoTester(100));
		System.out.println(countNumOfTwo(1234) == countNumofTwoTester(1234));
		System.out.println(countNumOfTwo(10426) == countNumofTwoTester(10426));
	}

}
