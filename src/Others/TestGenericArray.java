package Others;

import java.lang.reflect.Array;

public class TestGenericArray <T> {
	
	public T[] arr;
	public TestGenericArray(Class<T> cls, int size){
		arr = createArray(cls, size);
	}
	
	@SuppressWarnings("unchecked")
	T[] createArray(Class<T> cls, int size){
		return (T[])Array.newInstance(cls, size);
	}
	
	public void print(){
		for(int i = 0; i < arr.length; ++i){
			System.out.println(arr[i]);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestGenericArray<Integer> arr = new TestGenericArray<>(Integer.class, 100);
		arr.print();
	}

}
