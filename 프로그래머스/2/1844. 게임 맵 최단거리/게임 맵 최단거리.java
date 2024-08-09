import java.util.*;

class Solution {
    
    static int[] dr = {0,0,1,-1};
    static int[] dc = {1,-1,0,0};
    static boolean[][] check;
    static int n,m;
    static int minVal = Integer.MAX_VALUE;
    
    public int solution(int[][] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length;
        check = new boolean[n][m];
        
        answer = bfs(maps, 0,0);
        
        if(answer == Integer.MAX_VALUE) answer=-1;
        
        return answer;
    }
    
    int bfs(int[][] arr, int r, int c){
        ArrayDeque<Position> queue = new ArrayDeque<>();
        queue.offer(new Position(r,c,0));
        check[r][c] = true;
        
        while(!queue.isEmpty()){
            Position position = queue.poll();
            r = position.r;
            c = position.c;
            int cnt = position.cnt;
            
            if(r==n-1&&c==m-1){
                if(minVal>cnt+1) {
                    minVal = cnt+1;   
                }
            }
            
            for(int d=0; d<4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                
                
            
                if(nr<0 || nc<0 || nr>=n || nc>=m || check[nr][nc] || arr[nr][nc]==0) continue;
                
                queue.offer(new Position(nr,nc,cnt+1));
                check[nr][nc] = true;
            
            }
        }
        return minVal;
    }
    
    class Position{
        int r;
        int c;
        int cnt;
        public Position(int r, int c, int cnt){
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
}







