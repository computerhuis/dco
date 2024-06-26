'use strict';

$(document).ready(function () {
    $('#postal-table').DataTable({
        columns: [
            {
                render: function (data, type, row, meta) {
                    return '<a class="link-opacity-25-hover" href="./postal/' + row['code'] + '">' + row['code'] + '</a>';
                }
            },
            {
                render: function (data, type, row, meta) {
                    return row['houseNumberMin'] + ' - ' + row['houseNumberMax'];
                }
            },
            {
                render: function (data, type, row, meta) {
                    return row['street'];
                }
            },
            {
                render: function (data, type, row, meta) {
                    return row['neighbourhood'];
                }
            },
            {
                render: function (data, type, row, meta) {
                    return row['district'];
                }
            },
        ],
        language: {
            url: data_table_language()
        },
        ajax: './api/postal'
    });
});
