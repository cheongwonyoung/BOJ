import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		
//		 총인구의 절반보다 크거나 같아지면 그곳이 목표지점
		long[][] town = new long[n][2];
		
		long total = 0;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			long x = Integer.parseInt(st.nextToken());
			long a = Integer.parseInt(st.nextToken());
			
			town[i][0] = x;
			town[i][1] = a;
			
			total+=a;
		}
		
		Arrays.sort(town, (a,b)->{
			return (int) (a[0]-b[0]);
		});

		long sum=0;
		for(int j=0; j<n; j++) {
			sum += town[j][1];
			if(sum>= (total+1)/2) {
				System.out.println(town[j][0]);
				break;
			}
		}
	}
}