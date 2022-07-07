# 성공
# 풀이시간: 9분

import sys
sys.stdin = open("input.txt", "r")

T = int(input())
for test_case in range(T):
    n, m = map(int, input().split())
    board = []
    for _ in range(n):
        row = list(map(int, input().split()))
        board.append(row)

    result = -int(1e9)
    for y in range(n-m+1):
        for x in range(n-m+1):
            temp = 0
            for i in range(m):
                for k in range(m):
                    temp += board[y+i][x+k]
            result = max(result, temp)

    print(f"#{test_case+1} {result}")