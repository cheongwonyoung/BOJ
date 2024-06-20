import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		
		for(int t=0; t<T; t++) {
			int n = Integer.parseInt(in.readLine());
			int[] arr = new int[n];
			
			int level = 0;
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int i=0; i<n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arr);
			
			for(int j=n-1; j>=2; j--) {
				if(arr[j]-arr[j-1]>level) level=arr[j]-arr[j-1];
				if(arr[j]-arr[j-2]>level) level=arr[j]-arr[j-2];
		
			}
			
			sb.append(level).append("\n");
		}
		System.out.println(sb);
	}
}