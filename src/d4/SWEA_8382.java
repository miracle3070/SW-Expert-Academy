// 미해결

package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_8382 {
	static class Node {
		int r;
		int c;
		int cnt;
		int dir;
		
		public Node(int r, int c, int cnt, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.dir = dir;
		}
	}
	
	public static int[][] map;
	public static boolean[][][] visited;	
	public static int sr, sc; // 시작점
	public static int er, ec; // 도착점
	public static int[] dr = {-1, 1, 0, 0};
	public static int[] dc = {0, 0, -1, 1};
	public static int result;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder resultString = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			map = new int[201][201];
			visited = new boolean[201][201][2];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			sc = Integer.parseInt(st.nextToken()) + 100;
			sr = Integer.parseInt(st.nextToken()) + 100;
			ec = Integer.parseInt(st.nextToken()) + 100;
			er = Integer.parseInt(st.nextToken()) + 100;
			
			//BFS();
			System.out.println(result);
		}
		
	}

}
