package BitManipulation;

public class PrintBinaryRepresentation {

	//Attention: double has binary format
	public static void printBinaryRepresentation(String str){
		if(str.contains(".") || str.contains("e")){
			System.out.println("ERROR");
			return;
		}
		
		double d = Double.parseDouble(str);
		if(d > Integer.MAX_VALUE || d < Integer.MIN_VALUE){
			System.out.println("ERROR");
			return;
		}
		
		int value = (int)d;
		for(int i = 0; i < 32; ++i){
			System.out.print((int)(value>>(31-i))&1);
		}
		System.out.println();
	}
	
	public static String printInt(int intPart){
		String ans = "";
		while(intPart != 0){
			int last = intPart%2;
			intPart /= 2;
			ans = last + ans;
		}
		return ans;
	}
	
	public static String printDec(double decPart){
		String ans = "";
		while(decPart > 0){
			decPart *= 2;
			if(decPart >= 1){
				ans += 1;
				decPart -= 1;
			}else{
				ans += 0;
			}
		}
		return ans;
	}
	
	public static String printBinaryRepresentation2(String str){
		if(!str.contains(".")){
			int intPart = Integer.parseInt(str);
			return printInt(intPart);
		}
		Double d = Double.parseDouble(str);
		if(d > Integer.MAX_VALUE || d < Integer.MIN_VALUE){
			return "ERROR";
		}
		int intPart = Integer.parseInt(str.substring(0, str.indexOf('.')));
		double decPart = Double.parseDouble(str.substring(str.indexOf('.'), str.length()));
		return printInt(intPart) + "." + printDec(decPart);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		printBinaryRepresentation("32");
		System.out.println(printBinaryRepresentation2("32.125"));
	}

}
