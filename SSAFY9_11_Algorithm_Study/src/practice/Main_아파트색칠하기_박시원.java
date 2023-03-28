package practice;

public class Main_아파트색칠하기_박시원 {

	public static void main(String[] args) {
		int[][] f = new int[8][2]; //노랑, 파랑
		f[0][0] = 1;
		f[0][1] = 1;
		
		for(int i=1; i<8; i++) {
			f[i][0] = f[i-1][0]+f[i-1][1]; // 노랑
			f[i][1] = f[i-1][0]; //파랑
		}
		System.out.println(f[7][0]+f[7][1]);
	}
}
