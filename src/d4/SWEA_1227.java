package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1227 {
	public static int sx, sy;
	public static int ex, ey;
	public static int result;
	public static int[] dx = { -1, 1, 0, 0 }; // 상하좌우
	public static int[] dy = { 0, 0, -1, 1 }; // 상하좌우

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder resultString = new StringBuilder();
		for (int t = 0; t < 10; t++) {
			result = 0;
			int testCase = Integer.parseInt(br.readLine());
			int[][] map = new int[100][100];
			int[][] visited = new int[100][100];

			for (int x = 0; x < 100; x++) {
				String str = br.readLine();
				for (int y = 0; y < 100; y++) {
					map[x][y] = str.charAt(y) - '0';
					if (map[x][y] == 2) {
						sx = x;
						sy = y;
					}

					if (map[x][y] == 3) {
						ex = x;
						ey = y;
					}
				}
			}

			visited[sx][sy] = 1;
			DFS(map, visited, sx, sy);
			resultString.append('#').append(testCase).append(' ').append(result).append('\n');
		}
		System.out.println(resultString);
	}

	public static void DFS(int[][] map, int[][] visited, int x, int y) {
		if (x == ex && y == ey) {
			result = 1;
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 <= nx && nx < 100 && 0 <= ny && ny < 100) {
				if (visited[nx][ny] == 0 && map[nx][ny] != 1) {
					visited[nx][ny] = 1;
					DFS(map, visited, nx, ny);
				}
			}
		}
	}

}
