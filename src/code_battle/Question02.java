// 성공
// 풀이시간: 40분

package code_battle;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Question02 {
	static class Position {
		int num; // 고객 또는 몬스터 번호
		int r;
		int c;
		
		public Position(int num, int r, int c) {
			this.num = num;
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Position [num=" + num + ", r=" + r + ", c=" + c + "]";
		}
	}
	public static int mapSize;
	public static int cnt;
	public static int result;
	public static boolean[] isSelected;
	public static int[] selected;
	public static boolean[] killed;
	public static List<Position> list;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder resultString = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			mapSize = Integer.parseInt(br.readLine());
			cnt = 0;
			result = Integer.MAX_VALUE;
			list = new ArrayList<Position>();
			
			for(int r=1; r<=mapSize; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int c=1; c<=mapSize; c++) {
					int cur = Integer.parseInt(st.nextToken());
					if(cur != 0) {
						list.add(new Position(cur, r, c));
						cnt++;
					}
				}
			}
			
			isSelected = new boolean[cnt];
			selected = new int[cnt];
			permutation(0);
			resultString.append('#').append(testCase).append(' ').append(result).append('\n');
		}
		System.out.println(resultString);
	}
	
	public static void permutation(int curIdx) {
		if(curIdx == cnt) {
			killed = new boolean[cnt+1];
			calcDistance();
			return;
		}
		for(int i=0; i<cnt; i++) {
			if(isSelected[i])
				continue;
			selected[curIdx] = i;
			isSelected[i] = true;
			permutation(curIdx+1);
			isSelected[i] = false;
		}
	}
	
	public static void calcDistance() {
		int distance = 0;
		int curR = 1;
		int curC = 1;
		
		for(int i : selected) {
			Position thing = list.get(i);
			if(thing.num > 0) {
				killed[thing.num] = true;
			} else {
				if(killed[-thing.num] == false)
					return;
			}
			distance += (Math.abs(thing.r - curR) + Math.abs(thing.c - curC));
			curR = thing.r;
			curC = thing.c;
		}
		
		if (result > distance) {
			result = distance;
		}
	}

}
