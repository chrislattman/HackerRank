// https://www.hackerrank.com/challenges/minimum-swaps-2/problem
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

// Complete the minimumSwaps function below.
function minimumSwaps(arr) {
    let swaps = 0;
    let index = 0;
    let current_value = 1;
    
    while (current_value < arr.length) {
        let arr_value = arr[index];
        while (arr_value != current_value) {
            index++;
            arr_value = arr[index];
        }
        if (arr_value != index + 1) {
            arr[index] = arr[arr_value - 1];
            arr[arr_value - 1] = arr_value;
            swaps++;
        }
        current_value++;
        index = arr_value;
    }
    
    return swaps;
}

function main() {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    const n = parseInt(readLine(), 10);

    const arr = readLine().split(' ').map(arrTemp => parseInt(arrTemp, 10));

    const res = minimumSwaps(arr);

    ws.write(res + '\n');

    ws.end();
}
