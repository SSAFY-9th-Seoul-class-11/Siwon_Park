package Programmers.Lv3;

public class Network {

	public int solution(int n, int[][] computers) {
		int answer = 0;
		boolean[] visited = new boolean[n];

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				dfs(computers, i, visited);
				answer++;
			}
		}

		return answer;
	}

	boolean[] dfs(int[][] computers, int i, boolean[] visited) {
		visited[i] = true;

		for (int j = 0; j < computers.length; j++) {
			if (i != j && computers[i][j] == 1 && visited[j] == false) {
				visited = dfs(computers, j, visited);
			}
		}
		return visited;
	}

}
