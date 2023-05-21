package alice;

import java.util.Scanner;

public class 엘리스와별헤는밤 {

	public static void main(String args[]) {
        int starDistance;
        Scanner scan = new Scanner(System.in);
        
        starDistance = scan.nextInt();
        
        /* 여기에 코드를 작성해 주세요 */
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i<3; i++){
            sb.append("*");
            for(int j = 0; j<starDistance; j++){
                sb.append(" ");
            }
        }
        sb.append("\n");
        
        for(int i = 0; i<starDistance/2+1; i++){
            sb.append(" ");
        }
        sb.append("*");
        if(starDistance%2==0){
            starDistance--;
        }
        for(int i = 0; i<starDistance; i++){
                sb.append(" ");
        }
        sb.append("*");
        System.out.println(sb);

	}
}
