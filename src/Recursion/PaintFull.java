package Recursion;

public class PaintFull {

	public static void paintFull(int [][]screen, int i, int j, int srcColor){
		if(i < 0 || j < 0 || i >= screen.length || j >= screen[0].length || screen[i][j] != -1){
			return;
		}
		
		screen[i][j] = srcColor;
		paintFull(screen, i-1, j, srcColor);
		paintFull(screen, i+1, j, srcColor);
		paintFull(screen, i, j-1, srcColor);
		paintFull(screen, i, j+1, srcColor);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]screen = {{-1,0,1}, {-1,-1,2}, {0, -1, 3}};
		paintFull(screen, 0, 0, 1);
		for(int i = 0; i < screen.length; ++i){
			for(int j = 0; j < screen[0].length; ++j){
				System.out.print(screen[i][j] + " ");
			}
			System.out.println();
		}
	}

}
