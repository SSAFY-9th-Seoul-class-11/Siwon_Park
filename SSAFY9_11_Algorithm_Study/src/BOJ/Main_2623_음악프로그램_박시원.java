package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2623_음악프로그램_박시원 {
	static int N; // 가수의 수
    static int M; // 보조 PD의 수
    static boolean[][] order; // 보조 PD가 정한 순서를 인덱스로 넣자 //인덱스->인덱스 간선이 있는지
    static int[] visited; // 나한테 오는 간선 수 

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken()); // 가수의 수
        M = Integer.parseInt(st.nextToken()); // 보조 PD의 수

        order = new boolean[N+1][N+1]; // 인덱스->인덱스 방향 간선이 있는지
        visited = new int[N+1]; // 인덱스 번호 가수에게 오는 간선 수

        for(int i=0;i<M;i++) {
        	st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()); // 보조 PD가 담당하는 가수의 수
            int a = Integer.parseInt(st.nextToken()); // 시작 정점

            for(int j=0;j<s-1;j++) {
                int b = Integer.parseInt(st.nextToken()); // 도착 정점
               
                if(!order[a][b]) { // 간선이 없을 때
                    order[a][b] = true; //간선 있다!
                    visited[b]++; // 간선수++
                }
                //끝점을 시작점으로 바꿔주기
                a = b;
            }
        }

        Queue<Integer> q = new LinkedList<Integer>();

        //나한테 오는 간선이 없으면 큐에 넣자!
        for(int i=1;i<=N;i++) {
            if(visited[i]==0) q.add(i);
        }

        //큐가 빌 때까지
        while(!q.isEmpty()) {
            int x = q.poll();
            sb.append(x + "\n"); // sb에 넣고
            // 보내는 간선이 있으면, 간선수-- 
            for(int i=1;i<=N;i++) {
                if(order[x][i]) {
                    visited[i]--;
                    if(visited[i]==0) { // 간선수가 더이상 없으면 큐에 넣자!
                        q.add(i);
                    }
                }
            }
        }

        boolean flag = true;
        //남아있는 간선이 있으면 0
        for(int i=1;i<=N;i++) {
            if(visited[i]!=0) {
                System.out.println(0);
                flag = false;
            }
        }

        if(flag) System.out.println(sb);
    }
}
