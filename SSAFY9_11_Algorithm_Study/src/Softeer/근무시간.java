package Softeer;
import java.util.*;
import java.io.*;

public class 근무시간 {
	static int[] Hs, He, Ms, Me;

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Hs = new int[5];
        He = new int[5];
        Ms = new int[5];
        Me = new int[5];
        
        int total = 0;

        for(int i = 0; i<5; i++){
            st = new StringTokenizer(br.readLine(), " :");
            Hs[i] = Integer.parseInt(st.nextToken());
            Ms[i] = Integer.parseInt(st.nextToken());
            He[i] = Integer.parseInt(st.nextToken());
            Me[i] = Integer.parseInt(st.nextToken());

            if(Ms[i]>Me[i]) {
            	total += (He[i]-Hs[i]-1)*60;
            	total += 60+(Me[i]-Ms[i]);
            }else {
            	total += (He[i]-Hs[i])*60;
            	total += Me[i]-Ms[i];
            }
           
        }
        System.out.println(total);
    }
}
