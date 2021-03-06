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
    var page = {
        init: function () {
            var self = this;
            var consumeGroup = $.getUrlParam('consumeGroup');
            self.initEvent();
            self.showConsumerDetail(consumeGroup);
            self.showNav(consumeGroup);
        },

        initEvent: function () {
            var self = this;
            $('#listSearch').off('keyup click').on('keyup click', function () {
                self.$dataTable.search(
                    $(this).val()
                ).draw();
            });
        },

        showNav: function (consumeGroup) {
            $('#consumeGroupNav').html(consumeGroup)
        },

        showConsumerDetail: function (consumeGroup) {
            var self = this;
            var url = G_CONFIG.HOST
                + "?type=op_query&method=admin_query_consume_group_detail&consumeGroup="
                + consumeGroup + "&callback=?";
            $.getJSON(url)
                .done(function (res) {
                    if (res.errCode === 0) {
                        var data = res.data;
                        var tableData = [];
                        for (var one in data) {
                            var parInfo = data[one].parInfo;
                            if (parInfo.length > 0) {
                                for (var item in parInfo) {
                                    tableData.push([data[one].consumerId, parInfo[item].topicName,
                                        parInfo[item].brokerAddr,
                                        parInfo[item].partId]);
                                }
                            } else {
                                tableData.push([data[one].consumerId, null, null, null]);
                            }
                        }
                        // console.log(tableData)
                        self.initTable(tableData);
                    }
                });

        },

        initTable: function (dataSet) {
            if (!this.$dataTable) {
                this.$dataTable = $('#list').DataTable({
                    data: dataSet,
                    columns: [{
                        title: "?????????ID"
                    }, {
                        title: "??????Topic",
                        "orderable": false
                    }, {
                        title: "broker??????",
                        "orderable": false
                    }, {
                        title: "??????ID"
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
                this.$dataTable.clear().rows.add(dataSet).draw();
            }

        }
    };

    page.init();
})();