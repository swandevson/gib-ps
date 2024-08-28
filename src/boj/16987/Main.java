import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static int[][] eggs;
	static int ans = 0;

	public static void main(String args[]) throws IOException {
		n = Integer.valueOf(br.readLine());

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

	// 0 = durability, 1 = weight
	static void solve(int attack, int cnt) {
		// System.out.println(attack);
		if (attack == n || cnt == n - 1) {
			ans = Math.max(ans, cnt);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (attack == i) {
				continue;   // can't attack itself
			}

			if (eggs[attack][0] <= 0) {
				solve(attack + 1, cnt);
			} else if (eggs[attack][0] > 0 && eggs[i][0] > 0) {
				eggs[attack][0] -= eggs[i][1];
				eggs[i][0] -= eggs[attack][1];
				if (eggs[i][0] <= 0 && eggs[attack][0] <= 0) {
					solve(attack + 1, cnt + 2);
				} else if (eggs[i][0] <= 0) {
					solve(attack + 1, cnt + 1);
				} else if (eggs[attack][0] <= 0) {
					solve(attack + 1, cnt + 1);
				} else {
					solve(attack + 1, cnt);
				}
				eggs[attack][0] += eggs[i][1];
				eggs[i][0] += eggs[attack][1];
			}
		}

	}
}