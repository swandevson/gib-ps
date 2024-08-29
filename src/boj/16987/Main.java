import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static int[][] eggs;
	static int ans = 0;

	public static void main(String args[]) throws IOException {
		n = Integer.parseInt(br.readLine());

		eggs = new int[n][2];
		for (int i = 0; i < n; i++) {
			eggs[i] = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::valueOf)
				.toArray();
		}

		for (int i = 0; i < n; i++) {
			solve(0, 0);
		}

		System.out.println(ans);
	}

	// 0 = durability, 1 = weight
	static void solve(int attack, int cnt) {
		if (attack == n) {
			ans = Math.max(ans, cnt);
			return;
		}

		if (eggs[attack][0] <= 0 || cnt == n-1) {   // broken egg on hand OR no eggs to break
			solve(attack + 1, cnt);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (attack == i) {
				continue;   // can't attack itself
			}

			if (eggs[i][0] <= 0) {  // can't break cuz already is broken
				continue;
			}

			eggs[i][0] -= eggs[attack][1];
			eggs[attack][0] -= eggs[i][1];

			if (eggs[i][0] <= 0 && eggs[attack][0] <= 0) {  // both are broken
				solve(attack + 1, cnt + 2);
			} else if (eggs[i][0] <= 0 || eggs[attack][0] <= 0) {   // one or the other is broken
				solve(attack + 1, cnt + 1);
			} else {    // nothing is broken
				solve(attack + 1, cnt);
			}

			eggs[i][0] += eggs[attack][1];
			eggs[attack][0] += eggs[i][1];

		}

	}
}