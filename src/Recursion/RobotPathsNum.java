package Recursion;

public class RobotPathsNum {

	//µÝ¹é°æ±¾
	public static int getRobotPathsNum(int i, int j, int N){
		if(i >= N || j >= N){
			return 0;
		}
		
		if(i == N-1 && j == N-1){
			return 1;
		}
		
		return getRobotPathsNum(i+1, j, N) + getRobotPathsNum(i, j+1, N);
	}
	
	//DP°æ±¾
	public static int getRobotPathsNum2(int N){
		int dp[] = new int[N];
		for(int i = 0; i < N; ++i)
			dp[i] = 1;
		
		for(int i = N-2; i >= 0; --i){
			for(int j = N-2; j >= 0; --j){
				dp[j] += dp[j+1];
			}
		}
		return dp[0];
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getRobotPathsNum(0, 0, 5));
		System.out.println(getRobotPathsNum2(5));
	}

}
