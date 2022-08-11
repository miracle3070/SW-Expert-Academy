# 성공
# 풀이시간: 14분

import sys
sys.stdin = open("input.txt", "r")

t = int(input())
for case in range(t):
    n, m = map(int, input().split())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))
    result = -int(1e9)

    if len(a) > len(b):
        longer = a
        shorter = b
        diff = len(a) - len(b)
    else:
        longer = b
        shorter = a
        diff = len(b) - len(a)

    for i in range(diff+1):
        temp = 0
        for k in range(len(shorter)):
            temp += (shorter[k] * longer[k+i])
        result = max(result, temp)

    print(f"#{case+1} {result}")
