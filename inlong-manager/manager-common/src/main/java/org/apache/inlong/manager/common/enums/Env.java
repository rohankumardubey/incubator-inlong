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

package org.apache.inlong.manager.common.enums;

import com.google.common.collect.Lists;
import java.util.Map;
import java.util.function.Function;
import org.apache.commons.lang3.StringUtils;
import org.apache.inlong.manager.common.util.InLongCollectionUtils;

/**
 * Env info
 *
 */
public enum Env {
    /**
     * Development env
     */
    DEV,

    /**
     * Test env
     */
    TEST,

    /**
     * Production env
     */
    PROD;

    private static final Map<String, Env> NAME_MAP = InLongCollectionUtils.transformToImmutableMap(
            Lists.newArrayList(Env.values()),
            Env::name,
            Function.identity()
    );

    public static Env forName(String name) {
        String nameUpper = StringUtils.upperCase(name);
        if (!NAME_MAP.containsKey(nameUpper)) {
            throw new IllegalArgumentException("Env type not support");
        }

        return NAME_MAP.get(nameUpper);
    }

}
