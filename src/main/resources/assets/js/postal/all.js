'use strict';

$(document).ready(function () {
    $('#postal-table').DataTable({
        columns: [
            {
                render: function (data, type, row) {
                    return '<a class="link-opacity-25-hover" href="./postal/' + row['code'] + '">' + row['code'] + '</a>';
                }
            },
            {
                render: function (data, type, row) {
                    let number = ''
                    if (row['houseNumberMin'] !== null) {
                        number += row['houseNumberMin'];
                    }
                    if (row['houseNumberMin'] !== null && row['houseNumberMax'] !== null) {
                        number += ' - ';
                    }
                    if (row['houseNumberMax'] !== null) {
                        number += row['houseNumberMax'];
                    }
                    return number.trim();
                }
            },
            {
                render: function (data, type, row) {
                    return row['street'];
                }
            },
            {
                render: function (data, type, row) {
                    return row['neighbourhood'];
                }
            },
            {
                render: function (data, type, row) {
                    return row['district'];
                }
            },
            {
                render: function (data, type, row) {
                    if (row['isPostbox'] !== null && row['isPostbox'] === true) {
                        return '<i class="bi bi-check2"></i>';
                    }
                    return '';
                }
            }
        ],
        language: {
            url: data_table_language()
        },
        ajax: './api/postal'
    }).column('0:visible')
        .order('asc')
        .draw();
});
