package practice;

public class Main_막대만들기_박시원 {

	public static void main(String[] args) {
		int[] f = new int[7];
		
		f[1] = 2;
		f[2] = 5;
		for(int i = 3; i<=6; i++) {
			f[i] = f[i-1]*2 + f[i-2];
		}
		System.out.println(f[6]);
	}
}
