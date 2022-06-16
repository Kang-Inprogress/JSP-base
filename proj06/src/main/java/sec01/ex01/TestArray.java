package sec01.ex01;

public class TestArray {
	public static void main(String[] args) {
//		String[] ary = {"12", "34", "56", "78", "90"};
		/* 또는
		 * String[] names;  //먼저 초기화 해두고 나중에 값을 부여가능
		 * names = new String[] {values};
		 * 
		 * 2차원은 
		 * int[][] ary = new int[][] {}; 이런식.
		 * */
//		for(String item: ary) {
//			System.out.println("item: " + item);
//		}
		
		int[][] ary1 = {
			{100, 200, 300},
			{400, 500, 600},
			{700, 800, 900}
		};
//		for(int i=0; i<ary1.length; i++) {
//			for(int j=0; j<ary1[i].length; j++) {
//				System.out.println("item: " + ary1[i][j]);
//			}
//		}
		for(int[] ary0 : ary1) {
			for(int item: ary0) {
				System.out.println("item1: " + item);
			}
		}
		calc(10, 20);
	}
	
	private static void calc(int a, int b) {
		int result = a+b;
		System.out.println("함수테스트 result=" + result);
	}
}
