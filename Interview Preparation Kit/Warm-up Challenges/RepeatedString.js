// https://www.hackerrank.com/challenges/repeated-string/problem
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

// Complete the repeatedString function below.
function repeatedString(s, n) {
    let stringLength = s.length;
    let quotient = parseInt(n / stringLength);
    let remainder = n % stringLength;

    let aCount = 0;
    let aCountRemainder = 0;
    for (let i = 0; i < s.length; i++) {
        if (s[i] == 'a') {
            if (i < remainder) {
                aCountRemainder++;
            }
            aCount++;
        }
    }

    return aCount * quotient + aCountRemainder;
}

function main() {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    const s = readLine();

    const n = parseInt(readLine(), 10);

    let result = repeatedString(s, n);

    ws.write(result + "\n");

    ws.end();
}
