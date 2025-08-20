package SortingAndSearching;
import java.io.*;
import java.util.*;

public class Apartments {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
        String nextLine() {
            try { return br.readLine(); }
            catch (IOException e) { e.printStackTrace(); return null; }
        }
    }

    static class FastWriter {
        private final BufferedWriter bw;
        public FastWriter() { bw = new BufferedWriter(new OutputStreamWriter(System.out)); }
        public void print(Object o) throws IOException { bw.append("" + o); }
        public void println(Object o) throws IOException { print(o); bw.append("\n"); }
        public void flush() throws IOException { bw.flush(); }
    }

    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader();
        FastWriter out = new FastWriter();

        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();

        int[] applicants = new int[n];
        int[] apartments = new int[m];

        for (int i = 0; i < n; i++) applicants[i] = in.nextInt();
        for (int i = 0; i < m; i++) apartments[i] = in.nextInt();

        Arrays.sort(applicants);
        Arrays.sort(apartments);

        int i = 0, j = 0, matches = 0;
        while (i < n && j < m) {
            if (apartments[j] < applicants[i] - k) {
                j++;
            } else if (apartments[j] > applicants[i] + k) {
                i++;
            } else {
                matches++;
                i++;
                j++;
            }
        }

        out.println(matches);
        out.flush();
    }
}
