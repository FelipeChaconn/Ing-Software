//var arraylist of users
const rideList = JSON.parse(localStorage.getItem('rides')) || [];
//let arraylist parse
let table = jQuery(`#view_table`);
let ride_show = [];
'use strict';

const rides_key = 'rides';
let x = 20;

function getRides() {
    //check constants
    let ride_fromInput = document.getElementById('input-from').value;
    let ride_toInput = document.getElementById('input-to').value;
    let ride_from = [];
    //verify user exists
    rideList.forEach(function(ride, index) {
        if (ride_fromInput == (ride.start_const)) {
            ride_from.push(ride);
        }
    });
    ride_from.forEach(function(ride, index) {
        if (ride_toInput == (ride.end_const)) {
            ride_show.push(ride);
        } else {
            //Ride message show : rides no availible
        }
    });
    console.log(ride_show);
    console.log();
    if (ride_show !== 'undefined' && ride_show.length > 0) {
        let rows = "";
        for (let i = 0; i < ride_show.length; i++) {
            let row = `<tr><td>${ride_show[i].name_const}</td><td>${ride_show[i].start_const}</td><td>${ride_show[i].end_const}</td><td>${ride_show[i].date_const}</td>`;
            row += `<td> <a  class="waves-effect waves-light btn blue darken-1 modal-trigger" href="#modal-show">View</a> </td>`;
            rows += row + '</tr>';
        }

        table.html(rows);
        ride_show = [];
    }

}
