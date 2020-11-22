// https://www.hackerrank.com/challenges/new-year-chaos/problem
'use strict';

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

// Complete the minimumBribes function below.
function minimumBribes(q) {
    let swaps = 0;
    let index = 0;
    let lastSortedIndex = -1;
    let too_chaotic = false;
    let bribeMap = new Map();
    
    while (index < q.length - 1) {
        if (q[index] > q[index + 1]) {
            if (bribeMap.has(q[index]) && bribeMap.get(q[index]) >= 2) {
                console.log("Too chaotic");
                too_chaotic = true;
                break;
            }
            if (!bribeMap.has(q[index])) {
                bribeMap.set(q[index], 0);
            }
            bribeMap.set(q[index], bribeMap.get(q[index]) + 1);
            
            let temp = q[index];
            q[index] = q[index + 1];
            q[index + 1] = temp;
            
            swaps++;
            index = lastSortedIndex;
        }
        else if (q[index] == index + 1) {
            lastSortedIndex++;
        }
        index++;
    }
    
    if (!too_chaotic) {
        console.log(swaps);
    }
}

function main() {
    const t = parseInt(readLine(), 10);

    for (let tItr = 0; tItr < t; tItr++) {
        const n = parseInt(readLine(), 10);

        const q = readLine().split(' ').map(qTemp => parseInt(qTemp, 10));

        minimumBribes(q);
    }
}
