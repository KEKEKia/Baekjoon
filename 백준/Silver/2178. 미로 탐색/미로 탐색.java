import java.util.*;
import java.io.*;
public class Main {
	static int[][] arr;
	static boolean[][] visited;
	static int ans, N, M;
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};
	
        public static void main(String[] args) throws IOException{
        	 BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
             String str = bf.readLine();

             StringTokenizer st = new StringTokenizer(str);

             N = Integer.valueOf(st.nextToken());
             M = Integer.valueOf(st.nextToken());
             arr = new int[N][M];
             visited = new boolean[N][M];
             ans = 0;
             for(int i=0; i<N; i++) {
                 str = bf.readLine();

                 for(int j=0; j<M; j++) {
                     arr[i][j] = str.charAt(j)-48; // -'0'
                 }
             }

             bfs();
             System.out.println(ans);
		}

        
        static void bfs() {
        	Queue<Integer[]> queue = new LinkedList<>();
        	queue.add(new Integer[] {0,0,0});
        	visited[0][0]=true;
        	
        	while(!queue.isEmpty()) {
        		Integer[] arrTmp = queue.poll();
        		int r = arrTmp[0];
        		int c = arrTmp[1];
        		int depth = arrTmp[2];
        		
        		for(int i = 0 ; i < 4; i++) {
        			int nr = r + dr[i];
        			int nc = c + dc[i];
        			
        			if(nr>=0&&nc>=0&&nr<N&&nc<M&&!visited[nr][nc]&&arr[nr][nc]==1) {
        				if(nr==N-1&&nc==M-1) {
        					ans = depth+2;
        					return;
        				}
        				
        				queue.add(new Integer[] {nr, nc, depth+1});
        				visited[nr][nc]=true;
        			}
        			
        			
        		}
        		
        	}
        	
        	
        	
        	
        }
        
}