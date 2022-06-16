package sec01.ex01;

public class TestArray {
	public static void main(String[] args) {
		String[] ary = {"12", "34", "56", "78", "90"};
		/* 또는
		 * String[] names;  //먼저 초기화 해두고 나중에 값을 부여가능
		 * names = new String[] {values};
		 * 
		 * 2차원은 
		 * int[][] ary = new int[][] {}; 이런식.
		 * */
		for(String item: ary) {
			System.out.println("item: " + item);
		}
		
		int[][] ary1 = {
			{100, 200, 300},
			{400, 500, 600}
		};
		for(int i=0; i<ary1.length; i++) {
			for(int j=0; j<ary1[i].length; j++) {
				System.out.println("item: " + ary1[i][j]);
			}
		}
	}
}
