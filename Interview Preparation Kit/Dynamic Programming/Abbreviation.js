// https://www.hackerrank.com/challenges/abbr/problem
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

// Complete the abbreviation function below.
function abbreviation(a, b) {
    let m = a.length;
    let n = b.length;

    let valid = Array(m + 1).fill().map(() => Array(n + 1).fill(false));
    valid[0][0] = true;

    for (let i = 1; i <= m; i++) {
        let end = Math.min(i, n);
        for (let j = 0; j <= end; j++) {
            let a_char = a[i - 1];

            if (j == 0) {
                if (a_char == a_char.toLowerCase()) {
                    valid[i][j] = valid[i - 1][j];
                }
            }
            else {
                let b_char = b[j - 1];

                if (a_char == b_char) {
                    valid[i][j] = valid[i - 1][j - 1];
                }
                else if (a_char.toUpperCase() == b_char) {
                    valid[i][j] = valid[i - 1][j - 1] | valid[i - 1][j];
                }
                else if (a_char == a_char.toLowerCase()) {
                    valid[i][j] = valid[i - 1][j];
                }
            }
        }
    }

    if (valid[m][n]) {
        return "YES";
    }
    return "NO";
}

function main() {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    const q = parseInt(readLine(), 10);

    for (let qItr = 0; qItr < q; qItr++) {
        const a = readLine();

        const b = readLine();

        let result = abbreviation(a, b);

        ws.write(result + "\n");
    }

    ws.end();
}
