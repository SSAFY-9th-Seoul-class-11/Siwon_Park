package alice;

import java.util.Scanner;

public class 구름다리를건너는토끼 {
	static int crossBridge(int steps[]) {
        int cnt = 0;
        int current = 0;
        
        while (current<steps.length/* 이곳을 채워주세요! */) {
            current += steps[current]/* 이곳을 채워주세요! */;
            cnt += 1;
        }
        
        return cnt;
    }
    
	public static void main(String args[]) {
        int stepCount;
        int steps[];
        int i;
        Scanner scan = new Scanner(System.in);
    
        stepCount = scan.nextInt();
        steps = new int[stepCount];
    
        for(i = 0; i < stepCount; i++)
        {
            steps[i] = scan.nextInt();
        }
    
        System.out.println(crossBridge(steps));
	}
}
