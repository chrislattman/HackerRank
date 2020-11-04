// https://www.hackerrank.com/challenges/greedy-florist/problem
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

// Complete the getMinimumCost function below.
function getMinimumCost(k, c) {
    c.sort(function(a, b) {
        return a - b;
    });
    let total = 0;
    let mod = 0;
    let multiplier = 1;

    for (let i = c.length - 1; i >= 0; i--) {
        total += c[i] * multiplier;
        mod = (mod + 1) % k;
        if (mod == 0) {
            multiplier++;
        }
    }

    return total;
}

function main() {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    const nk = readLine().split(' ');

    const n = parseInt(nk[0], 10);

    const k = parseInt(nk[1], 10);

    const c = readLine().split(' ').map(cTemp => parseInt(cTemp, 10));

    const minimumCost = getMinimumCost(k, c);

    ws.write(minimumCost + '\n');

    ws.end();
}
