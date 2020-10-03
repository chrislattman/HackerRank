# https://www.hackerrank.com/challenges/word-order/problem
num_words = int(input())
dictionary = dict()

for i in range(num_words):
    word = input()
    if word in dictionary:
        dictionary[word] = dictionary[word] + 1
    else:
        dictionary[word] = 1

print(len(dictionary))

for word in dictionary:
    print(dictionary[word], end = ' ')
