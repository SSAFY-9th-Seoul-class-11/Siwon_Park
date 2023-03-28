package practice;

public class Main_막대만들기_박시원 {

	public static void main(String[] args) {
		int[] stick = {1, 1, 2}; //파랑, 노랑, 빨강
		int[] f = new int[7];
		
		f[1] = 2;
		f[2] = 5;
		for(int i = 1; i<=6; i++) {
			for(int j = 0; j<3; j++) {
				if(i-stick[j]>0) {
					f[i] += f[i-1];
				}
			}
		}
		System.out.println(f[6]);
	}
}
