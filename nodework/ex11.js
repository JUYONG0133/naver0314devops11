class Person{
    constructor(name,age) {
        this.name=name;
        this.age=age;
    }

    printProfile(){
        console.log(`이름 : ${this.name}, 나이 : ${this.age}`);
    }

    static showTitle(){
        console.log("es6의 정적함수");

    }
}

let p = new Person("손흥민",25);
p.printProfile();
console.log("printProfile" in p.__proto__);
console.log("printProfile" in Person.prototype);

Person.showTitle();