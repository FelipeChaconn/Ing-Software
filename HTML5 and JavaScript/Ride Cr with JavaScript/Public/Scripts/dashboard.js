const let_user = sessionStorage.getItem('session_User');
'use strict';

const rides_key = 'rides';
let x = 20;

/**
 * Inserts an ride table dinamically
 *
 * @param tableName
 * @param tableData
 */

function insertRide() {
    const usr_session = sessionStorage.getItem('session_User');
    const name_const = document.getElementById('name_input').value;
    const start_const = document.getElementById('start_input').value;
    const end_const = document.getElementById('end_input').value;
    const desc_const = document.getElementById('description_input').value;
    const date_date = document.getElementById('date_input').value;
    const date_const = date_date.toString();
    let currentKey = localStorage.getItem('RideLastInsertedId');

    if (!currentKey) {
        localStorage.setItem('RideLastInsertedId', 1);
        currentKey = 1;
    } else {
        currentKey = parseInt(currentKey) + 1;
        localStorage.setItem('RideLastInsertedId', currentKey);
    }

    // create the ride object
    const ride = {
        usr_session,
        name_const,
        start_const,
        end_const,
        desc_const,
        date_const,
        id: currentKey
    };

    // add it to the database
    let rides = JSON.parse(localStorage.getItem(rides_key));
    if (rides && rides.length > 0) {
        rides.push(ride);
    } else {
        rides = []
        rides.push(ride)
    }
    localStorage.setItem(rides_key, JSON.stringify(rides));


    // render the rides
    renderTable('rides', rides);
    $('#add_rides').modal('close');
    location.reload();
}
/**
 * Edit an ride table dinamically
 *
 * @param tableName
 * @param tableData
 */

function editRide() {
    const usr_session = sessionStorage.getItem('session_User');
    const name_const = document.getElementById('name_edit').value;
    const start_const = document.getElementById('start_edit').value;
    const end_const = document.getElementById('end_edit').value;
    const desc_const = document.getElementById('description_edit').value;
    const date_date = document.getElementById('date_edit').value;
    const date_const = date_date.toString();
    const id = document.getElementById('editId').value;

    // create the ride object
    const ride = {
        usr_session,
        name_const,
        start_const,
        end_const,
        desc_const,
        date_const,
        id
    };

    // add it to the database
    debugger;
    let rides = JSON.parse(localStorage.getItem(rides_key));
    let results = rides.filter(ride => ride.id != id);
    results.push(ride);
    localStorage.setItem(rides_key, JSON.stringify(results));

    renderTable('rides', rides);
    $('#edit_rides').modal('close');
    location.reload();
    //clearFields();
    // render the books
}


/**
 * Renders an HTML table dinamically
 *
 * @param tableName
 * @param tableData
 */


function renderTable(tableName, tableData) {
    let table = jQuery(`#${tableName}_table`);
    // loop through all the items of table and generates the html
    let rows = "";
    tableData.forEach((ride, index) => {
        //This if check if user session is equals to session storage.and set elements into table.
        if (ride.usr_session == let_user) {
            let row = `<tr><td>${ride.name_const}</td><td>${ride.start_const}</td><td>${ride.end_const}</td><td>${ride.date_const}</td>`;
            row += `<td> <a onclick="editEntity(this)" data-id="${ride.id}" data-entity="${tableName}" class="link edit">Edit</a>  |  <a  onclick="deleteEntity(this);" data-id="${ride.id}" data-entity="${tableName}" class="link delete">Delete</a>  </td>`;
            rows += row + '</tr>';
        } else {

        }

    });
    table.html(rows);
}

function editEntity(element) {
    debugger;
    $('#edit_rides').modal('open');
    const dataObj = jQuery(element).data();

    let rides = JSON.parse(localStorage.getItem(rides_key));
    let rideFound;
    rides.forEach(function(ride) {
        if (ride.id == dataObj.id) {
            rideFound = ride;
            return;
        }
    });
    sessionStorage.getItem('session_User').value = rideFound.usr_session;
    document.getElementById('name_edit').value = rideFound.name_const;
    document.getElementById('start_edit').value = rideFound.start_const;
    document.getElementById('end_edit').value = rideFound.end_const;
    document.getElementById('description_edit').value = rideFound.desc_const;
    document.getElementById('date_edit').value = rideFound.date_const;
    document.getElementById('editId').value = rideFound.id;
}

function deleteEntity(element) {
    const dataObj = jQuery(element).data();
    const newEntities = deleteFromTable(dataObj.entity, dataObj.id);
    renderTable(dataObj.entity, newEntities);
}

function loadTableData(tableName) {
    renderTable(tableName, getTableData(tableName));
}



/**
 * Binds the different events to the different elements of the page
 */
function bindEvents() {
    jQuery('#add-ride-button').bind('click', function(element) {
        insertRide();
    });

    jQuery('#edit-ride-button').bind('click', function(element) {
        editRide();
    });
}
/**
 * Renders an HTML map
 *
 * @param lat
 * @param lng
 */

function initMap() {
    let uluru = {
        lat: 0,
        lng: -0
    };
    let map = new google.maps.Map(document.getElementById("googleMap"), {
        zoom: 15,
        center: uluru
    });

    // Try HTML5 geolocation.
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function(position) {
            var pos = {
                lat: position.coords.latitude,
                lng: position.coords.longitude
            };


            let marker = new google.maps.Marker({
                position: pos,
                map: map
            });
            map.setCenter(pos);
        }, function() {
            handleLocationError(true, infoWindow, map.getCenter());
        });
    } else {
        // Browser doesn't support Geolocation
        handleLocationError(false, infoWindow, map.getCenter());
    }
}