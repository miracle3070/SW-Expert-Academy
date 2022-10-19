package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5643_키순서 {
	static class Student {
		int num;
		List<Student> parent;
		List<Student> child;

		public Student(int num) {
			this.num = num;
			parent = new ArrayList<Student>();
			child = new ArrayList<Student>();
		}
	}

	public static int studentCnt;
	public static Student[] students;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder resultString = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			studentCnt = Integer.parseInt(br.readLine());
			students = new Student[studentCnt + 1];
			for (int i = 1; i <= studentCnt; i++) {
				students[i] = new Student(i);
			}

			int compCnt = Integer.parseInt(br.readLine());
			for (int i = 0; i < compCnt; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int pIdx = Integer.parseInt(st.nextToken());
				int cIdx = Integer.parseInt(st.nextToken());
				Student pStudent = students[pIdx]; // 부모 노드가 될 학생
				Student cStudent = students[cIdx]; // 자식 노드가 될 학생
				pStudent.child.add(cStudent);
				cStudent.parent.add(pStudent);
			}

			int result = 0;
			for (int i = 1; i <= studentCnt; i++) {
				int parentCnt = parentBFS(students[i]);
				int childCnt = childBFS(students[i]);
				if((parentCnt + childCnt + 1) == studentCnt)
					result++;
			}
			resultString.append('#').append(testCase).append(' ').append(result).append('\n');
		}
		System.out.print(resultString.toString());

	}

	public static int parentBFS(Student start) {
		boolean[] visited = new boolean[studentCnt+1];
		Queue<Student> q = new ArrayDeque<>();
		q.offer(start);
		visited[start.num] = true; 
		int cnt = 0;
		
		while(!q.isEmpty()) {
			Student now = q.poll();
			for(Student parent : now.parent) {
				if(visited[parent.num])
					continue;
				q.offer(parent);
				visited[parent.num] = true;
				cnt++;
			}
		}
		return cnt;
	}
	
	public static int childBFS(Student start) {
		boolean[] visited = new boolean[studentCnt+1];
		Queue<Student> q = new ArrayDeque<>();
		q.offer(start);
		visited[start.num] = true; 
		int cnt = 0;
		
		while(!q.isEmpty()) {
			Student now = q.poll();
			for(Student child : now.child) {
				if(visited[child.num])
					continue;
				q.offer(child);
				visited[child.num] = true;
				cnt++;
			}
		}
		return cnt;
	}

}
