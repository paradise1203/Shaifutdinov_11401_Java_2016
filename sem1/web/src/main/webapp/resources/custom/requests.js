/**
 * Created by paradise on 23.04.16.
 */

$(document).ready(function () {

    $(document).on('click', '.all', function () {

        $.ajax({
            url: '/users/requests/all',
            type: 'get',
            success: function (requests) {
                requests.each(function () {
                    console.log($(this));
                })
            }
        });

    });

});
