/*
Задание 1
Создать объект, описывающий автомобиль (производитель,
модель, год выпуска, средняя скорость), и следующие функции
для работы с этим объектом.
1. Функция для вывода на экран информации об автомобиле.
2. Функция для подсчета необходимого времени для преодоления переданного расстояния со средней скоростью.
Учтите, что через каждые 4 часа дороги водителю необходимо делать перерыв на 1 час.
*/
const vehicle = {
    manufacturer: 'Tesla',
    model: 'Model S',
    year: 2022,
    averageSpeed: 120,
    displayInfo: function () {
        console.log(`Manufacturer: ${this.manufacturer}`);
        console.log(`Model: ${this.model}`);
        console.log(`Year of Manufacture: ${this.year}`);
        console.log(`Average Speed: ${this.averageSpeed} km/h`);

        vehicle.displayInfo();
        console.log(vehicle.calculateTimeToCoverDistance(1000));

    },
    calculateTimeToCoverDistance: function (distance) {
        let totalSpeed = this.averageSpeed;
        let breakHours = 0;
        let totalHours = distance / totalSpeed;
        if (totalHours > 4) {
            let extraHours = totalHours - 4;
            breakHours = Math.floor(extraHours / 4);
            totalHours = totalHours + breakHours;
        }
        return secondsToTime(totalHours * 3600);
    }
};
/*
Задание 2
Создать объект, хранящий в себе отдельно числитель и знаменатель дроби, и следующие функции для работы с этим объектом.
1. Функция сложения 2-х объектов-дробей.
2. Функция вычитания 2-х объектов-дробей.
3. Функция умножения 2-х объектов-дробей.
4. Функция деления 2-х объектов-дробей.
5. Функция сокращения объекта-дроби.
*/
const Fraction = function (numerator, denominator) {
    this.numerator = numerator;
    this.denominator = denominator;
};

Fraction.prototype.add = function (fraction) {
    let numerator = (this.numerator * fraction.denominator) + (this.denominator * fraction.numerator);
    let denominator = this.denominator * fraction.denominator;
    return new Fraction(numerator, denominator);
};

Fraction.prototype.subtract = function (fraction) {
    let numerator = (this.numerator * fraction.denominator) - (this.denominator * fraction.numerator);
    let denominator = this.denominator * fraction.denominator;
    return new Fraction(numerator, denominator);
};

Fraction.prototype.multiply = function (fraction) {
    let numerator = this.numerator * fraction.numerator;
    let denominator = this.denominator * fraction.denominator;
    return new Fraction(numerator, denominator);
};

Fraction.prototype.divide = function (fraction) {
    let numerator = this.numerator * fraction.denominator;
    let denominator = this.denominator * fraction.numerator;
    return new Fraction(numerator, denominator);
};

Fraction.prototype.reduce = function () {
    let gcd = function gcd(a, b) {
        return b ? gcd(b, a % b) : a;
    };
    let divisor = gcd(this.numerator, this.denominator);
    this.numerator /= divisor;
    this.denominator /= divisor;
    return this;
};

Fraction.prototype.toString = function () {
    return this.numerator + '/' + this.denominator;
};
let firstFraction = new Fraction(3, 4);
let secondFraction = new Fraction(2, 3);

let sum = firstFraction.add(secondFraction);
console.log(sum.toString()); // Output: 17/12

let difference = firstFraction.subtract(secondFraction);
console.log(difference.toString()); // Output: 1/12

let product = firstFraction.multiply(secondFraction);
console.log(product.toString()); // Output: 1/2

let quotient = firstFraction.divide(secondFraction);
console.log(quotient.toString()); // Output: 9/8

let reduced = quotient.reduce();
console.log(reduced.toString()); // Output: 9/8
/*
Задание 3
Создать объект, описывающий время (часы, минуты, секунды), и следующие функции для работы с этим объектом.
1. Функция вывода времени на экран.
2. Функция изменения времени на переданное количество
секунд.
3. Функция изменения времени на переданное количество
минут.
4. Функция изменения времени на переданное количество
часов.
Учтите, что в последних 3-х функциях, при изменении одной
части времени, может измениться и другая. Например: если ко
времени «20:30:45» добавить 30 секунд, то должно получиться
«20:31:15», а не «20:30:75».
*/
const Time = function (hours, minutes, seconds) {
    this.hours = hours;
    this.minutes = minutes;
    this.seconds = seconds;
};

Time.prototype.displayTime = function () {
    let hh = this.hours.toString().padStart(2, "0");
    let mm = this.minutes.toString().padStart(2, "0");
    let ss = this.seconds.toString().padStart(2, "0");
    console.log(`${hh}:${mm}:${ss}`);
};

Time.prototype.addSeconds = function (seconds) {
    this.seconds += seconds;
    while (this.seconds >= 60) {
        this.seconds -= 60;
        this.minutes++;
    }
    while (this.minutes >= 60) {
        this.minutes -= 60;
        this.hours++;
    }
};

Time.prototype.addMinutes = function (minutes) {
    this.minutes += minutes;
    while (this.minutes >= 60) {
        this.minutes -= 60;
        this.hours++;
    }
};

Time.prototype.addHours = function (hours) {
    this.hours += hours;
};
let time = new Time(20, 30, 45);
time.displayTime(); // Output: "20:30:45"
time.addSeconds(30);
time.displayTime(); // Output: "20:31:15"
time.addMinutes(60);
time.displayTime(); // Output: "21:31:15"
time.addHours(5);
time.displayTime(); // Output: "02:31:15"

