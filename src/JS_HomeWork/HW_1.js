//-------------------------------------------------------------------
/*
1. Написать функцию, которая принимает 2 числа и возвращает
-1, если первое меньше, чем второе;
1 – если первое больше, чем второе;
и 0 – если числа равны.
*/
function compareNumbers(num1, num2) {
    if (num1 < num2) {
        return -1;
    } else if (num1 > num2) {
        return 1;
    } else {
        return 0;
    }
}

function compareNumbers(num1, num2) {
    return (num1 === num2) ? 0 : (num1 < num2 ? -1 : 1);
}

console.log(compareNumbers(3, 5)); // Output: -1
console.log(compareNumbers(7, 3)); // Output: 1
console.log(compareNumbers(5, 5)); // Output: 0

//-------------------------------------------------------------------
/*
2. Написать функцию, которая вычисляет факториал переданного ей числа.
*/
function factorial(num) {
    if (num === 0 || num === 1) {
        return 1;
    }
    return num * factorial(num - 1);
}

function factorial(num) {
    if (num < 0) {
        return 'undefined';
    } else if (num > 1 && num === parseInt(num, 10)) {
        return num * factorial(num - 1);
    } else {
        return 1;
    }
}

console.log(factorial(5)); // Output: 120
console.log(factorial(3)); // Output: 6
console.log(factorial(1)); // Output: 1

//-------------------------------------------------------------------
/*
3. Написать функцию, которая принимает три отдельные цифры и превращает их в одно число.
Например: цифры 1, 4, 9 превратятся в число 149.
*/
function concatenateNumbers(num1, num2, num3) {
    return "" + num1 + num2 + num3;
}

function concatenateNumbers(num1, num2, num3) {
    return num1 + num2 + num3;
}

console.log(concatenateNumbers(1, 4, 9)); // Output: "149"
console.log(concatenateNumbers(5, 8, 2)); // Output: "582"
console.log(concatenateNumbers(0, 0, 7)); // Output: "007"


//-------------------------------------------------------------------
/*
4. Написать функцию, которая принимает длину и ширину
прямоугольника и вычисляет его площадь. Если в функцию
передали 1 параметр, то она вычисляет площадь квадрата.
*/
function calculateArea(length, width) {
    if (width === undefined) {
        // Assume it's a square
        return length * length;
    } else {
        return length * width;
    }
}

console.log(calculateArea(4)); // Output: 16
console.log(calculateArea(4, 5)); // Output: 20
console.log(calculateArea(3, 7)); // Output: 21

function calculateArea(length, width = length) {
    return length * width;
}

console.log(calculateArea(4)); // Output: 16
console.log(calculateArea(4, 5)); // Output: 20
console.log(calculateArea(3, 7)); // Output: 21

//-------------------------------------------------------------------
/*
5. Написать функцию, которая проверяет, является ли переданное ей число совершенным. Совершенное число – это
число, равное сумме всех своих собственных делителей.
*/
function isPerfect(num) {
    let divisors = [];
    for (let i = 1; i < num; i++) {
        if (num % i === 0) {
            divisors.push(i);
        }
    }
    let sum = divisors.reduce((a, b) => a + b, 0);
    return sum === num;
}

console.log(isPerfect(6)); // Output: true
console.log(isPerfect(28)); // Output: true
console.log(isPerfect(496)); // Output: true
console.log(isPerfect(8128)); // Output: true
console.log(isPerfect(5)); // Output: false

//-------------------------------------------------------------------
/*
6. Написать функцию, которая принимает минимальное и
максимальное значения для диапазона, и выводит только
те числа из диапазона, которые являются совершенными.
Используйте написанную ранее функцию, чтобы узнавать,
совершенное число или нет.
*/
function findPerfectNumbers(min, max) {
    let perfectNumbers = [];
    for (let i = min; i <= max; i++) {
        if (isPerfect(i)) {
            perfectNumbers.push(i);
        }
    }
    return perfectNumbers;
}

console.log(findPerfectNumbers(1, 10000));

//-------------------------------------------------------------------
/*
7. Написать функцию, которая принимает время (часы, минуты, секунды) и выводит его на экран в формате «чч:мм:сс».
Если при вызове функции минуты и/или секунды не были
переданы, то выводить их как 00.
*/
function formatTime(hours, minutes = 0, seconds = 0) {
    let hh = hours.toString().padStart(2, "0");
    let mm = minutes.toString().padStart(2, "0");
    let ss = seconds.toString().padStart(2, "0");
    return `${hh}:${mm}:${ss}`;
}

console.log(formatTime(8)); // Output: "08:00:00"
console.log(formatTime(8, 30)); // Output: "08:30:00"
console.log(formatTime(8, 30, 45)); // Output: "08:30:45"

