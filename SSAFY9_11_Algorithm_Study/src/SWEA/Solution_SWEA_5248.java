package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// User Problem 5248. [파이썬 S/W 문제해결 구현] 6일차 - 그룹 나누기
public class Solution_SWEA_5248 {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 출석번호
			int M = Integer.parseInt(st.nextToken()); // 신청서 수
			boolean[][] group = new boolean[N+1][N+1]; // (출석번호 1~N, 최대 조의 수)	
			int idx = 0; // group의 열변수(그룹 수!)
			
			st = new StringTokenizer(br.readLine());
			// M장의 신청서에서 각각 두 번호를 입력받아서 그룹을 확인하고 없다면 만들어줌
			for(int i = 0; i<M; i++) { 
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				boolean newGroup = true; // 둘 다 아무 조에 없을 경우 새로운 그룹을 만들라는 불린형 변수

				for(int j = 0; j<=idx; j++) {
					if(group[a][j] && group[b][j]) { // 두 번호 모두 해당 조에 있다면 종료
						newGroup = false; //새 그룹을 만들 필요 없음
						break;
					}else if(group[a][j] || group[b][j]){ //한 번호만 있다면 그 조에 다른 번호도 넣어줌
						group[a][j] = true;
						group[b][j] = true;
						newGroup = false; //새 그룹을 만들 필요 없음
						break;
					}					
				}
				//새 그룹을 만들어야 한다면
				if(newGroup) {
					idx++; //다음 열을 만들어주고
					group[a][idx] = true;
					group[b][idx] = true;
				}
			}
			
			//N까지의 출석번호 중 그룹에 없는 애들 혼자 새 그룹으로 만들어줌
			for(int i = 1; i<=N; i++) { //출석번호 1부터 시작
				boolean in = false; // 그룹에 속해있는지 확인하는 불린 변수
				for(int j =1; j<=idx; j++) { //0번 열에는 그룹이 안생김
					if(group[i][j]) { //해당 조에 속해있다면
						in = true; // 속해있다 체크
						break;
					}
				}
				if(!in) idx++; // i가 그룹에 속해있지 않다면 그룹 수를 늘려줌
			}
			System.out.println("#" + tc + " " + idx);
		}	
	}
}
