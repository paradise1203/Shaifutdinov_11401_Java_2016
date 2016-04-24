/**
 * Created by paradise on 23.04.16.
 */

$(document).ready(function () {

    $("table").DataTable();

    $('#all').on('click', function () {
        doAjax('/requests/all');
    });

    $('#my').on('click', function () {
        doAjax('/requests/my');
    });

    $('#pending').on('click', function () {
        doAjax('/requests/pending');
    });

    function doAjax(url) {
        $.ajax({
            url: url,
            type: 'get',
            success: function (response) {
                var content = $('.tab-content');
                content.html(response);
                content.find('table').DataTable();
            }
        });
    }

    $('.nav-tabs > li > a').on('click', function () {
        var curLi = $(this).parent();
        curLi.siblings().each(function () {
            $(this).removeClass('active');
        });
        curLi.addClass('active');
    });

});
