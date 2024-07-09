
let a = 12;
let b =23.0;
let c = 12.6;

console.log(a+"는 정수인가? "+Number.isInteger(a));
console.log(b+"는 정수인가? "+Number.isInteger(b));
console.log(c+"는 정수인가? "+Number.isInteger(c));


let a1 = "Nan";
let b1 = NaN;
let c1 = "안녕";
let d1 = 12;

console.log("es5의 isNaN은 숫자 일경우 false, 숫자가 아닐경우 true");
console.log("a1="+isNaN(a1));
console.log("a1="+isNaN(b1));
console.log("a1="+isNaN(c1));
console.log("a1="+isNaN(d1));