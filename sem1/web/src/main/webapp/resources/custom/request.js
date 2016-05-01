/**
 * Created by paradise on 01.05.16.
 */

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

});
