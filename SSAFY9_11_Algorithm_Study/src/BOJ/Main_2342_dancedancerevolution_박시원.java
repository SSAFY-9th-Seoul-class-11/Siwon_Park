package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2342_dancedancerevolution_박시원 {
	
	static class Pos { // 왼, 오른발 위치, 다음 가야할 위치
		int x, y, next;//, bx, by;
		public Pos(int x, int y, int next) {//, int bx, int by
			super();
			this.x = x;
			this.y = y;
			this.next = next;
//			this.bx = bx;
//			this.by = by;
		}
	}
	
	public static void main(String[] args) throws IOException {
		//중앙: 0, 위: 1, 왼: 2, 아래: 3, 오른: 4
		//차가 0일 때 : 1힘, 차가 1이고 전이 0일 때 :2힘, 차가 1이고 전 위치가 0이 아닐 때 3힘, 차가 2일 때 4힘
		//한번에 두 발을 전부 움직이진 못함, 한발씩만 움직이기 가능
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	}
	
	public static int pow(int l, int r) {
		if(l==0) return 1;
		else if(Math.abs(l-r) == 2 )return 4;
		else if(l==0)return 2;
		else return 3;
	}
}
