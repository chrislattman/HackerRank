// https://www.hackerrank.com/challenges/count-triplets-1/problem
'use strict';

const fs = require('fs');

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', function(inputStdin) {
    inputString += inputStdin;
});

process.stdin.on('end', function() {
    inputString = inputString.split('\n');

    main();
});

function readLine() {
    return inputString[currentLine++];
}

// Complete the countTriplets function below.
function countTriplets(arr, r) {
    let first = new Map();
    let second = new Map();
    let triplets = 0;
    
    for (let i = 0; i < arr.length; i++) {
        let current = arr[i];
        if (current % r == 0) {
            let preceding = current / r;
            if (second.has(preceding)) {
                triplets += second.get(preceding);
            }
            if (first.has(preceding)) {
                if (second.has(current)) {
                    second.set(current, second.get(current) + first.get(preceding));
                }
                else {
                    second.set(current, first.get(preceding));
                }
            }
        }
        
        if (first.has(current)) {
            first.set(current, first.get(current) + 1);
        }
        else {
            first.set(current, 1);
        }
    }
    
    return triplets;
}

function main() {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    const nr = readLine().replace(/\s+$/g, '').split(' ');

    const n = parseInt(nr[0], 10);

    const r = parseInt(nr[1], 10);

    const arr = readLine().replace(/\s+$/g, '').split(' ').map(arrTemp => parseInt(arrTemp, 10));

    const ans = countTriplets(arr, r);

    ws.write(ans + '\n');

    ws.end();
}
