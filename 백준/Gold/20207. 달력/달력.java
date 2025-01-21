import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[] calendar = new int[367];
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[i][0] = s;
            arr[i][1] = e;
            for (int j = s; j <= e; j++) {
                calendar[j]++;
            }
        }

        int result = 0, width = 0, height = 0;
        for (int i = 1; i <= 366; i++) {
            if (calendar[i] > 0) {
                width++;
                height = Math.max(height, calendar[i]);
            } else if (width > 0) {
                result += width * height;
                width = 0;
                height = 0;
            }
        }

        System.out.println(result);
    }
}