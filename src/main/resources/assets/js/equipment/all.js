'use strict';

$(document).ready(function () {
    $('#equipment-table').DataTable({
        columns: [
            {
                render: function (data, type, row, meta) {
                    return '<a class="link-opacity-25-hover" href="./equipment/' + row['id'] + '">' + row['id'] + '</a>';
                }
            },
            {
                render: function (data, type, row, meta) {
                    return row['categoryName'];
                }
            },
            {
                render: function (data, type, row, meta) {
                    return row['manufacturer'];
                }
            },
            {
                render: function (data, type, row, meta) {
                    return row['model'];
                }
            },
            {
                render: function (data, type, row, meta) {
                    return new Date(row['registered']).toLocaleDateString();
                }
            },
            {
                render: function (data, type, row, meta) {
                    if (row['unregister'] != null) {
                        return new Date(row['unregister']).toLocaleDateString();
                    }
                    return '';
                }
            }
        ],
        language: {
            url: data_table_language()
        },
        ajax: './api/equipment'
    }).column('0:visible')
        .order('desc')
        .draw();
});
