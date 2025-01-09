import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());

        // N : 학생 수
        // K : 졸고 있는 학생 수
        // Q : 출석 코드를 처음 받는 학생 수
        // M : 주어질 구간의 수
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] student = new int[N+3];

        st = new StringTokenizer(in.readLine());
        for(int i=0; i<K; i++){
            int codeNum = Integer.parseInt(st.nextToken());
            student[codeNum]=-1;
        }

        st = new StringTokenizer(in.readLine());
        for(int i=0; i<Q; i++){
            int code = Integer.parseInt(st.nextToken());
            if(student[code]==-1) continue;
            for(int j=code; j<N+3; j+=code){
                // 자는 학생이면
                if(student[j]==-1) continue;

                student[j]=1;
            }
        }

        int[] rangeSum = new int[N+3];
        for(int i=3; i<N+3; i++){
            rangeSum[i] = rangeSum[i-1];
            if(student[i]!=1) rangeSum[i]++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(in.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            sb.append(rangeSum[E] - rangeSum[S-1]).append("\n");
        }

        System.out.println(sb);

    }
}