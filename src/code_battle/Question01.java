// 성공
// 풀이시간: 1시간 50분

package code_battle;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question01 {
	
	static class Door implements Cloneable {
		int pos;	// 출입구 위치
		int people;	// 사람 수
		
		public Door(int pos, int people) {
			this.pos = pos;
			this.people = people;
		}

		@Override
		public String toString() {
			return "Door [pos=" + pos + ", people=" + people + "]";
		}
		
		@Override
		public Door clone() {
			Object obj = null;
			try {
				obj = super.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			
			Door d = (Door)obj;
			d.pos = pos;
			d.people = people;
			return d;
		}
		
		
	}
	
	public static int fieldCnt;
	public static int[] map;
	public static Door[] doors;
	public static boolean[] isSelected = new boolean[3];
	public static int[] selectedDoor = new int[3];
	public static int result = Integer.MAX_VALUE;
		
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder resultString = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			result = Integer.MAX_VALUE;
			fieldCnt = Integer.parseInt(br.readLine()); // 낚시터의 개수
			map = new int[fieldCnt + 1];
			doors = new Door[3];
			for(int i=0; i < 3; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int pos = Integer.parseInt(st.nextToken());
				int people = Integer.parseInt(st.nextToken());
				doors[i] = new Door(pos, people);
			}
			
			permutation(0);
			resultString.append('#').append(testCase).append(' ').append(result).append('\n');
		}
		
		System.out.println(resultString);
	}
	
	public static void permutation(int cnt) {
		if(cnt == 3) {
			positionPeople(0, 0, map.clone());
		}
		
		for(int i=0; i < 3; i++) {
			if(isSelected[i])
				continue;
			selectedDoor[cnt] = i;
			isSelected[i] = true;
			permutation(cnt+1);
			isSelected[i] = false;
		}
	}

	public static void positionPeople(int idx, int total, int[] argMap) {
		if(idx == 3) {
			if(total < result) {
				result = total;
			}
			return;
		}
		
		int sum1 = 0;
		int sum2 = 0;
		int[] cloneMap = argMap.clone();
		sum1 = leftFirst(doors[selectedDoor[idx]], cloneMap);
		positionPeople(idx+1, total+sum1, cloneMap);
		
		cloneMap = argMap.clone();
		sum2 = rightFirst(doors[selectedDoor[idx]], cloneMap);
		positionPeople(idx+1, total+sum2, cloneMap);
	}
	
	public static int leftFirst(Door argDoor, int[] map) {
		Door door = argDoor.clone();
		int dist = 1;
		int sum = 0;
		int start = door.pos;
		
		if(door.people >= 1 && map[start] == 0) {
			map[start] = door.pos;
			door.people--;
			sum++;
		}
		
		while(door.people > 0) {
			if(0 < (start-dist) && map[start-dist] == 0) {
				map[start-dist] = door.pos;
				door.people--;
				sum += (dist + 1);
			}
			if(door.people == 0)
				break;
			if((start+dist) <= fieldCnt && map[start+dist] == 0) {
				map[start+dist] = door.pos;
				door.people--;
				sum += (dist + 1);
			}
			dist++;
		}
		return sum;
	}
	
	public static int rightFirst(Door argDoor, int[] map) {
		Door door = argDoor.clone();
		int dist = 1;
		int sum = 0;
		int start = door.pos;
		
		if(door.people >= 1 && map[start] == 0) {
			map[start] = door.pos;
			door.people--;
			sum++;
		}
		
		while(door.people > 0) {
			if((start+dist) <= fieldCnt && map[start+dist] == 0) {
				map[start+dist] = door.pos;
				door.people--;
				sum += (dist + 1);
			}
			if(door.people == 0)
				break;
			if(0 < (start-dist) && map[start-dist] == 0) {
				map[start-dist] = door.pos;
				door.people--;
				sum += (dist + 1);
			}
			dist++;
		}
		return sum;
	}

}
