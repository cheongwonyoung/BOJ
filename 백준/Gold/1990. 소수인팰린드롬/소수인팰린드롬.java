import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[] arr = new boolean[m + 1];
        arr[1] = true;
        for (int i = 2; i * i <= m; i++) {
        	if(arr[i]) continue;
            for (int j = i * i; j <= m; j += i) {
                arr[j] = true;
            }
        }
        for (int i = n; i <= m; i++) {
            if (arr[i] == false && isPallindrome(i) == true) {
//                System.out.println(i);
            	sb.append(i).append("\n");
            }
        }
        sb.append(-1);
        System.out.println(sb);
    }

    public static boolean isPallindrome(int num) {
        String s = Integer.toString(num);
        if (s.length() == 1) {
            return true;
        }
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}