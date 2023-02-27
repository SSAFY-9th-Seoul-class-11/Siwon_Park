package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1244 {
	static int N;
	static int[] onoff;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());// 스위치 개수

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		onoff = new int[N + 1]; // 스위치 상태 넣을 배열
		// 스위치 on off 입력 //켜져있으면 1, 꺼져있으면 0; //스위치 번호가 1부터 시작하므로..
		for (int i = 1; i <= N; i++) {
			onoff[i] = Integer.parseInt(st.nextToken());
		}

		int sNum = Integer.parseInt(br.readLine());// 학생 수

		// 학생의 성별과 학생이 받은 수 입력
		for (int i = 0; i < sNum; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			int gender = Integer.parseInt(st2.nextToken());// i+1번째 학생 성별
			int number = Integer.parseInt(st2.nextToken());// i+1번째 학생이 받은 수

			if (gender == 1) {// 남자일 때
				for (int j = 1; j <= N; j++) {
					if (number * j > N)
						break;
					changeOnOff(number * j);
				}

			} else if (gender == 2) {// 여자일 때
				changeOnOff(number);
				ifGirl(number, 1);
			}
		}
		// 바꾼 스위치 출력
		for (int i = 1; i <= N; i++) {
			System.out.print(onoff[i] + " ");
			if (i % 20 == 0)
				System.out.println();
		}
	}

	// 스위치 바꾸기
	public static void changeOnOff(int num) {
		if (onoff[num] == 0)
			onoff[num] = 1;
		else
			onoff[num] = 0;
	}

	// 여학생일 때 스위치 바꾸기
	public static void ifGirl(int num, int k) {
		if (num - k < 1 || num + k > N)
			return; // 범위 넘어가면 바꾸기 끝!

		if (onoff[num - k] != onoff[num + k])
			return; // 다르면 바꾸기 끝!

		changeOnOff(num - k);
		changeOnOff(num + k);

		ifGirl(num, k + 1);
	}
}
