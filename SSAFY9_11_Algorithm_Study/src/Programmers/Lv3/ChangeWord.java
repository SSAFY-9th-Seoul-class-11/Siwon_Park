package Programmers.Lv3;

public class ChangeWord {
	static int answer;
	static boolean[] visited;
	
	public int solution(String begin, String target, String[] words) {
        answer = 0;
        visited = new boolean[words.length];
        DFS(begin, target, words, 0);
        return answer;
    } 

	public static void DFS(String begin, String target, String[] words, int count) {
		if(begin.equals(target)) {
			answer = count;
			return;
		}
		
		for(int i = 0; i<words.length; i++) {
			if(visited[i] == true) continue;
			
			int cnt = 0;
			for(int j = 0; j<begin.length(); j++) {
				if(begin.charAt(j) == words[i].charAt(j)) {
					cnt++;
				}
			}
			
			if(cnt == begin.length() -1) {
				visited[i] = true;
				DFS(words[i], target, words, count+1);
				visited[i] = false;
			}
		}

	}

}
