package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class SWEA_2819 {

	public static int[] dr = { -1, 1, 0, 0 }; // 상, 하, 좌, 우
	public static int[] dc = { 0, 0, -1, 1 };
	public static int[][] map;
	public static int result;
	public static Set<String> set;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder resultString = new StringBuilder();
		for(int testCase = 1; testCase <= T; testCase++) {
			result = 0;
			map = new int[4][4];
			set = new HashSet<String>();
			
			for(int r = 0; r < 4; r++) {
				String[] strArr = br.readLine().split(" ");
				for(int c = 0; c < 4; c++) {
					map[r][c] = Integer.parseInt(strArr[c]);
				}
			}
			
			for(int r=0; r<4; r++) {
				for(int c=0; c<4; c++) {
					DFS(r, c, String.valueOf(map[r][c]));
				}
			}
			result = set.size();
			resultString.append('#').append(testCase).append(' ').append(result).append('\n');			
		}
		System.out.println(resultString);
	}
	
	public static void DFS(int r, int c, String str) {
		if(str.length() == 7) {
			set.add(str);
			return;
		}
		
		for(int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(0 <= nr && nr < 4 && 0 <= nc && nc < 4) {
				DFS(nr, nc, str+map[nr][nc]);
			}
		}
	}

}
