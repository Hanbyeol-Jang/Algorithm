
public class Rotate {
	public static void main(String[] args) {
		int[][] map = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		printMap(map);
		map = rotate(map);

		printMap(map);
		map = rotate(map);

		printMap(map);
		map = rotate(map);

		printMap(map);
		map = rotate(map);

		printMap(map);

	}

	public static int[][] rotate(int[][] temp) {
		int[][] rotate = new int[temp.length][temp[0].length];

		for (int i = 0; i < rotate.length; i++) {
			for (int j = 0; j < rotate[i].length; j++) {
				rotate[i][j] = temp[temp.length - 1 - j][i];
			}
		}

		return rotate;
	}

	public static void printMap(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("=====================");
	}
}
