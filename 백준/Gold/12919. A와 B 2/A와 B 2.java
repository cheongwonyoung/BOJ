import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	static List<String> listS;
	public static void main(String[] args) throws IOException {
		// dfs
//		반대로 생각해서 T->S를 만들 수 있는지 확인해보자
//		1) 문자열 맨 뒤 A를 지운다
//		2) 2번째 조건을 두개로 나눠서 생각 // 뒤집었는데 맨 뒤가 B가 아니면 return
//		- 뒤집는다
//		- 맨 뒤의 B를 제거
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] S = in.readLine().split("");
		String[] T = in.readLine().split("");
		// 
		listS = new ArrayList<>();
		List<String> listT = new ArrayList<>();
		
		for(int i=0; i<S.length; i++) {
			listS.add(S[i]);
		}
		
		for(int i=0; i<T.length; i++) {
			listT.add(T[i]);
		}

		boolean result = check(listT);
		
		if(result) {
			System.out.println(1);
		}
		else {
			System.out.println(0);
		}

	}
	private static boolean check(List<String> listT) {
		// 둘이 길이가 같을 때 비교
		// 같으면 true
		// 다른 false
		if(listT.size()==listS.size()) {
			boolean flag=true;
			for(int i=0; i<listT.size(); i++) {
				if(!listT.get(i).equals(listS.get(i))) {
					flag=false;
					break;
				}
			}
			return flag;
		}
		// 맨 뒤가 A이면 A를 지우고 재귀
		if(listT.get(listT.size()-1).equals("A")){
			List<String> tempList = new ArrayList<>(listT);
			tempList.remove(listT.size()-1);
			if(check(tempList))return true;
		}
		// 맨 앞이 B이면 B를 지우고 reverse해서 재귀
		if(listT.get(0).equals("B")) {
			List<String> tempList = new ArrayList<>(listT);
			tempList.remove(0);
			Collections.reverse(tempList);
			if(check(tempList))return true;
		}
		return false;
	}
}