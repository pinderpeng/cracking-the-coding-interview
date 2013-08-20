package Recursion;

import java.util.ArrayList;

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
	
	public static void getRobotPaths(int N){
		 ArrayList<Point> cur = new ArrayList<Point>();
		 cur.add(new Point(0, 0));
		getRobotPathsHelper(0, 0, cur, N);
	}
	
	public static void getRobotPathsHelper(int i, int j, ArrayList<Point> cur, int N){
		if(i == N-1 && j == N-1){
			for(Point p : cur){
				System.out.print("(" + p.x + ", " + p.y + ")");
			}
			System.out.println();
		}
		
		if(i+1 < N){
			cur.add(new Point(i+1, j));
			getRobotPathsHelper(i+1, j, cur, N);
			cur.remove(cur.size()-1);
		}
		if(j+1 < N){
			cur.add(new Point(i, j+1));
			getRobotPathsHelper(i, j+1, cur, N);
			cur.remove(cur.size()-1);
		}
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
		System.out.println(getRobotPathsNum(0, 0, 3));
		System.out.println(getRobotPathsNum2(3));
		getRobotPaths(3);
	}

}
