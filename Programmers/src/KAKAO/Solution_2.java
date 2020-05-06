package KAKAO;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Solution_2 {
	public static String s = ")(";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		char[] str = s.toCharArray();

		HashMap<Character, Character> map = new HashMap<>();
		HashMap<Character, Character> map2 = new HashMap<>();
		map.put('(', ')');
		map2.put(')', '(');
		Stack<Character> stack = new Stack<>();
		Stack<Character> stack2 = new Stack<>();

		boolean possible = true;

		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(str[i])) {
				stack.push(str[i]);

			} else { // 오른쪽 발견
				if (!stack.isEmpty() && str[i] == map.get(stack.peek())) {
					stack.pop();
				} else {
					System.out.println(str[i]);
					stack2.push(str[i]);
				}
			}
		}
		
		for (int i = 0; i < stack2.size(); i++) {
			System.out.println(stack2.pop());
		}
		

		if (!stack.isEmpty()) { // 남아있으면 (갯수가 안맞음)
			possible = false;
		}

		if (possible) {
			System.out.println(s);
		} else {
			System.out.println("#" + " 0");
		}

	}
}
