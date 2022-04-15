// https://www.hackerrank.com/challenges/luck-balance/problem
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

// Complete the luckBalance function below.
function luckBalance(k, contests) {
    let balance = 0;
    let important = [];

    for (let i = 0; i < contests.length; i++) {
        if (contests[i][1] == 0) {
            balance += contests[i][0];
        }
        else {
            important.push(contests[i][0]);
        }
    }

    important.sort(function(a, b) {
        return a - b;
    });

    if (important.length > k) {
        let midpoint = important.length - k;
        for (let j = midpoint; j < important.length; j++) {
            balance += important[j];
        }

        for (let m = 0; m < midpoint; m++) {
            balance -= important[m];
        }
    }
    else {
        for (let p = 0; p < important.length; p++) {
            balance += important[p];
        }
    }

    return balance;
}

function main() {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    const nk = readLine().split(' ');

    const n = parseInt(nk[0], 10);

    const k = parseInt(nk[1], 10);

    let contests = Array(n);

    for (let i = 0; i < n; i++) {
        contests[i] = readLine().split(' ').map(contestsTemp => parseInt(contestsTemp, 10));
    }

    const result = luckBalance(k, contests);

    ws.write(result + '\n');

    ws.end();
}
