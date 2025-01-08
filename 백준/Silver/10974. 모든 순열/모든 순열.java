import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] result;
	static boolean[] visit;
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		result = new int[N];
		visit = new boolean[N];
		
		perm(0);
		
		
	}
	
	public static void perm(int num) {
		if(num==N) {
			for(int i=0; i<num; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0;i<N; i++) {
			if(visit[i]) continue;
			visit[i] = true;
			result[num] = i+1;
			perm(num+1);
			visit[i] = false;
		}
		
	}
}