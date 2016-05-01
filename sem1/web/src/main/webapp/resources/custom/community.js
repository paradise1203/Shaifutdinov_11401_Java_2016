/**
 * Created by paradise on 28.04.16.
 */

$(document).ready(function () {

    $(document).on('click', '.unsubscribe', function () {
        var td = $(this).parent('div');
        var community = $('#community').val();

        $.ajax({
            url: '/communities/' + community + '/unsubscribe',
            type: 'post',
            success: function () {
                td.children('a').remove();
                var link = $('<a>').text('Subscribe').addClass('subscribe')
                    .attr('style', 'float: right').attr('href', '#');
                td.append(link);
            }
        });
    });

    $(document).on('click', '.subscribe', function () {
        var td = $(this).parent('div');
        var community = $('#community').val();

        $.ajax({
            url: '/communities/' + community + '/subscribe',
            type: 'post',
            success: function () {
                td.children('a').remove();
                var link = $('<a>').text('Unsubscribe').addClass('unsubscribe')
                    .attr('style', 'float: right').attr('href', '#');
                td.append(link);
            }
        });
    });

    $(document).on('click', '.send', function () {
        var text = $('.text').val();
        var community = $('#community').val();

        $.ajax({
            url: '/communities/' + community + '/news/create',
            type: 'post',
            data: {
                text: text
            },
            success: function (news) {
                $('.news').append(news);
            }
        });
    });

});