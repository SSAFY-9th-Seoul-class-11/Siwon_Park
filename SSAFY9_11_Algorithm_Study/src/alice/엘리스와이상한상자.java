package alice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class maxMachine {
    ArrayList<Integer> arr;
    public maxMachine() {
        /* 여기에 코드를 작성해 주세요 */

        arr = new ArrayList<>();
    }
    
    public void addNumber(int n) {
        /* 여기에 코드를 작성해 주세요 */
        arr.add(n);
    }
    
    public void removeNumber(int n) {
        /* 여기에 코드를 작성해 주세요 */
    	
        for(int i = 0; i<arr.size(); i++){
            if(arr.get(i) == n) arr.remove(i);
        }
    }
    
    public int getMax() {
        /* 여기에 코드를 작성해 주세요 */
    	
        int a = 0;
        for(int i = 0; i<arr.size(); i++){
            a = Math.max(a, arr.get(i));
        }
        return a;
    }
}


public class 엘리스와이상한상자 {
	public static void main(String args[]) {
        int n, i;
        Scanner scan = new Scanner(System.in);
        maxMachine machine = new maxMachine();
    
        n = scan.nextInt();
    
        for(i = 0; i < n; i++)
        {
            int t;
            t = scan.nextInt();
            switch(t)
            {
            case 0: machine.addNumber(scan.nextInt()); break;
            case 1: machine.removeNumber(scan.nextInt()); break;
            case 2: System.out.println(machine.getMax()); break;
            }
        }
	}
}
