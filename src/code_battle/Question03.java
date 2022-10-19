// 실패

package code_battle;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Question03 {
	public static Integer[] cards;
	public static int result;

	public static Integer[] incCards; // 오름차순으로 정렬된 카드
	public static Integer[] decCards; // 내림차순으로 정렬된 카드

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			result = Integer.MAX_VALUE;
			int cardCnt = Integer.parseInt(br.readLine());
			cards = new Integer[cardCnt];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < cardCnt; i++) {
				cards[i] = Integer.valueOf(st.nextToken());
			}

			incCards = cards.clone();
			decCards = cards.clone();
			Arrays.sort(incCards);
			Arrays.sort(decCards, Collections.reverseOrder());
			
			

		}
	}

}
