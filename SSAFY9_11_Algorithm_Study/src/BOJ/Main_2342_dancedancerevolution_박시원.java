package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2342_dancedancerevolution_박시원 {
	
	static class Pos { // 왼, 오른발 위치, n번째 순서
		int x, y, n;//, bx, by;
		public Pos(int x, int y, int n) {//, int bx, int by
			super();
			this.x = x;
			this.y = y;
			this.n = n;
//			this.bx = bx;
//			this.by = by;
		}
	}
	
	public static void main(String[] args) throws IOException {
		//중앙: 0, 위: 1, 왼: 2, 아래: 3, 오른: 4
		//차가 0일 때 : 1힘, 차가 1이고 전이 0일 때 :2힘, 차가 1이고 전 위치가 0이 아닐 때 3힘, 차가 2일 때 4힘
		//한번에 두 발을 전부 움직이진 못함, 한발씩만 움직이기 가능 하지만 어떤 발을 먼저 움직이던 상관 없다
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		List<Integer> order = new ArrayList<>();
		order.add(0);
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(true) {
			int num = Integer.parseInt(st.nextToken());
			if(num == 0) break;
			order.add(num);
		}
		int size = order.size();
		int[][][] pos = new int[size][5][5];
		
		for(int k = 0; k<size; k++) {
			for(int i = 0; i<5; i++) {
				for(int j = 0; j<5; j++) {
					pos[k][i][j] = 987654321;//Integer.MAX_VALUE;//힘의 최솟값을 최대로 초기화
				}
			}
		}
		pos[0][0][0] = 0;
		for(int k = 0; k<size-1; k++) {
			int next = order.get(k+1); // 다음 단계
			for(int i = 0; i<5; i++) {
				for(int j = 0; j<5; j++) {
					int now = pos[k][i][j];
					if(next != j) {
						pos[k+1][next][j] = Math.min(pos[k+1][next][j], now+pow(i, next));
					}
					if(next != i) {
						pos[k+1][i][next] = Math.min(pos[k+1][i][next], now+pow(j, next));
					}
				}
			}
		}
		
		int res = Integer.MAX_VALUE;
		for(int i = 0 ;i<5; i++) {
			for(int j = 0; j<5; j++) {
				res = Math.min(res,  pos[size-1][i][j]);
			}
		}
		System.out.println(res);
	}
	
	public static int pow(int l, int r) {
		if(l==0) return 1;
		else if(Math.abs(l-r) == 2 )return 4;
		else if(l==0)return 2;
		else return 3;
	}
}
