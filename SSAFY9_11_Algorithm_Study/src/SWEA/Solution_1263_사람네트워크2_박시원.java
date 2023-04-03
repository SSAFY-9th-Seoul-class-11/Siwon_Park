package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1263_사람네트워크2_박시원 {
	static int[][] distance;
	static int INF = Integer.MAX_VALUE;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //사람 수
			distance = new int[N][N]; //인접 행렬
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					distance[i][j] = Integer.parseInt(st.nextToken());
					if(i != j && distance[i][j]==0) {//자기자신으로의 인접 정보가 아니고 인접해있지 않다면 INF로 채우기
						distance[i][j]=INF;
					}
				}
			}
			//경출도 순으로!
			for(int k=0; k<N; ++k) {
				for(int i=0; i<N; ++i) {
					if(i==k) continue;
					for(int j=0; j<N; ++j) {
						if(distance[i][k] != INF && distance[k][j] != INF && distance[i][j] > distance[i][k]+distance[k][j]) {
							distance[i][j] = distance[i][k]+distance[k][j];
						}
					}
				}
			}
			System.out.println("#" + tc + " " + findMin());
		}
	}
	// cc가 가장 작은 노드 찾기 다른 사용자들로부터 가장 가까운 사용자!
	public static int findMin() {
		int[] sum = new int[N];
		int min = INF;
		for(int i = 0 ; i<N; i++) {
			for(int j = 0; j<N; j++) {
				sum[i] += distance[i][j];
			}
			min = Math.min(min, sum[i]);
		}
		return min;
	}
}
