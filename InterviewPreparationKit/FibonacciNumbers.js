// https://www.hackerrank.com/challenges/ctci-fibonacci-numbers/problem
function processData(input) {
    var n = parseInt(input);
    console.log(fibonacci(n));
} 

process.stdin.resume();
process.stdin.setEncoding("ascii");
_input = "";
process.stdin.on("data", function (input) {
    _input += input;
});

process.stdin.on("end", function () {
   processData(_input);
});

function fibonacci(n) {
    if (n < 2) {
        return n;
    }
    
    return fibonacci(n - 1) + fibonacci(n - 2);
}
