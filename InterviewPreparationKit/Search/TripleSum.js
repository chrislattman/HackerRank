// https://www.hackerrank.com/challenges/triple-sum/problem
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

// Complete the triplets function below.
function triplets(a, b, c) {
    a.sort(function(x, y) {
        return x - y;
    });
    b.sort(function(x, y) {
        return x - y;
    });
    c.sort(function(x, y) {
        return x - y;
    });

    let a_set = [];
    let b_set = [];
    let c_set = [];
    a_set.push(a[0]);
    b_set.push(b[0]);
    c_set.push(c[0]);

    for (let i = 1; i < a.length; i++) {
        if (a[i] != a[i - 1]) {
            a_set.push(a[i]);
        }
    }

    for (let j = 1; j < b.length; j++) {
        if (b[j] != b[j - 1]) {
            b_set.push(b[j]);
        }
    }

    for (let k = 1; k < c.length; k++) {
        if (c[k] != c[k - 1]) {
            c_set.push(c[k]);
        }
    }

    let a_size = a_set.length;
    let b_size = b_set.length;
    let c_size = c_set.length;

    let triplets = 0;
    let a_index = 0;
    let c_index = 0;
    for (let m = 0; m < b_size; m++) {
        while (a_index < a_size && a_set[a_index] <= b_set[m]) {
            a_index++;
        }
        while (c_index < c_size && c_set[c_index] <= b_set[m]) {
            c_index++;
        }

        triplets += a_index * c_index;
    }

    return triplets;
}

function main() {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    const lenaLenbLenc = readLine().split(' ');

    const lena = parseInt(lenaLenbLenc[0], 10);

    const lenb = parseInt(lenaLenbLenc[1], 10);

    const lenc = parseInt(lenaLenbLenc[2], 10);

    const arra = readLine().split(' ').map(arraTemp => parseInt(arraTemp, 10));

    const arrb = readLine().split(' ').map(arrbTemp => parseInt(arrbTemp, 10));

    const arrc = readLine().split(' ').map(arrcTemp => parseInt(arrcTemp, 10));

    const ans = triplets(arra, arrb, arrc);

    ws.write(ans + '\n');

    ws.end();
}
