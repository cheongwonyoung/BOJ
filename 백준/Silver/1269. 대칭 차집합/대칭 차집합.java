import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// A와 B의 합집합에서 공집합을 제거
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		int lenA = Integer.parseInt(st.nextToken());
		int lenB = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<lenA; i++) {
			int num = Integer.parseInt(st.nextToken());
			map.put(num, map.getOrDefault(num, 0)+1);
		}
		
		st = new StringTokenizer(in.readLine());
		for(int j=0; j<lenB; j++) {
			int num = Integer.parseInt(st.nextToken());
			map.put(num, map.getOrDefault(num, 0)+1);			
		}
		int result = 0;
		for(int i=1; i<100000001; i++) {
			int cnt = map.getOrDefault(i, 0);
			if(cnt==1) result++;
		}
		System.out.println(result);
		
		 
	}
}