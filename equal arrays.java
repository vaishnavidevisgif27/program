import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            long[] a = new long[n];
            long[] b = new long[m];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                b[i] = Long.parseLong(st.nextToken());
            }

            
            long[] prefixA = new long[n];
            long[] prefixB = new long[m];

            prefixA[0] = a[0];
            for (int i = 1; i < n; i++) {
                prefixA[i] = prefixA[i - 1] + a[i];
            }

            prefixB[0] = b[0];
            for (int i = 1; i < m; i++) {
                prefixB[i] = prefixB[i - 1] + b[i];
            }

           
            if (prefixA[n - 1] != prefixB[m - 1]) {
                System.out.println(-1);
                continue;
            }

            
            int i = 0, j = 0;
            int length = 0;

            while (i < n && j < m) {
                if (prefixA[i] == prefixB[j]) {
                    length++;
                    i++;
                    j++;
                } else if (prefixA[i] < prefixB[j]) {
                    i++;
                } else {
                    j++;
                }
            }

            System.out.println(length);
        }
    }
}