// https://www.hackerrank.com/challenges/ctci-ice-cream-parlor/problem
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

// Complete the whatFlavors function below.
function whatFlavors(cost, money) {
    let map = new Map();

    for (let i = 0; i < cost.length; i++) {
        map.set(cost[i], i);
    }

    for (let j = 0; j < cost.length; j++) {
        let first_price = cost[j];
        let second_price = money - first_price;
        if (map.has(second_price) && map.get(second_price) != j) {
            let first_index = j + 1;
            let second_index = map.get(second_price) + 1;
            console.log(first_index + " " + second_index);
            break;
        }
    }
}

function main() {
    const t = parseInt(readLine(), 10);

    for (let tItr = 0; tItr < t; tItr++) {
        const money = parseInt(readLine(), 10);

        const n = parseInt(readLine(), 10);

        const cost = readLine().split(' ').map(costTemp => parseInt(costTemp, 10));

        whatFlavors(cost, money);
    }
}
