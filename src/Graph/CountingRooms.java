package Graph;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class CountingRooms {
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st==null || !st.hasMoreTokens()){
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
        long nextLong(){
            return Long.parseLong(next());
        }
        double nextDouble(){
            return Double.parseDouble(next());
        }

        String nextLine(){
            String str="";
            try {
                str=br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    static class FastWriter {
        private final BufferedWriter bw;

        public FastWriter() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void print(Object object) throws IOException {
            bw.append("" + object);
        }

        public void println(Object object) throws IOException {
            print(object);
            bw.append("\n");
        }

        public void close() throws IOException {
            bw.close();
        }
    }

    public static void main(String[] args) {
        try {
            FastReader in = new FastReader();
            FastWriter out = new FastWriter();
            //

            int n = in.nextInt();
            int m = in.nextInt();

            char[][]map = new char[n][m];

            for(int i=0; i<n; i++){
                String line = in.next();
                for(int j=0; j<m; j++){
                    map[i][j] = line.charAt(j);
                }
            }


            int ans = 0;
            for(int i=0; i<n; i++){
                for(int j =0; j<m; j++){
                    if(map[i][j] == '.'){
                        ans++;
                        fun(map, i, j);
                    }
                }
            }

            System.out.println(ans);


            out.close();
        } catch (Exception e) {
            return;
        }
    }

    public static void fun(char[][] matrix , int r, int c){
        int n = matrix.length;
        int m = matrix[0].length;

        Queue<int[]> qu = new LinkedList<>();
        qu.offer(new int[]{r,c});
        matrix[r][c] = '#';

        int[][]directions = {{-1,0},{0,1}, {1,0}, {0,-1}};

        while(!qu.isEmpty()){
            int[]tuple = qu.poll();
            int row = tuple[0];
            int col = tuple[1];

            for(int[] dx : directions){
                int nr = row+dx[0];
                int nc = col+dx[1];

                if(nr <0 || nr >= n || nc <0 || nc >= m) continue;
                if(matrix[nr][nc] == '.'){
                    matrix[nr][nc] = '#';
                    qu.offer(new int[]{nr, nc});
                }
            }
        }
    }
}
