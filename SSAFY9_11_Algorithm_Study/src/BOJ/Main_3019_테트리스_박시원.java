package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3019_테트리스_박시원 {

	static int[] tetris;
	static int C, P, count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		C = Integer.parseInt(st.nextToken()); // C열
		P = Integer.parseInt(st.nextToken()); // 블록 번호

		int min = 100; // 테트리스 높이 최솟값
		tetris = new int[C];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			tetris[i] = Integer.parseInt(st.nextToken());
		}

		rotate(P);
		System.out.println(count);

	}

	public static void rotate(int num) { // num: 블록번호
		int block[];
		switch (num) {
		case 1:
			//0
			count += C; //한칸짜리라 열만큼 그냥 더해주면 됨
			//0000
			block = new int[4];
			drop(4, block);
			break;
		case 2:
			//00
			block = new int[2];
			drop(2, block);
			break;
		case 3:
			//001
			block = new int[3];
			block[2] = 1;
			drop(3, block);
			//10
			block = new int[2];
			block[0] = 1;
			drop(2, block);
			break;
		case 4:
			//100
			block = new int[3];
			block[0] = 1;
			drop(3, block);
			//01
			block = new int[2];
			block[1] = 1;
			drop(2, block);
			break;
		case 5:
			//000
			block = new int[3];
			drop(3, block);
			//01
			block = new int[2];
			block[1] = 1;
			drop(2, block);
			//101
			block = new int[3];
			block[0] = block[2] = 1;
			drop(3, block);
			//10
			block = new int[2];
			block[0] = 1;
			drop(2, block);
			break;
		case 6:
			//000
			block = new int[3];
			drop(3, block);
			//00
			block = new int[2];
			drop(2, block);
			//011
			block = new int[3];
			block[1] = block[2] = 1;
			drop(3, block);
			//20
			block = new int[2];
			block[0] = 2;
			drop(2, block);
			break;
		case 7:
			//000
			block = new int[3];
			drop(3, block);
			//00
			block = new int[2];
			drop(2, block);
			//110
			block = new int[3];
			block[0] = block[1] = 1;
			drop(3, block);
			//02
			block = new int[2];
			block[1] = 2;
			drop(2, block);
			break;
		}

	}
	public static void drop(int length, int[] gap) {
		int i = 0;
		while(i <= C-length) {
			int min = 100; // 테트리스 높이 최솟값
			int[] part = new int[length];
			for(int j = 0; j<length; j++) {
				part[j] = tetris[i+j];
				min = Math.min(min, part[j]);
			}
			//부분 배열 전체에서 최솟값 빼기
			for(int j = 0; j<length; j++) {
				part[j] -= min;
			}
			boolean flag = true;
			for(int j = 0; j<length; j++) {
				if(part[j] != gap[j]) flag = false;
			}
			if(flag) count++;
			
			i++;
		}
	}

}
