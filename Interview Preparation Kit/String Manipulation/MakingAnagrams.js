// https://www.hackerrank.com/challenges/ctci-making-anagrams/problem
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

// Complete the makeAnagram function below.
function makeAnagram(a, b) {
    let a_map = new Map();
    let b_map = new Map();

    for (let i = 0; i < a.length; i++) {
        let letter = a[i];
        if (a_map.has(letter)) {
            a_map.set(letter, a_map.get(letter) + 1);
        }
        else {
            a_map.set(letter, 1);
        }
    }

    for (let j = 0; j < b.length; j++) {
        let letter = b[j];
        if (b_map.has(letter)) {
            b_map.set(letter, b_map.get(letter) + 1);
        }
        else {
            b_map.set(letter, 1);
        }
    }

    let removed = 0;
    for (let keyIndex = 0; keyIndex < 26; keyIndex++) {
        let key = String.fromCharCode(keyIndex + 97);
        if (a_map.has(key) && b_map.has(key)) {
            removed += Math.abs(a_map.get(key) - b_map.get(key));
        }
        else if (a_map.has(key)) {
            removed += a_map.get(key);
        }
        else if (b_map.has(key)) {
            removed += b_map.get(key);
        }
    }

    return removed;
}

function main() {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    const a = readLine();

    const b = readLine();

    const res = makeAnagram(a, b);

    ws.write(res + '\n');

    ws.end();
}
