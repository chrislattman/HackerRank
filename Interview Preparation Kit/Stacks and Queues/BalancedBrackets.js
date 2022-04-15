// https://www.hackerrank.com/challenges/balanced-brackets/problem
'use strict';

const fs = require('fs');

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', inputStdin => {
    inputString += inputStdin;
});

process.stdin.on('end', _ => {
    inputString = inputString.replace(/\s*$/, '')
        .split('\n')
        .map(str => str.replace(/\s*$/, ''));

    main();
});

function readLine() {
    return inputString[currentLine++];
}

// Complete the isBalanced function below.
function isBalanced(s) {
    let stack = []

    for (let i = 0; i < s.length; i++) {
        let bracket = s[i];
        if (bracket == '(' || bracket == '{' || bracket == '[') {
            stack.push(bracket);
        }
        else {
            if (stack.length == 0) {
                return "NO";
            }

            let top = stack[stack.length - 1];
            if (bracket == ')' && top == '(') {
                stack.pop();
            }
            else if (bracket == '}' && top == '{') {
                stack.pop();
            }
            else if (bracket == ']' && top == '[') {
                stack.pop();
            }
            else {
                return "NO";
            }
        }
    }

    if (stack.length == 0) {
        return "YES";
    }

    return "NO";
}

function main() {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    const t = parseInt(readLine(), 10);

    for (let tItr = 0; tItr < t; tItr++) {
        const s = readLine();

        let result = isBalanced(s);

        ws.write(result + "\n");
    }

    ws.end();
}
