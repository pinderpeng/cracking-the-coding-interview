package Recursion;

public class Fibonacci {

	//µÝ¹é°æ±¾
	public static int fibonacci(int n){
		if(n == 0) return 0;
		if(n == 1) return 1;
		return fibonacci(n-1) + fibonacci(n-2);
	}
	
	//Î²µÝ¹é°æ±¾
	public static int fibonacci2(int n, int v1, int v2){
		if(n == 1){
			return v2;
		}
		return fibonacci2(n-1, v2, v1+v2);
	}
	
	//µü´ú°æ±¾ÂÔ
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fibonacci(10));
		System.out.println(fibonacci2(2, 0, 1));
	}

}
