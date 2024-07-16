import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int m = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
		}
		
		Arrays.sort(arr);
		// 1 2 3 4 5 7
		int left = 0;
		int right = arr.length-1;
		int count = 0;
		
		while(left<right) {
			if(arr[left]+arr[right] == m) {
				left++;
				right--;
				count++;
			}
			else if(arr[left]+arr[right]<m) {
				left++;
			}
			else if(arr[left]+arr[right]>m) {
				right--;
			}
		}
		System.out.println(count);
	}
}