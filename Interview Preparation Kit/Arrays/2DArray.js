// https://www.hackerrank.com/challenges/2d-array/problem
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

// Complete the hourglassSum function below.
function hourglassSum(arr) {
    let max = Number.MIN_SAFE_INTEGER;

    for (let i = 0; i < 16; i++) {
        let quotient = parseInt(i / 4);
        let remainder = i % 4;

        let first = arr[quotient][remainder];
        let second = arr[quotient][remainder + 1];
        let third = arr[quotient][remainder + 2];
        let fourth = arr[quotient + 1][remainder + 1];
        let fifth = arr[quotient + 2][remainder];
        let sixth = arr[quotient + 2][remainder + 1];
        let seventh = arr[quotient + 2][remainder + 2];

        let sum = first + second + third + fourth + fifth + sixth + seventh;
        max = Math.max(sum, max);
    }

    return max;
}

function main() {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    let arr = Array(6);

    for (let i = 0; i < 6; i++) {
        arr[i] = readLine().split(' ').map(arrTemp => parseInt(arrTemp, 10));
    }

    let result = hourglassSum(arr);

    ws.write(result + "\n");

    ws.end();
}
