// https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem
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

// Complete the isValid function below.
function isValid(s) {
    if (s.length < 2) {
        return "YES";
    }

    let map = new Map();

    for (let i = 0; i < s.length; i++) {
        let current = s[i];
        if (map.has(current)) {
            map.set(current, map.get(current) + 1);
        }
        else {
            map.set(current, 1);
        }
    }

    let highestFrequency = Number.MIN_SAFE_INTEGER;
    let lowestFrequency = Number.MAX_SAFE_INTEGER;
    let highestFrequencyCount = 0;
    let lowestFrequencyCount = 0;

    for (let value of map.values()) {
        if (value > highestFrequency) {
            highestFrequency = value;
            highestFrequencyCount = 1;
        }
        else if (value == highestFrequency) {
            highestFrequencyCount++;
        }

        if (value < lowestFrequency) {
            lowestFrequency = value;
            lowestFrequencyCount = 1;
        }
        else if (value == lowestFrequency) {
            lowestFrequencyCount++;
        }
    }

    if (highestFrequency == lowestFrequency) {
        return "YES";
    }
    if (highestFrequency * highestFrequencyCount == s.length - 1 &&
        lowestFrequency == 1) {
        return "YES";
    }
    if (lowestFrequency * lowestFrequencyCount + highestFrequency ==
        s.length && highestFrequency - 1 == lowestFrequency) {
        return "YES";
    }

    return "NO";
}

function main() {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    const s = readLine();

    let result = isValid(s);

    ws.write(result + "\n");

    ws.end();
}
