package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1861 {
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
    static int[][] rooms;
    static int N;
 
    static int maxRoom;
    static int maxMove;
 
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
 
        int T = Integer.parseInt(in.readLine());
 
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(in.readLine());
            rooms = new int[N][N];
            maxRoom = 0; // 방 번호
            maxMove = 0; // 이동 횟수
 
            for (int i = 0; i < N; i++) {
            	StringTokenizer st = new StringTokenizer(in.readLine());
                for (int j = 0; j < N; j++) {
                    rooms[i][j] = Integer.parseInt(st.nextToken());
                }
            }
 
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dfs(i, j, 1);
                }
            }
            sb.append("#" + tc + " " + maxRoom + " " + maxMove + "\n");
        }
        System.out.print(sb);
    }
 
    private static int dfs(int x, int y, int cnt) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
 
            if (nx < 0 || nx >= N || ny < 0 || ny >= N || rooms[x][y] + 1 != rooms[nx][ny]) continue;
 
            cnt = dfs(nx, ny, cnt + 1);
 
            if (maxMove < cnt) {
                maxMove = cnt;
                maxRoom = rooms[x][y];
            } else if (maxMove == cnt && maxRoom > rooms[x][y]) {
                maxRoom = rooms[x][y];
            }
 
			break; // 방에 있는 번호는 서로 다름
        }
 
        return cnt;
 
    }
}
