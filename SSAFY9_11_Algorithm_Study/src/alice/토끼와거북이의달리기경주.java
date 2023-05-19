package alice;

import java.util.Scanner;

public class 토끼와거북이의달리기경주 {
	public static void main(String args[]) {
        int rabbit, turtle;
        Scanner scan = new Scanner(System.in);
        
        rabbit = scan.nextInt();
        turtle = scan.nextInt();
        
        /* 여기에 코드를 작성해 주세요 */
        int les = Math.min(rabbit, turtle);
        int a = les; // 최대 공약수
        int ans = 0; // 최소 공배수(정답)
        for(int i = 0; i<les; i++){
            if(rabbit%(a-i) == 0 && turtle%(a-i)==0){
                ans = rabbit*turtle/(a-i); 
                break;
            }
        }
        System.out.println(ans);
	}
}
