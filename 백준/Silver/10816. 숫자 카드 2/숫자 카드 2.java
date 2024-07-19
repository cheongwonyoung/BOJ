import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		Map<Integer, Integer> card = new HashMap<Integer, Integer>();
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken()); 
			if(card.containsKey(num)) {
				card.put(num, card.get(num)+1);
			}
			else {				
				card.put(num, 1);
			}
		}
		
		int M = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<M; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			sb.append(card.getOrDefault(num,0)).append(" ");
			
		}
		
		System.out.println(sb);
		
		
		
		
	}
}