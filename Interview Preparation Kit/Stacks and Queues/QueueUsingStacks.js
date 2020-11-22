// https://www.hackerrank.com/challenges/ctci-queue-using-two-stacks/problem
const MyQueue = class {
    constructor() {
        this.stackNewestOnTop = []
        this.stackOldestOnTop = []
    }
    
    enqueue(value) {
        this.stackNewestOnTop.push(value);
    }
    
    peek() {
        if (this.stackOldestOnTop.length == 0) {
            while (this.stackNewestOnTop.length > 0) {
                this.stackOldestOnTop.push(this.stackNewestOnTop.pop());
            }
        }
        
        return this.stackOldestOnTop[this.stackOldestOnTop.length - 1];
    }
    
    dequeue() {
        if (this.stackOldestOnTop.length == 0) {
            while (this.stackNewestOnTop.length > 0) {
                this.stackOldestOnTop.push(this.stackNewestOnTop.pop());
            }
        }
        
        return this.stackOldestOnTop.pop();
    }
};


function processData(input) {
    let queue = new MyQueue();
    let n = parseInt(input[0]);
    
    for (let i = 1; i <= n; i++) {
        let array = input[i].split(' ');
        let operation = array[0];
        if (operation == 1) {
            queue.enqueue(array[1]);
        }
        else if (operation == 2) {
            queue.dequeue();
        }
        else if (operation == 3) {
            console.log(queue.peek());
        }
    }
} 

process.stdin.resume();
process.stdin.setEncoding("ascii");
_input = "";
process.stdin.on("data", function (input) {
    _input += input;
});

process.stdin.on("end", function () {
    _input = _input.replace(/\s*$/, '')
        .split('\n')
        .map(str => str.replace(/\s*$/, ''));
        
    processData(_input);
});
