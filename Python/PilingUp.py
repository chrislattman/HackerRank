# https://www.hackerrank.com/challenges/piling-up/problem
cases = int(input())

for case in range(cases):
    num_cubes = int(input())
    cubes = [int(x) for x in input().split()]

    left_index = 0
    right_index = len(cubes) - 1
    current = max(cubes[left_index], cubes[right_index])
    pile_size = 0
    broken = False

    while pile_size < len(cubes) and not broken:
        if max(cubes[left_index], cubes[right_index]) <= current:
            current = max(cubes[left_index], cubes[right_index])
            if cubes[left_index] >= cubes[right_index]:
                left_index = left_index + 1
            else:
                right_index = right_index - 1
            pile_size = pile_size + 1
        else:
            broken = True
    
    if broken:
        print('No')
    else:
        print('Yes')
