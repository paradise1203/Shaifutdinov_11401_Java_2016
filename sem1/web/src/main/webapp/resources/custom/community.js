/**
 * Created by paradise on 28.04.16.
 */

$(document).ready(function () {

    $(document).on('click', '.follow', function () {
        var community_id = $('.community_id').text();

        $.ajax({
            url: '/communities/' + community_id + '/members/add',
            type: 'post',
            success: function () {
                $(this).hide();
            }
        });
    });

});