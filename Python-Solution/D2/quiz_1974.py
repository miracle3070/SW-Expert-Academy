# 성공
# 풀이시간: 15분

import sys
sys.stdin = open("input.txt", "r")

T = int(input())
for test_case in range(T):
    sudoku = []
    for _ in range(9):
        row = list(map(int, input().split()))
        sudoku.append(row)

    result = 1
    # 각 행에 중복되는 값이 있는지 확인
    for i in range(9):
        row = set(sudoku[i])
        if len(row) < 9:
            result = 0
            break

    if result == 1:
        # 각 열에 중복되는 값이 있는지 확인
        for x in range(9):
            col = set()
            for y in range(9):
                col.add(sudoku[y][x])
            if len(col) < 9:
                result = 0
                break

    if result == 1:
        # 3x3 크기의 영역에 중복되는 값이 있는지 확인
        for y in range(0, 9, 3):
            for x in range(0, 9, 3):
                matrix = set()
                for i in range(3):
                    for k in range(3):
                        matrix.add(sudoku[y+i][x+k])
                if len(matrix) < 9:
                    result = 0
                    break

    print(f"#{test_case+1} {result}")
