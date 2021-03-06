/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

CREATE EXTERNAL TABLE t_inlong_v1_0fc00000046(
    tdbank_imp_date STRING COMMENT 'partition fields',
    ftime STRING COMMENT 'default ',
    t1 STRING COMMENT 'default ',
    t2 STRING COMMENT 'default ',
    t3 STRING COMMENT 'default ',
    t4 STRING COMMENT 'default '
)
PARTITIONED BY (dt STRING)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY '\|'
STORED AS SEQUENCEFILE;
CREATE EXTERNAL TABLE t_inlong_v1_03600000045(
    tdbank_imp_date STRING COMMENT 'partition fields',
    ftime STRING COMMENT 'default ',
    t1 STRING COMMENT 'default ',
    t2 STRING COMMENT 'default ',
    t3 STRING COMMENT 'default ',
    t4 STRING COMMENT 'default '
)
PARTITIONED BY (dt STRING)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY '\|'
STORED AS SEQUENCEFILE;
CREATE EXTERNAL TABLE t_inlong_v1_05100054990(
    tdbank_imp_date STRING COMMENT 'partition fields',
    ftime STRING COMMENT 'default ',
    field1 STRING COMMENT 'default ',
    field2 STRING COMMENT 'default ',
    field3 STRING COMMENT 'default ',
    field4 STRING COMMENT 'default '
)
PARTITIONED BY (dt STRING)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY '\|'
STORED AS SEQUENCEFILE;
CREATE EXTERNAL TABLE t_inlong_v1_09c00014434(
    tdbank_imp_date STRING COMMENT 'partition fields',
    ftime STRING COMMENT 'default ',
    field1 STRING COMMENT 'default ',
    field2 STRING COMMENT 'default ',
    field3 STRING COMMENT 'default ',
    field4 STRING COMMENT 'default '
)
PARTITIONED BY (dt STRING)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY '\|'
STORED AS SEQUENCEFILE;
CREATE EXTERNAL TABLE t_inlong_v1_0c900035509(
    tdbank_imp_date STRING COMMENT 'partition fields',
    ftime STRING COMMENT 'default ',
    field1 STRING COMMENT 'default ',
    field2 STRING COMMENT 'default ',
    field3 STRING COMMENT 'default ',
    field4 STRING COMMENT 'default '
)
PARTITIONED BY (dt STRING)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY '\|'
STORED AS SEQUENCEFILE;