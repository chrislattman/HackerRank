// https://www.hackerrank.com/challenges/pairs/problem
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

function binarysearch(arr, left, right, val) {
    if (left > right) {
        return -1;
    }

    let mid = parseInt((left + right) / 2);

    if (arr[mid] == val) {
        return mid;
    }
    if (arr[mid] > val) {
        return binarysearch(arr, left, mid - 1, val);
    }
    if (arr[mid] < val) {
        return binarysearch(arr, mid + 1, right, val);
    }

    return -1;
}
    
// Complete the pairs function below.
function pairs(k, arr) {
    arr.sort(function(a, b) {
        return a - b;
    });
    let result = 0;

    for (let i = 0; i < arr.length - 1; i++) {
        if (binarysearch(arr, 0, arr.length - 1, arr[i] + k) >= 0) {
            result++;
        }
    }

    return result;
}

function main() {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    const nk = readLine().split(' ');

    const n = parseInt(nk[0], 10);

    const k = parseInt(nk[1], 10);

    const arr = readLine().split(' ').map(arrTemp => parseInt(arrTemp, 10));

    let result = pairs(k, arr);

    ws.write(result + "\n");

    ws.end();
}
