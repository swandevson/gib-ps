import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static String ans;

	// 1. choose 1, 2, or 3
	// 2. check if it is bad permutation
	// 3. if not, repeat step 1 & 2
	// 4. if, rechoose number

	public static void main(String args[]) throws IOException {
		n = Integer.parseInt(br.readLine());
		for (int i = 1; i <= 80; i++) {
			ans += "3";
		}
		StringBuilder sb = new StringBuilder("1");

		solve(sb);

		System.out.println(ans);
	}

	static void solve(StringBuilder sb) {
		if (sb.length() == n) {
			System.out.println(sb.toString());

			System.exit(0);
		}

		for (int i = 1; i <= 3; i++) {
			sb.append(String.valueOf(i));
			if (!isBadPermutation(sb.toString())) {
				solve(sb);
			}
			sb.delete(sb.length() - 1, sb.length());
		}
	}

	static boolean isBadPermutation(String p) {
		int length = p.length();

		for (int i = 1; i <= length / 2; i++) {
			String right = p.substring(length-i);
			String left = p.substring(length - (i*2), length - i);

			if (right.equals(left)) return true;
		}

		return false;
	}
}