function formatTime(hours, minutes = 0, seconds = 0) {
    if (hours < 0 || minutes < 0 || seconds < 0) {
        return 'Invalid Time';
    } else if (hours > 23 || minutes > 59 || seconds > 59) {
        return 'Invalid Time';
    } else if (hours === parseInt(hours, 10) && minutes === parseInt(minutes, 10) && seconds === parseInt(seconds, 10)) {
        let hh = hours.toString().padStart(2, "0");
        let mm = minutes.toString().padStart(2, "0");
        let ss = seconds.toString().padStart(2, "0");
        return `${hh}:${mm}:${ss}`;
    } else {
        return 'Invalid Time';
    }
}

//-------------------------------------------------------------------
/*
8. Написать функцию, которая принимает часы, минуты и
секунды и возвращает это время в секундах.
*/
function timeToSeconds(hours, minutes, seconds) {
    return (hours * 3600) + (minutes * 60) + seconds;
}

console.log(timeToSeconds(1, 30, 45)); // Output: 5445
console.log(timeToSeconds(2, 15, 30)); // Output: 8190
console.log(timeToSeconds(0, 15, 30)); // Output: 930

//-------------------------------------------------------------------
/*
9. Написать функцию, которая принимает количество секунд,
переводит их в часы, минуты и секунды и возвращает в виде строки «чч:мм:сс».
*/
function secondsToTime(totalSeconds) {
    let hours = Math.floor(totalSeconds / 3600);
    let minutes = Math.floor((totalSeconds % 3600) / 60);
    let seconds = totalSeconds % 60;

    let hh = hours.toString().padStart(2, "0");
    let mm = minutes.toString().padStart(2, "0");
    let ss = seconds.toString().padStart(2, "0");

    return `${hh}:${mm}:${ss}`;
}

console.log(secondsToTime(5445)); // Output: "01:30:45"
console.log(secondsToTime(8190)); // Output: "02:15:30"
console.log(secondsToTime(930)); // Output: "00:15:30"

function secondsToTime(totalSeconds) {
    if (totalSeconds < 0 || totalSeconds === parseInt(totalSeconds, 10)) {
        let hours = Math.floor(totalSeconds / 3600);
        let minutes = Math.floor((totalSeconds % 3600) / 60);
        let seconds = totalSeconds % 60;

        let hh = hours.toString().padStart(2, "0");
        let mm = minutes.toString().padStart(2, "0");
        let ss = seconds.toString().padStart(2, "0");

        return `${hh}:${mm}:${ss}`;
    } else {
        return 'Invalid Time';
    }
}

//-------------------------------------------------------------------
/*
10. Написать функцию, которая считает разницу между датами.
Функция принимает 6 параметров, которые описывают 2
даты, и возвращает результат в виде строки «чч:мм:сс». При
выполнении задания используйте функции из предыдущих 2-х заданий: сначала обе даты переведите в секунды,
узнайте разницу в секундах, а потом разницу переведите обратно в «чч:мм:сс».
*/
function dateDifference(year1, month1, day1, hour1, minute1, second1, year2, month2, day2, hour2, minute2, second2) {
    let date1 = new Date(year1, month1 - 1, day1, hour1, minute1, second1);
    let date2 = new Date(year2, month2 - 1, day2, hour2, minute2, second2);

    let differenceInMilliseconds = date2 - date1;
    let differenceInSeconds = differenceInMilliseconds / 1000;

    return secondsToTime(differenceInSeconds);
}

console.log(dateDifference(2022, 1, 10, 8, 30, 0, 2022, 1, 10, 10, 15, 30)); // Output: "01:45:30"
console.log(dateDifference(2022, 1, 10, 8, 30, 0, 2022, 1, 12, 8, 15, 0)); // Output: "48:45:00"

function dateDifference(year1, month1, day1, hour1, minute1, second1, year2, month2, day2, hour2, minute2, second2) {
    if (month1 < 1 || month1 > 12 || month2 < 1 || month2 > 12 || day1 > 31 || day1 < 1 || day2 > 31 || day2 < 1 ||
        hour1 > 23 || hour1 < 0 || hour2 > 23 || hour2 < 0 || minute1 > 59 || minute1 < 0 || minute2 > 59 ||
        minute2 < 0 || second1 > 59 || second1 < 0 || second2 > 59 || second2 < 0) {
        return 'Invalid Time';
    }
    let date1 = new Date(year1, month1 - 1, day1, hour1, minute1, second1);
    let date2 = new Date(year2, month2 - 1, day2, hour2, minute2, second2);

    let differenceInMilliseconds = date2 - date1;
    let differenceInSeconds = differenceInMilliseconds / 1000;

    return secondsToTime(differenceInSeconds);
}

