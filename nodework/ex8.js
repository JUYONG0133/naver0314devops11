
let r=(w,h)=>{
    if(Number.isNaN(w*h)){
        return "가로, 세로 값이 숫ㅈ가 아닙니다."
    }
    else {
        let a=`가로가 ${w}cm, 세로가 ${h}cm 인 사각형의 넓이는 ${w*h}입니다`;
        return a;
    }
}

console.log(r(5,6));
console.log("=".repeat(30));
console.log(r('a','b'));
console.log("=".repeat(30));
console.log(r(10,'a'))  ;