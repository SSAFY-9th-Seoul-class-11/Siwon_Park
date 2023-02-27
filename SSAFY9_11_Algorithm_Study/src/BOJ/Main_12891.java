package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12891 {
	static int S;//DNA문자열 길이
	static int P;//비밀번호로 사용할 부분문자열 길이
	static int[] DNA = new int[4];//ACGT 순으로 부분 문자열이 포함하는 문자의 수
	static int[] min = new int[4];//부분 문자열에 포함되어야 할 ACGT의 최소 개수
	static int con; //문자열 포함 숫자 충족 조건
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		//DNA문자열 char 배열로 입력받기
		char[] dna = new char[S]; 
		dna = br.readLine().toCharArray();
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		//최소 ACGT수
		for(int i = 0; i<4; i++) {
			min[i] = Integer.parseInt(st2.nextToken());
			if(min[i] == 0) con++;
		}
		//초기값 추가
		for(int i = 0; i<P; i++)
		{
			add(change(dna[i]));
		}
		
		int result = 0;
		if(con == 4) result++;
		
		for(int i = P; i<S; i++) {
			add(change(dna[i]));
			remove(change(dna[i-P]));
			if(con == 4) result++;
		}
		System.out.println(result);
	}

	//ACGT 0123으로 바꿔주기
	public static int change(char c) {
		int num = 0;
		switch (c) {
		case 'T': num++;
		case 'G': num++;
		case 'C': num++;
		case 'A': break;
		}
		return num;
	}
	//추가
	public static void add(int k) {//k는 ACGT순 인덱스
		DNA[k]++;
		if(DNA[k] == min[k]) con++; 
	}
	//제거
	public static void remove(int k) {//k는 ACGT순 인덱스
		if(DNA[k] == min[k]) con--; 
		DNA[k]--;
	}
}
