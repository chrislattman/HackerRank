# https://www.hackerrank.com/challenges/ctci-queue-using-two-stacks/problem
class MyQueue(object):
    def __init__(self):
        self.stack_newest_on_top = []
        self.stack_oldest_on_top = []
    
    def peek(self):
        if len(self.stack_oldest_on_top) == 0:
            while len(self.stack_newest_on_top) > 0:
                self.stack_oldest_on_top.append(self.stack_newest_on_top.pop())
        return self.stack_oldest_on_top[-1]
        
    def pop(self):
        if len(self.stack_oldest_on_top) == 0:
            while len(self.stack_newest_on_top) > 0:
                self.stack_oldest_on_top.append(self.stack_newest_on_top.pop())
        return self.stack_oldest_on_top.pop()
        
    def put(self, value):
        self.stack_newest_on_top.append(value)


queue = MyQueue()
t = int(input())
for line in range(t):
    values = map(int, input().split())
    values = list(values)
    if values[0] == 1:
        queue.put(values[1])        
    elif values[0] == 2:
        queue.pop()
    else:
        print(queue.peek())