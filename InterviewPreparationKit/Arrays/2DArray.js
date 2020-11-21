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
        let first = arr[parseInt(i / 4)][i % 4];
        let second = arr[parseInt(i / 4)][(i % 4) + 1];
        let third = arr[parseInt(i / 4)][(i % 4) + 2];
        let fourth = arr[parseInt(i / 4) + 1][(i % 4) + 1];
        let fifth = arr[parseInt(i / 4) + 2][i % 4];
        let sixth = arr[parseInt(i / 4) + 2][(i % 4) + 1];
        let seventh = arr[parseInt(i / 4) + 2][(i % 4) + 2];

        let sum = first + second + third + fourth + fifth + sixth + seventh;
        if (sum > max) {
            max = sum;
        }
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
