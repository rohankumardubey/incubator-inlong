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

package org.apache.inlong.manager.common.pojo.datastorage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Basic data storage information
 */
@Data
@ApiModel("Basic data storage information")
public class StorageSummaryInfo {

    private Integer id;

    @ApiModelProperty("Business group id")
    private String inlongGroupId;

    @ApiModelProperty("Data stream id")
    private String inlongStreamId;

    @ApiModelProperty("Storage type, support:HIVE")
    private String storageType;

    @ApiModelProperty("Storage cluster ID")
    private Integer clusterId;

    @ApiModelProperty("Storage cluster URL")
    private String clusterUrl;

}