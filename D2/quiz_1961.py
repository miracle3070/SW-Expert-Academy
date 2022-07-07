# 미해결
# 메모: 문제(예제)를 이해하지 못함.

import sys
sys.stdin = open("input.txt", "r")

T = int(input())
for test_case in range(T):
    n = int(input())
    matrix = []
    for _ in range(n):
        row = list(map(int, input().split()))
        matrix.append(row)
