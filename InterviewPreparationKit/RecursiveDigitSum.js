// https://www.hackerrank.com/challenges/recursive-digit-sum/problem
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

// Complete the digitSum function below.
function superDigit(n, k) {
    if (n.length == 1 && k == 1) {
        return parseInt(n);
    }
    
    let sum = 0;
    for (let i = 0; i < n.length; i++) {
        sum += parseInt(n[i]) * k;
    }
    
    return superDigit(sum.toString(), 1);
}

function main() {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    const nk = readLine().split(' ');

    const n = nk[0];

    const k = parseInt(nk[1], 10);

    const result = superDigit(n, k);

    ws.write(result + '\n');

    ws.end();
}
