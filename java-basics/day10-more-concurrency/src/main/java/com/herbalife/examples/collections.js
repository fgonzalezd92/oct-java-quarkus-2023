let numbers = [11, 45, 126, 23, 4, 99, 34];
//Print the square of all even numbers
let result = numbers
    .filter(e => {
        console.log("**** Filtering " + e);
        return e % 2 == 0;
    })
    .map(e => {
        console.log("**** Squaring " + e);
        return e * e;
    })[0];
console.log(result);
//    .forEach(e => console.log(e));
