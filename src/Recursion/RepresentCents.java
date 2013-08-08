package Recursion;

public class RepresentCents {

	public static int representCents(int n){
		int dp[] = new int[n+1];
		int value[] = new int[]{25,10,5,1};
		
		dp[0] = 1;
		for(int i = 0; i < value.length; ++i){
			for(int v = value[i]; v <= n; ++v){
				if(dp[v-value[i]] != -1)
					dp[v] += dp[v-value[i]];
			}
		}
		return dp[n];
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(representCents(10));
	}

}
