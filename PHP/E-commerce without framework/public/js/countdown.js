let countDownDate= new Date("Jan 1,2020 00:00:00").getTime();
let x= setInterval(function(){
 let now = new Date().getTime();
    let distance = countDownDate- now;
    let days  = Math.floor(distance/(1000*60*60*24));
    let hours  = Math.floor((distance%(1000*60*60*24))/(1000*60*60));
    let minutes  = Math.floor((distance%(1000*60*60))/(1000*60));
    let seconds  = Math.floor((distance%(1000*60))/(1000));
    document.getElementById("launch").innerHTML = days + "d "+  hours +"hrs "+ minutes +"min "+ seconds+"seg ";
    if(distance<0){
        clearInterval(x);
        document.getElementById("launch").innerHTML="Expired now";
    }

},1000,);