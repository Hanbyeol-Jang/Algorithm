import java.util.Scanner;

public class Main_6987 {

	static int[][] game;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int play = 0; play < 4; play++) {
			game = new int[6][3];

			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					game[i][j] = sc.nextInt();
				}
			}
			
			if (isEqualWinLose() && drawCnt()) {
				System.out.print(1 + " ");
			} else {
				System.out.print(0 + " ");
			}
		}
	}

	public static boolean drawCnt() {
		int draw = 0;
		int cnt = 0;

		for (int i = 0; i < game.length; i++) {
			for (int j = 0; j < game.length; j++) {
				if (j == 1) {
					if (game[i][j] != 0) {
						draw += game[i][j];
						cnt++;
					}
				} else {
					continue;
				}
			}
		}

		if (cnt % 2 == 0 && draw % 2 == 0) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean isEqualWinLose() {
		int win = 0;
		int lose = 0;

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 3; j++) {
				if (j == 0) {
					win += game[i][j];
				} else if (j == 2) {
					lose += game[i][j];
				} else {
					continue;
				}
			}
		}

		if (win == lose) {
			return true;
		} else {
			return false;
		}
	}

	public static void printMap(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("======================");
	}
}
