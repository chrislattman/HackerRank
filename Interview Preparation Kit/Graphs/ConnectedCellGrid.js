// https://www.hackerrank.com/challenges/ctci-connected-cell-in-a-grid/problem
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

function search(grid, x, y) {
    if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length &&
        grid[x][y] == 1) {
        grid[x][y] = 0;
        return 1 + search(grid, x - 1, y) + search(grid, x + 1, y) +
                search(grid, x, y - 1) + search(grid, x, y + 1) +
                search(grid, x - 1, y - 1) + search(grid, x + 1, y - 1) +
                search(grid, x - 1, y + 1) + search(grid, x + 1, y + 1);
    }
    return 0;
}

// Complete the maxRegion function below.
function maxRegion(grid) {
    let largest = 0;

    for (let x = 0; x < grid.length; x++) {
        for (let y = 0; y < grid[0].length; y++) {
            if (grid[x][y] == 1) {
                let current = search(grid, x, y);
                if (current > largest) {
                    largest = current;
                }
            }
        }
    }

    return largest;
}

function main() {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    const n = parseInt(readLine(), 10);

    const m = parseInt(readLine(), 10);

    let grid = Array(n);

    for (let i = 0; i < n; i++) {
        grid[i] = readLine().split(' ').map(gridTemp => parseInt(gridTemp, 10));
    }

    const res = maxRegion(grid);

    ws.write(res + '\n');

    ws.end();
}
