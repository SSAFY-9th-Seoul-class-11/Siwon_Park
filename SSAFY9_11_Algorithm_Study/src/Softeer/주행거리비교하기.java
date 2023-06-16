package Softeer;
import java.util.*;
import java.io.*;

public class 주행거리비교하기 {
	public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if(a>b){
            sb.append("A");
        }else if(b>a){
            sb.append("B");
        }else{
            sb.append("same");
        }

        System.out.println(sb);
    }
}
