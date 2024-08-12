
import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int n;
	static int[] arr;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			if (n == 0) break;

			arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			visited = new boolean[n];

			solve(new int[6], 0, 0);
			bw.write("\n");
		}

		bw.close();
	}

	static void solve(int[] p, int st, int depth) throws IOException {
		if (depth == 6) {
			for (int i = 0; i < 6; i++) {
				bw.write(p[i] + " ");
			}
			bw.write("\n");

			return;
		}

		for (int i = st; i < n; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			p[depth] = arr[i];
			solve(p, i+1, depth + 1);
			visited[i] = false;
			p[depth] = -1;
		}
	}
}