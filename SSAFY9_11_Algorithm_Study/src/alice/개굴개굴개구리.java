package alice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 개굴개굴개구리 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        ArrayList<String> arr = new ArrayList<>();
        while(st.hasMoreTokens()){
            // String str = st.nextToken();
            arr.add(st.nextToken());
        }
        int size = arr.size();
        for(int i = 0; i<size; i++){
            for(int j = 0; j<arr.get(i).length(); j++){
                sb.append("개굴");
            }
            sb.append(" ");
        }
        System.out.print(sb);
	}

}
