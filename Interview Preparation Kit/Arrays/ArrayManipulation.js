// https://www.hackerrank.com/challenges/crush/problem
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

// Complete the arrayManipulation function below.
function arrayManipulation(n, queries) {
    let largest = 0;
    let array = new Int32Array(n);

    for (let i = 0; i < queries.length; i++) {
        let a = queries[i][0];
        let b = queries[i][1];
        let k = queries[i][2];

        array[a - 1] += k;
        if (b < n) {
            array[b] -= k;
        }
    }

    let curr_largest = 0;
    for (let j = 0; j < n; j++) {
        curr_largest += array[j];
        largest = Math.max(curr_largest, largest);
    }

    return largest;
}

function main() {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    const nm = readLine().split(' ');

    const n = parseInt(nm[0], 10);

    const m = parseInt(nm[1], 10);

    let queries = Array(m);

    for (let i = 0; i < m; i++) {
        queries[i] = readLine().split(' ').map(queriesTemp => parseInt(queriesTemp, 10));
    }

    let result = arrayManipulation(n, queries);

    ws.write(result + "\n");

    ws.end();
}
