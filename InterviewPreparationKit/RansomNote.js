// https://www.hackerrank.com/challenges/ctci-ransom-note/problem
'use strict';

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

// Complete the checkMagazine function below.
function checkMagazine(magazine, note) {
    let wordCounts = new Map();
    let no = false;

    for (let i = 0; i < magazine.length; i++) {
        let word = magazine[i];
        if (wordCounts.has(word)) {
            wordCounts.set(word, wordCounts.get(word) + 1);
        }
        else {
            wordCounts.set(word, 1);
        }
    }

    for (let j = 0; j < note.length; j++) {
        let word = note[j];
        if (wordCounts.has(word) && wordCounts.get(word) > 0) {
            wordCounts.set(word, wordCounts.get(word) - 1);
        }
        else {
            console.log("No");
            no = true;
            break;
        }
    }

    if (!no) {
        console.log("Yes");
    }
}

function main() {
    const mn = readLine().split(' ');

    const m = parseInt(mn[0], 10);

    const n = parseInt(mn[1], 10);

    const magazine = readLine().split(' ');

    const note = readLine().split(' ');

    checkMagazine(magazine, note);
}
