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

# 2022-07-14 메모
# 해결완료
# 풀이시간: 30분
# 명관이에게서 아이디어를 얻음.

import sys
sys.stdin = open("input.txt", "r")

T = int(input())
for test_case in range(T):
    n = int(input())
    matrix = []
    for _ in range(n):
        row = input().split()
        matrix.append(row)
    result = [[] for _ in range(n)]

    for _ in range(3):
        switched_matrix = []
        for i in range(n):
            temp = []
            for k in range(n-1, -1, -1):
                temp.append(matrix[k][i])
            switched_matrix.append(temp)
        for i in range(n):
            result[i].append(switched_matrix[i])
        matrix = switched_matrix

    print(f"#{test_case+1}")
    for row in result:
        for r in row:
            print("".join(r), end=" ")
        print()

