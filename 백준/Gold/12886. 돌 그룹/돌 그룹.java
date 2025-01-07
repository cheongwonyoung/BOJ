import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());


        boolean result = bfs(A,B,C);

        System.out.print(result ? 1:0);
    }

    public static boolean bfs(int group1, int group2, int group3){

        // 세 그룹의 합이 3으로 나눠지지 않으면 0
        if((group1+group2+group3)%3!=0) return false;

        // BFS를 사용해 가능여부 파악
        ArrayDeque<Stone> queue = new ArrayDeque<>();
        // 세 그룹 합의 최대가 1500
        boolean[][] check = new boolean[1501][1501];

        queue.offer(new Stone(group1,group2,group3));
        check[group1][group2]=true;

        while(!queue.isEmpty()){
            Stone stone = queue.poll();
            group1 = stone.g1;
            group2 = stone.g2;
            group3 = stone.g3;

            if(group1==group2 && group2==group3) return true;

            if(group1!=group2){
                int n1 = group1<group2 ? group1*2:group1-group2;
                int n2 = group1>group2 ? group2*2:group2-group1;

                if(!check[n1][n2]) {
                    queue.offer(new Stone(n1, n2, group3));
                    check[n1][n2] = true;
                }
            }
            if(group1!=group3){
                int n1 = group1<group3 ? group1*2:group1-group3;
                int n3 = group1>group3 ? group3*2:group3-group1;

                if(!check[n1][n3]){
                    queue.offer(new Stone(n1,group2,n3));
                    check[n1][n3] = true;
                }
            }
            if(group2!=group3){
                int n2 = group2<group3 ? group2*2:group2-group3;
                int n3 = group2>group3 ? group3*2:group3-group2;

                if(!check[n2][n3]){
                    queue.offer(new Stone(group1,n2,n3));
                    check[n2][n3] = true;
                }

            }

        }

        return false;
    }

    public static class Stone{
        int g1;
        int g2;
        int g3;

        public Stone(int g1, int g2, int g3){
            this.g1 = g1;
            this.g2 = g2;
            this.g3 = g3;
        }
    }
}