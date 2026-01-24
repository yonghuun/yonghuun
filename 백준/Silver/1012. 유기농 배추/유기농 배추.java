import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] matrix;
    static int m, n, k;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {

            String[] s = br.readLine().split(" ");
            m = Integer.parseInt(s[0]);
            n = Integer.parseInt(s[1]);
            k = Integer.parseInt(s[2]);

            matrix = new int[n][m];

            for (int i = 0; i < k; i++) {
                s = br.readLine().split(" ");
                int r = Integer.parseInt(s[0]);
                int c = Integer.parseInt(s[1]);
                matrix[c][r]++;
            }

            int count = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (matrix[i][j] == 0) {
                        continue;
                    } else {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);

        }
    }

    static void dfs(int x, int y) {

        matrix[x][y] = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (matrix[nx][ny] == 1) {
                    dfs(nx, ny);
                }
            }
        }


    }

}