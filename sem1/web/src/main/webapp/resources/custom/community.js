/**
 * Created by paradise on 28.04.16.
 */

$(document).ready(function () {

    $(document).on('click', '.unsubscribe', function () {
        var td = $(this).parent('div');
        var community_id = $('.community_id').text();

        $.ajax({
            url: '/communities/' + community_id + '/unsubscribe',
            type: 'post',
            success: function () {
                td.children('a').remove();
                var link = $('<a>').text('Subscribe').addClass('subscribe').attr('style', 'float: right').attr('href', '#');
                td.append(link);
            }
        });
    });

    $(document).on('click', '.subscribe', function () {
        var td = $(this).parent('div');
        var community_id = $('.community_id').text();

        $.ajax({
            url: '/communities/' + community_id + '/subscribe',
            type: 'post',
            success: function () {
                td.children('a').remove();
                var link = $('<a>').text('Unsubscribe').addClass('unsubscribe').attr('style', 'float: right').attr('href', '#');
                td.append(link);
            }
        });
    });

});