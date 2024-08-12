import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int n;
	static int m;
	static int[] arr;
	static boolean visited[] = new boolean[8];

	public static void main(String[] args) throws IOException{
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.sorted()
			.toArray();

		solve(new int[m], 0, 0);
		bw.flush();
	}

	static void solve(int[] p, int st, int depth) throws IOException {
		if (depth == m) {
			printArr(p);
			return;
		}

		for (int i = st; i < n; i++) {
			p[depth] = arr[i];
			visited[i] = true;
			solve(p, i, depth + 1);
			visited[i] = false;
			p[depth] = -1;
		}
	}

	static void printArr(int[] arr) throws IOException {
		for (int i = 0; i < arr.length; i++) {
			bw.write(arr[i] + " ");
		}
		bw.write("\n");
	}
}