package Programmers.Lv1;

public class Solution_비밀지도 {
	public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String str1 = "", str2 = "", sum = "";
        for(int i = 0; i<n; i++){
            str1 = Integer.toBinaryString(arr1[i]);
            str2 = Integer.toBinaryString(arr2[i]);
            sum = "";
            System.out.println(str1 + " " + str2);
            for(int j = 0; j<n; j++){
                if(str1.length()<n) str1 = "0"+str1;
                if(str2.length()<n) str2 = "0"+str2;
            }
            System.out.println(str1 + " " + str2);
            for(int j = 0; j<n; j++){
                if(str1.substring(j, j+1).equals("1")||str2.substring(j, j+1).equals("1")){
                    sum+="#";
                }else{
                    sum+=" ";
                }
                answer[i] = sum;
            }
            System.out.println();
        }
        return answer;
	}
}
