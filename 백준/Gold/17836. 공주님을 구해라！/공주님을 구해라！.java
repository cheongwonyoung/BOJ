import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int[][] castle;
    static boolean[][][] visited;
    static int n,m,t;

    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        castle = new int[n][m];
        visited = new boolean[n][m][2];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(in.readLine());
            for(int j=0; j<m; j++){
                castle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = bfs();
        if(result==0) System.out.println("Fail");
        else System.out.println(result);

    }
    public static int bfs(){
        ArrayDeque<Position> queue = new ArrayDeque<>();
        queue.offer(new Position(0,0, 0,false));
        visited[0][0][0]=true;
        while(!queue.isEmpty()){
            Position position = queue.poll();
            int row = position.r;
            int col = position.c;
            int time = position.time;
            boolean weapon = position.weapon;
            if(time>t) continue;
            if(row==n-1 && col==m-1) return time;


            for(int d=0; d<4; d++){
                int nr = row + dr[d];
                int nc = col + dc[d];
                int weaponState = weapon ? 1:0;
                if(nr<0 || nc<0 || nr>=n || nc>=m || visited[nr][nc][weaponState]) continue;
                if(castle[nr][nc]==1 && !weapon) continue;

                if(castle[nr][nc]==2){
                    visited[nr][nc][1] = true;
                    queue.offer(new Position(nr, nc, time+1, true));
                }
                else{
                    visited[nr][nc][weaponState] = true;
                    queue.offer(new Position(nr, nc, time+1, weapon));
                }

            }
        }
        return 0;
    }

    public static class Position{
        // row, col, weapon
        int r;
        int c;
        int time;
        boolean weapon;

        public Position(int r, int c, int time, boolean weapon){
            this.r = r;
            this.c = c;
            this.time = time;
            this.weapon = weapon;
        }
    }
}