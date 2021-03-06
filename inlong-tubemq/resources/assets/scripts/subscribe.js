/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
(function () {
    var dialogInstance = new Dialog();
    var page = {
        init: function () {
            var self = this;
            self.initEvent();
            self.initTable();
        },
        initEvent: function () {
            var self = this;

            $('body').on('click', '#queryBtn', function () {
                var topicName = $('#topicNameInput').val();
                var consumeGroup = $('#consumeGroupInput').val();

                self.initTable({
                    topicName: topicName,
                    consumeGroup: consumeGroup
                });
            });

        },
        initTable: function (opts) {
            opts = opts || {
                    topicName: '',
                    consumeGroup: ''
                };

            var url = G_CONFIG.HOST + "?type=op_query&method=admin_query_sub_info&" + $.param(opts);
            if (!this.$dataTable) {
                this.$dataTable = $('#list').DataTable({
                    "ajax": {
                        "url": url,
                        "dataType": "jsonp"
                    },
                    //"ordering": false,
                    "columns": [{
                        "data": "consumeGroup",
                        "className": 'h1',
                        "render": function (data, type, full,
                                            meta) {
                            var html = '<a href="detail.html?consumeGroup='
                                + data
                                + '" class="link" >'
                                + data + '</a>';
                            return html;
                        }
                    }, {
                        "data": "topicSet",
                        "className": 'h1'
                    }, {
                        "data": "consumerNum",
                        "defaultContent": '--'
                    }],
                    language: {
                        searchPlaceholder: '????????????????????????Topic??????',
                        processing: "Loading...",
                        search: "??????:",
                        //lengthMenu: "???????????? _MENU_ ???",
                        lengthMenu: '???????????? <select class="min">'
                        +
                        '<option value="10">10</option>'
                        +
                        '<option value="20">20</option>'
                        +
                        '<option value="30">30</option>'
                        +
                        '<option value="40">40</option>'
                        +
                        '<option value="50">50</option>'
                        +
                        '<option value="-1">??????</option>'
                        +
                        '</select> ???',
                        info: "??????????????? _START_ ??? _END_ ????????? _TOTAL_ ???????????? ",
                        infoEmpty: "",
                        //infoFiltered:   "(_MAX_ ?????????????????????)",
                        infoFiltered: "",
                        infoPostFix: "",
                        loadingRecords: "????????????...",
                        zeroRecords: "????????????",
                        emptyTable: "????????????",
                        paginate: {
                            first: '<i class="i-first"></i>',
                            previous: '<i class="i-prev"></i>',
                            next: '<i class="i-next"></i>',
                            last: '<i class="i-last"></i>'
                        }
                    },
                    'pagingType': "full_numbers",
                    "dom": '<"scroll-wp"rt><"pg-wp"ilp>',
                });
            } else {
                this.$dataTable.ajax.url(url).load();
            }

        }
    };

    page.init();
})();