package BOJ;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_1620_나는야포켓몬마스터이다솜_박시원 {

	static Map<Integer, String> hMap1 = new HashMap<>();
	static Map<String, Integer> hMap2 = new HashMap<>();
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for(int i = 1; i<=N; i++) {
			String name = br.readLine();
			hMap1.put(i, name);
			hMap2.put(name, i);
		}
		for(int i = 0; i<M; i++) {
			String str = br.readLine();
			if(str.charAt(0) >= 49 && str.charAt(0) <= 57) {
				System.out.println(hMap1.get(Integer.parseInt(str)));
			}else {
				System.out.println(hMap2.get(str));
			}
		}
	}
}
