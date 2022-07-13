# 미해결
# 메모: 문제(예제)를 이해하지 못함.

# 2022-07-11 메모
# 미해결
# 풀이시간: 67분
# 오류 계속 발생

# 2022-07-13 메모
# 미해결
# 풀이시간: 60분
# 테스트케이스 10중 5개 실패

import sys
sys.stdin = open("input.txt", "r")

T = int(input())
for test_case in range(T):
    n = int(input())
    matrix = []
    for _ in range(n):
        row = list(map(int, input().split()))
        matrix.append(row)
    result = [[] for _ in range(n)]

    for _ in range(3):
        for k in range(n // 2):
            t1 = matrix[k][k:n-k]
            t2 = []
            for i in range(k, n-k):
                t2.append(matrix[i][n-k-1])
            t3 = matrix[n-k-1][k:n-k]
            t3 = t3[::-1]
            t4 = []
            for i in range(n-k-1, (k-1), -1):
                t4.append(matrix[i][k])

            idx = 0
            for i in range(k, n-k):
                matrix[k][i] = t4[idx]
                matrix[i][n-k-1] = t1[idx]
                matrix[n-k-1][i] = t2[idx]
                matrix[i][k] = t3[idx]
                idx += 1

            matrix[k][k] = t4[0]
            matrix[k][n-k-1] = t1[0]
            matrix[n-k-1][n-k-1] = t2[0]
            matrix[n-k-1][k] = t3[0]

        for i in range(n):
            result[i].append("".join(map(str, matrix[i])))

    print(f"#{test_case+1}")
    for r in result:
        print(" ".join(r))

