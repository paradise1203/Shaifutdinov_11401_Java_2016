/**
 * Created by paradise on 01.05.16.
 */

var map;
var needy;
var marker;

function initMap() {
    var lat = Number($('#latitude').val());
    var long = Number($('#longitude').val());

    needy = {
        lat: lat,
        lng: long
    };

    map = new google.maps.Map(document.getElementById('map'), {
        center: needy,
        zoom: 15
    });
    marker = new google.maps.Marker({
        map: map,
        position: needy
    });
}

$(document).ready(function () {

    $(document).on('click', '.send', function () {
        var text = $('.text').val();
        var request = $('#request').val();

        $.ajax({
            url: '/requests/' + request + '/comments/create',
            type: 'post',
            data: {
                text: text
            },
            success: function (comments) {
                $('.comments').append(comments);
            }
        });
    });

    $(document).on('click', '.path', function () {
        var address = $('.address').val();
        var request = $('#request').val();

        $.ajax({
            url: '/requests/' + request + '/path',
            type: 'get',
            data: {
                address: address
            },
            success: function (location) {
                if (location != null) {
                    console.log(location);
                    var volunteer = {
                        lat: location.lat,
                        lng: location.lng
                    };
                    var directionsDisplay = new google.maps.DirectionsRenderer({
                        map: map
                    });
                    var request = {
                        destination: needy,
                        origin: volunteer,
                        travelMode: google.maps.TravelMode.WALKING
                    };
                    var directionsService = new google.maps.DirectionsService();
                    directionsService.route(request, function (response, status) {
                        if (status == google.maps.DirectionsStatus.OK) {
                            directionsDisplay.setDirections(response);
                        }
                    });
                    marker.setMap(null);
                } else {
                    //TODO
                }
            }
        });
    });

});
