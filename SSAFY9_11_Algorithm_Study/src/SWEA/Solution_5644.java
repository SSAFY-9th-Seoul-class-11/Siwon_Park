package SWEA;

import java.beans.beancontext.BeanContextMembershipListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5644 {

	static int[][] map = new int[10][10];
	static int[] vA, vB;// 사용자 A, B 이동 방향
	static int M;//총 이동 시간
	static int A;//BC의 개수
	static int[] xBC; // BC x좌표
	static int[] yBC; // BC y좌표
	static int[] cBC; // BC 충전 범위
	static int[] pBC; // BC 처리량
	//이동 x, 상, 우, 하,좌
	static int[] dx = {0, 0, 1, 0, -1};
	static int[] dy = {0, -1, 0, 1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // 총 이동 시간
			A = Integer.parseInt(st.nextToken()); // BC의 개수 A
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<M; i++) {
				vA[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<M; i++) {
				vB[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 0; i<A; i++) {
				st = new StringTokenizer(br.readLine());
				xBC[i] = Integer.parseInt(st.nextToken());
				yBC[i] = Integer.parseInt(st.nextToken());
				cBC[i] = Integer.parseInt(st.nextToken());
				pBC[i] = Integer.parseInt(st.nextToken());
			}
			
		}

	}
//	static int move() {
//		int totalsum = 0;
//		for(int i = 0; i<=M; i++) {
//			totalsum += getCharge();
//		}
//		return totalsum;
//	}
//	static int getCharge() {
//		int max = 0;
//		for(int a = 0; a<vA[a]; a++) {
//			for(int b = 0; b<bcCount; b++) {
//				int aSum = check(xBC[a], R
//			}
//		}
//		return max;
//	}
//	static int check(BC b, int r, int c) {
//		return Math.abs(b.r-r)+Math.abs(c)
//	}
	public static void coverage() {
		
	}

}
