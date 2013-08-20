package Others;

public class B extends A{
	private B(){super(0);}
	
	public static B create(){
		return new B();
	}
}
