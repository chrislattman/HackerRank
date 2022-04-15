#!/bin/python3
# https://www.hackerrank.com/challenges/fraudulent-activity-notifications/problem
import math
import os
import random
import re
import sys
from heapq import heapify, heappush, heappop


class RollingMedianHeaps:
    def __init__(self):
        self.minHeap = []
        self.maxHeap = []
        heapify(self.minHeap)
        heapify(self.maxHeap)

    def getMedian(self):
        size = len(self.minHeap) + len(self.maxHeap)
        if size % 2 == 0:
            return (-1 * self.maxHeap[0] + self.minHeap[0]) / 2
        return -1 * self.maxHeap[0]

    def add(self, number):
        if len(self.maxHeap) == 0 or number <= -1 * self.maxHeap[0]:
            heappush(self.maxHeap, -1 * number)
        else:
            heappush(self.minHeap, number)
        self.balanceHeaps()

    def remove(self, number):
        if (-1 * number) in self.maxHeap:
            self.maxHeap.remove(-1 * number)
            heapify(self.maxHeap)
        elif number in minHeap:
            self.minHeap.remove(number)
            heapify(self.minHeap)
        self.balanceHeaps()

    def balanceHeaps(self):
        if len(self.maxHeap) < len(self.minHeap):
            heappush(self.maxHeap, -1 * heappop(self.minHeap))
        elif len(self.maxHeap) > 1 + len(self.minHeap):
            heappush(self.minHeap, -1 * heappop(self.maxHeap))


# Complete the activityNotifications function below.
def activityNotifications(expenditure, d):
    notifications = 0
    heaps = RollingMedianHeaps()

    for i in range(len(expenditure)):
        if i >= d:
            if expenditure[i] >= 2 * heaps.getMedian():
                notifications = notifications + 1
            heaps.remove(expenditure[i - d])
        heaps.add(expenditure[i])

    return notifications


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    nd = input().split()

    n = int(nd[0])

    d = int(nd[1])

    expenditure = list(map(int, input().rstrip().split()))

    result = activityNotifications(expenditure, d)

    fptr.write(str(result) + '\n')

    fptr.close()
