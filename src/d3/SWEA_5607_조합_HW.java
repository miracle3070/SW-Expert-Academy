package d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5607_조합_HW {
	public static final int MOD_NUM = 1234567891;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		long[] factorial = new long[1_000_001];
		factorial[0] = 1;
		factorial[1] = 1;
		for(int i=1; i<=1_000_000; i++) {
			factorial[i] = (factorial[i-1] * i) % MOD_NUM;
		}
		
		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			long result = 1;
			
			long operand1 = factorial[N];
			long operand2 = powCalc((factorial[R] * factorial[N-R]) % MOD_NUM, MOD_NUM-2);		
			result = (operand1 * operand2) % MOD_NUM;
			
			sb.append('#').append(testCase).append(' ').append(result).append('\n');
		}
		System.out.print(sb.toString());
		br.close();
	}

	public static long powCalc(long num, int p) {
		if (p == 0)
			return 1;

		long half = powCalc(num, p / 2);

		if (p % 2 == 0) {
			return ((half % MOD_NUM) * (half % MOD_NUM)) % MOD_NUM;
		} else
			return (((half * num) % MOD_NUM) * (half % MOD_NUM)) % MOD_NUM;
	}

}
