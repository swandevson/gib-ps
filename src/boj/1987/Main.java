import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int r;
	static int c;
	static char[][] matrix;
	static boolean[] visited = new boolean['Z'-'A'+1];
	static int ans = 1;

	static int[] dRow = {0, 1, -1, 0};
	static int[] dCol = {1, 0, 0, -1};

	public static void main(String args[]) throws IOException{
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		matrix = new char[r][c];
		for (int i = 0; i < r; i++) {
			matrix[i] = br.readLine().toCharArray();
		}

		solve(0, 0, 0);


		System.out.println(ans);
	}

	static void solve(int row, int col, int cnt) {
		char ch = matrix[row][col];
		if (visited[ch-'A']) {
			ans = Math.max(ans, cnt);
			return;
		}

		visited[ch-'A'] = true;
		for (int i = 0; i < 4; i++) {
			int nRow = row + dRow[i];
			int nCol = col + dCol[i];


			if (nRow < 0 || nRow >= r || nCol < 0 || nCol >= c) {
				continue;
			}

			solve(nRow, nCol, cnt+1);
		}
		visited[ch-'A'] = false;

	}
}