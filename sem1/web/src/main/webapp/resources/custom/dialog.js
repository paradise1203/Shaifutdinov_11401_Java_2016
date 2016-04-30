/**
 * Created by paradise on 30.04.16.
 */

$(document).ready(function () {

    setInterval(getNew, 10000);

    $(document).on('click', '.send', function () {
        var friend = $('.friend').text();
        var text = $('.text').val();

        $.ajax({
            url: '/users/' + friend + '/dialog',
            type: 'post',
            data: {
                text: text
            },
            success: function (message) {
                $('#dialog').append(message);
            }
        });
    });

});

function getNew() {
    var friend = $('.friend').text();

    $.ajax({
        url: '/users/' + friend + '/dialog/new',
        type: 'GET',
        success: function (messages) {
            $("#dialog").append(messages);
        }
    });
}