// https://www.hackerrank.com/challenges/ctci-recursive-staircase/problem
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

function stepPerms(n) {
    if (n < 3) {
        return n;
    }

    let array = new Int32Array(3);
    array[0] = 1;
    array[1] = 2;
    array[2] = 4;
    let current;

    for (let i = 3; i < n; i++) {
        current = array[2] + array[1] + array[0];
        array[0] = array[1];
        array[1] = array[2];
        array[2] = current;
    }
    
    return array[2];
}

function main() {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    const s = parseInt(readLine(), 10);

    for (let sItr = 0; sItr < s; sItr++) {
        const n = parseInt(readLine(), 10);

        const res = stepPerms(n);

        ws.write(res + '\n');
    }

    ws.end();
}
