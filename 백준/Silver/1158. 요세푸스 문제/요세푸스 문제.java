import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// Deque로 해결
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		sb.append("<");
		
		ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
		for(int i=1; i<=n; i++) {
			queue.offer(i);
		}
		
		while(true) {
			for(int j=0; j<k-1; j++) {
				queue.offer(queue.poll());
			}
			if(queue.size()==1) {
				sb.append(queue.poll());
				break;
			}
			sb.append(queue.poll()).append(", ");
		}
		sb.append(">");
		System.out.println(sb);
		
		
	}
}