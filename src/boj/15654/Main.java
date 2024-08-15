import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int m;
	static int[] arr;
	static boolean[] visited;

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.valueOf(st.nextToken());
		}
		Arrays.sort(arr);

		visited = new boolean[n];
		solve(new int[m], 0);

		bw.close();
	}

	static void solve(int[] p, int depth) throws IOException {
		if (depth == m) {
			for (int i = 0; i < m; i++) {
				bw.write(p[i] + " ");
			}
			bw.write("\n");
			bw.flush();
			return;
		}



		for (int i = 0 ; i < n; i++) {
			if (visited[i]) continue;
			p[depth] = arr[i];
			visited[i] = true;
			solve(p, depth + 1);
			p[depth] = -1;
			visited[i]=false;
		}
	}
}