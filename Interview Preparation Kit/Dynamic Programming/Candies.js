// https://www.hackerrank.com/challenges/candies/problem
'use strict';

const fs = require('fs');

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', inputStdin => {
    inputString += inputStdin;
});

process.stdin.on('end', function() {
    inputString = inputString.replace(/\s*$/, '')
        .split('\n')
        .map(str => str.replace(/\s*$/, ''));

    main();
});

function readLine() {
    return inputString[currentLine++];
}

// Complete the candies function below.
function candies(n, arr) {
    let up = new Array(n);
    let down = new Array(n);
    up[0] = 1;
    down[n - 1] = 1;
    let result = 0;
    
    for (let i = 1; i < n; i++) {
        if (arr[i] > arr[i - 1]) {
            up[i] = up[i - 1] + 1;
        }
        else {
            up[i] = 1;
        }
    }
    for (let j = n - 2; j >= 0; j--) {
        if (arr[j] > arr[j + 1]) {
            down[j] = down[j + 1] + 1;
        }
        else {
            down[j] = 1;
        }
    }
    for (let k = 0; k < n; k++) {
        result += Math.max(up[k], down[k]);
    }
    
    return result;
}

function main() {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    const n = parseInt(readLine(), 10);

    let arr = [];

    for (let i = 0; i < n; i++) {
        const arrItem = parseInt(readLine(), 10);
        arr.push(arrItem);
    }

    const result = candies(n, arr);

    ws.write(result + '\n');

    ws.end();
}
