import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[][] arr = new int[N][2];
		for(int i=0; i<N; i++) {
			String[] tem = in.readLine().split(" ");
			arr[i][0] = Integer.parseInt(tem[0]);
			arr[i][1] = Integer.parseInt(tem[1]);
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1]==o2[1]) {
					return o1[0]-o2[0];
				}
				return o1[1]-o2[1];
			}
		});
		
		int end_time = 0;
		int cnt = 0;
		
		for(int i=0; i<N; i++) {
			if(end_time <=arr[i][0]) {
				end_time = arr[i][1];
				cnt++;
			}
		}
		System.out.println(cnt);
		
		
		
		
		
		
		
		
	}
}