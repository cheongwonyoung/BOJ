import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new java.io.InputStreamReader(System.in));
		// 버블 정렬 ?
		
		int n = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
//		int[] arr = new int[n];
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<n; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		int s = Integer.parseInt(in.readLine());
		
		// s번 이동 안에서 
		// 제일 큰 값 찾기
		// 걔를 최대한 앞으로 가져오기
		// 그 다음 인덱스부터 위에 과정 다시
		for(int i=0; i<n&&s>0; i++) {
			int maxVal = list.get(i);
			int maxIdx = -1;			
			for(int j=i+1; j<n&&j-i<=s; j++) {
				if(maxVal<list.get(j)) {
					maxIdx=j;
					maxVal=list.get(j);
				}
			}
			if(maxIdx==-1) continue;
			list.remove(maxIdx);
			list.add(i, maxVal);
			s-=(maxIdx-i);
		}
		
		for(int i=0; i<n; i++) {
			System.out.print(list.get(i)+" ");
		}
	}
}