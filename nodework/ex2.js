let m1=require('./modfunc');
console.log("1함수 = "+m1.add(20,10));

let age=21;
console.log("%d 세는 %s 입니다.",age,m1.check(age));
let age1=18;
console.log("%d 세는 %s 입니다.",age1,m1.check(age1));


let m2 = require("./modfunc2");
let score=78;
console.log("곱 = "+m2.mul(2,4));

console.log("%d 점은 %s 등급임",score,m2.grade(score));