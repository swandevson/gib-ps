import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String args[]) throws IOException {
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();

		while(true) {
			int p = Integer.parseInt(br.readLine());
			if (p == -1) {
				break;
			}

			if (p == 0) {
				q.remove();
				continue;
			}

			if (q.size() == n) {
				continue;
			}

			q.add(p);
		}

		while(!q.isEmpty()) {
			bw.write(q.remove() + " ");
		}

		bw.close();
	}
}