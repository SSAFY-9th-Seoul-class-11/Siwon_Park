package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.MathContext;
import java.util.StringTokenizer;

public class Main_14719_빗물_박시원 {
	static int H, W, rainwater;
	static int[] block;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		block = new int[W];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<W; i++) {
			block[i] = Integer.parseInt(st.nextToken());
		}
		measure();
		System.out.println(rainwater);
	}
	
	//해당 인덱스의 블록에서 왼쪽에서 가장 높은 블럭, 오른쪽에서 가장 높은 블록 중 작은 블록의 차가 그 인덱스의 빗물 양
	public static void measure() {
		for(int i = 1; i<W-1; i++) {
			int leftTop = 0;
			int rightTop = 0;
			//왼쪽 찾기
			for(int j = 0; j<i; j++) {
				leftTop = Math.max(leftTop, block[j]);
			}
			//오른쪽 찾기
			for(int j = i+1; j<W; j++) {
				rightTop = Math.max(rightTop, block[j]);	
			}
			//양쪽 모두 해당 인덱스의 블록보다 커야지만 해당 인덱스에 빗물이 고일 수 있다
			if(block[i]<leftTop && block[i]<rightTop) {
				rainwater += Math.min(leftTop, rightTop) - block[i];
			}
		}
	}
}
