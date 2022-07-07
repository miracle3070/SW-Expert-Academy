# 성공
# 풀이시간: 23분

import sys
sys.stdin = open("input.txt", "r")

t = int(input()) # 테스트케이스 개수 입력받기
for test_case in range(t):
    n, k = map(int, input().split())

    # 퍼즐 모양 입력받기
    puzzle = []
    for _ in range(n):
        row = list(map(int, input().split()))
        puzzle.append(row)

    # 가로 탐색
    result = 0
    for y in range(n):
        for x in range(n):
            if puzzle[y][x] != 0 and puzzle[y][x] != 2:
                length = 0  # 빈 칸의 길이
                for i in range(n):
                    if x+i >= n:
                        break
                    if puzzle[y][x+i] != 0:
                        puzzle[y][x+i] = 2 # 완료한 가로 탐색 영역 표시
                        length += 1
                    else:
                        break
                if length == k:
                    result += 1

    # 세로 탐색
    for x in range(n):
        for y in range(n):
            if puzzle[y][x] != 0 and puzzle[y][x] != 3:
                length = 0
                for i in range(n):
                    if y+i >= n:
                        break
                    if puzzle[y+i][x] != 0:
                        puzzle[y+i][x] = 3 # 완료한 세로 탐색 영역 표시
                        length += 1
                    else:
                        break
                if length == k:
                    result += 1

    print(f"#{test_case+1} {result}")
