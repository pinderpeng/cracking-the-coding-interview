package SystemDesignAndMemoryLimits;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class GeneralNotContainedInteger {

	//from the cracking the coding interview answers
	public static int generalNotContainedInteger() throws FileNotFoundException{
		byte []bitmap = new byte[0x20000000];
		Scanner in = new Scanner(new FileReader("input.txt"));
		while(in.hasNextInt()){
			int n = in.nextInt();
			bitmap[n/8] |= 1<<(n%8);
		}
		
		for(int i = 0; i < bitmap.length; ++i){
			for(int j = 0; j < 8; ++j){
				if(((bitmap[i]>>j)&1) == 0){
					return i*8+j;
				}
			}
		}
		return -1;
	}
	//from the cracking the coding interview answers
	public static int generalNotContainedInteger2() throws FileNotFoundException{
		byte[] bitmap = new byte[1<<20];
		int [] counter = new int[1<<12];
		Scanner in = new Scanner(new FileReader("input.txt"));
		while(in.hasNextInt()){
			int n = in.nextInt();
			counter[n / (1<<20)]++;
		}
		
		int target = 0;
		for(int i = 0; i < counter.length; ++i){
			if(counter[i] < (1<<20)){
				target = i;
				break;
			}
		}
		in.close();
		
		in = new Scanner(new FileReader("input.txt"));
		while(in.hasNextInt()){
			int n = in.nextInt();
			if(n >= target*(1<<20) && n < (target+1)*(1<<20)){
				bitmap[(n-target*(1<<20))/8] |= 1<<((n-target*(1<<20))%8);
			}
		}
		
		for(int i = 0; i < bitmap.length; ++i){
			for(int j = 0; j < 8; ++j){
				if(((bitmap[i]>>j)&1) == 0){
					return (target*(1<<20) + 8*i + j);
				}
			}
		}
		return -1;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(0x20000000/(1024*1024));
	}

}
