let name;
let lastName

name = window.prompt("Whats your name?")

document.getElementById("p1").innerHTML = "Was sup " + name;

document.getElementById("formButton").onclick = function () {
    lastName = document.getElementById("inputText").value;
    console.log(lastName)
    document.getElementById("greet").innerHTML = "Hello " + name + " " + lastName+ ", u lil' sheet!"
}

let a;
let b;
let c;

document.getElementById("cuboidButton").onclick = function () {
    a = document.getElementById("sideA").value;
    b = document.getElementById("sideB").value;
    c = document.getElementById("sideC").value;
    console.log(a, typeof a)
    console.log(b, typeof b)
    console.log(c, typeof c)
    let surface = 2 * ((a * b) + (b * c) + (c * a));
    let volume = a * b * c;
    window.alert("fck you");
    document.getElementById("surface").innerHTML = "Surface: " + surface;
    document.getElementById("volume").innerHTML = "Volume: " + volume;
}

let counter = 0;
setInterval(changeTitle, 3000);
function changeTitle() {
    counter++;
    switch (counter % 3) {
        case 1:
            document.getElementById("title").innerHTML = "ToDoZapisnik";
            break;
        case 2:
            document.getElementById("title").innerHTML = "ToDoZmrd";
            break;
        case 0:
            document.getElementById("title").innerHTML = "ToDoZlaticko";
            break;
    }
}

const square = document.getElementById("square")
window.addEventListener("keydown", move);

let x = 0;
let y = 0;
function move(event) {
    switch (event.key){
        case "ArrowLeft":
            x -= 5;
            square.style.left = x + "px";
            console.log(event.key)
            break;
        case "ArrowRight":
            x += 5;
            square.style.left = x + "px"
            console.log(event.key)
            break;
        case "ArrowDown":
            y += 5;
            square.style.top = y + "px";
            console.log(event.key)
            break;
        case "ArrowUp":
            y -= 5;
            square.style.top = y + "px"
            console.log(event.key)
            break;
    }
}

updateTime();
function updateTime() {
    let time = new Date()
    let hours = time.getHours().toString().padStart(2, "0");
    let minutes = time.getMinutes().toString().padStart(2, "0");
    let seconds = time.getSeconds().toString().padStart(2, "0");
    document.getElementById("clock").textContent = hours + ":" + minutes + ":" + seconds;
}

setInterval(updateTime, 1000);

function formatTime(value) {
    return value.toString().padStart(2, "0");
}

function tillMidnight() {
    let midnight = new Date(2024, 0, 4, 0o0, 0o0, 0o0);
    let currentTime = new Date();

    let timeDifference = midnight - currentTime;

    if (timeDifference < 0) {
        clearInterval(tillMidnight);
        window.alert("Time's Up")
        document.getElementById("countdown").textContent = "00:00:00";
    } else {
        let dHours = Math.floor((timeDifference % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
        let dMinutes = Math.floor((timeDifference % (1000 * 60 * 60)) / (1000 * 60));
        let dSeconds = Math.floor((timeDifference % (1000 * 60)) / 1000);

        document.getElementById("countdown").textContent = `${formatTime(dHours)}:${formatTime(dMinutes)}:${formatTime(dSeconds)}`;
    }
}

tillMidnight();

setInterval(tillMidnight, 1000);