# 미해결
# 메모: 문제(예제)를 이해하지 못함.

# 2022-07-11 메모
# 미해경
# 풀이시간: 67분
# 오류 계속 발생

import sys
sys.stdin = open("input.txt", "r")

T = int(input())
for test_case in range(T):
    n = int(input())
    matrix = []
    for _ in range(n):
        row = list(map(int, input().split()))
        matrix.append(row)

    t1 = []
    for i in range(3):
        for k in range(n//2):
            for a in range(n-k-1, -1, -1):
                t1.append(matrix[a][k])
            t2 = matrix[k][k:n-k]
            matrix[k][k:n-k] = list(t1)

            t1 = []
            for a in range(n-k):
                t1.append(matrix[a][n-k-1])

            try:
                for a in range(n-k):
                    matrix[a][n-k-1] = t2[a]
            except IndexError:
                print("에러발생")
                print("n=", n)
                print(a, n-k-1)

            t2 = []
            for a in range(n-k-1, -1, -1):
                t2.append(matrix[n-k-1][a])
            matrix[n-k-1][k:n-k] = list(t1)

            for a in range(n-k):
                matrix[a][k] = t2[a]
            t1 = []

