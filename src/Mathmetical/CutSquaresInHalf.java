package Mathmetical;

public class CutSquaresInHalf {

	public class Line {
		Point p1, p2;
		public Line(Point p1, Point p2){
			this.p1 = p1;
			this.p2 = p2;
		}
	}
	
	public class Point{
		public double x, y;
		public Point(double x, double y){
			this.x = x;
			this.y = y;
		}
	}
	
	public class Square{
		public Point p1, p2, p3;
		public Square(Point p1, Point p2, Point p3){
			this.p1 = p1;
			this.p2 = p2;
			this.p3 = p3;
		}
		
		public Point middlePoint(){
			return new Point((p1.x+p3.x)/2, (p1.y+p3.y)/2);
		}
		
		public Line cut(Square sq){		
			Point l1 = this.middlePoint();
			Point l2 = sq.middlePoint();
			if(l1 != l2){
				return new Line(l1, l2);
			}else{
				return new Line(l1, l2);
			}
		}
	}	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
