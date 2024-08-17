import java.util.*;
import java.io.*;

class Solution {
	public String solution(String p) throws IOException {
		String ans = solve(p);

		return ans;
	}

	boolean isCorrect(String u) {
		Stack<Character> s = new Stack<>();

		for (char c : u.toCharArray()) {
			if (c == '(') {
				s.push(c);
			} else {
				if (s.isEmpty() || s.pop() != '(') {
					return false;
				}
			}
		}

		return true;
	}

	String solve(String p) {
		System.out.println(p);
		if (p.isEmpty()) {
			return "";
		}

		String u = "";
		int idx = 0;
		int balance = 0;

		while(idx < p.length()) {
			Character c = p.charAt(idx++);

			if (c == '(') balance++;
			else          balance--;

			u += c;

			if (balance == 0) break;
		}

		if (isCorrect(u)) {
			String s = solve(p.substring(idx, p.length()));

			return u + s;
		}

		String str = "(";
		str += solve(p.substring(idx, p.length()));
		str += ')';

		u = u.substring(1, u.length() - 1);
		String reversed = "";
		for (char c : u.toCharArray()) {
			if (c == '(') {
				reversed += ')';
			} else {
				reversed += '(';
			}
		}

		return str + reversed;
	}
}