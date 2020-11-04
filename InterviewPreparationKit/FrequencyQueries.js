// https://www.hackerrank.com/challenges/frequency-queries/problem
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

// Complete the freqQuery function below.
function freqQuery(queries) {
    let output = [];
    let map = new Map();
    let frequencies = new Map();
    
    for (let i = 0; i < queries.length; i++) {
        let queryType = queries[i][0];
        let data = queries[i][1];
        
        if (queryType == 1) {
            if (map.has(data)) {
                let old_frequency_key = map.get(data);
                let new_frequency_key = old_frequency_key + 1;
                map.set(data, new_frequency_key);
                
                let old_frequency_value = frequencies.get(old_frequency_key);
                frequencies.set(old_frequency_key, old_frequency_value - 1);

                if (frequencies.has(new_frequency_key)) {
                    let new_frequency_value = frequencies.get(new_frequency_key);
                    frequencies.set(new_frequency_key, new_frequency_value + 1);
                }
                else {
                    frequencies.set(new_frequency_key, 1);
                }
            }
            else {
                map.set(data, 1);
                if (frequencies.has(1)) {
                    frequencies.set(1, frequencies.get(1) + 1);
                }
                else {
                    frequencies.set(1, 1);
                }
            }
        }
        else if (queryType == 2) {
            if (map.has(data) && map.get(data) > 1) {
                let old_frequency_key = map.get(data);
                let new_frequency_key = old_frequency_key - 1;
                map.set(data, new_frequency_key);

                let old_frequency_value = frequencies.get(old_frequency_key);
                frequencies.set(old_frequency_key, old_frequency_value - 1);

                if (frequencies.has(new_frequency_key)) {
                    frequencies.set(new_frequency_key, 
                        frequencies.get(new_frequency_key) + 1);
                }
                else {
                    frequencies.set(new_frequency_key, 1);
                }
            }
            else if (map.has(data)) {
                map.delete(data);
                if (frequencies.has(1)) {
                    frequencies.set(1, frequencies.get(1) - 1);
                }
            }
        }
        else {
            if (frequencies.has(data) && frequencies.get(data) > 0) {
                output.push(1);
            }
            else {
                output.push(0);
            }
        }
    }
    
    return output;
}

function main() {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    const q = parseInt(readLine().trim(), 10);

    let queries = Array(q);

    for (let i = 0; i < q; i++) {
        queries[i] = readLine().replace(/\s+$/g, '').split(' ').map(queriesTemp => parseInt(queriesTemp, 10));
    }

    const ans = freqQuery(queries);

    ws.write(ans.join('\n') + '\n');

    ws.end();
}
