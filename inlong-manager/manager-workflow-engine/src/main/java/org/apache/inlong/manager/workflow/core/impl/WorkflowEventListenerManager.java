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

package org.apache.inlong.manager.workflow.core.impl;

import org.apache.inlong.manager.common.event.process.ProcessEventListenerManager;
import org.apache.inlong.manager.common.event.task.TaskEventListenerManager;
import org.apache.inlong.manager.common.model.WorkflowConfig;

/**
 * Workflow event listener manager
 */
public class WorkflowEventListenerManager {

    private ProcessEventListenerManager processEventListenerManager;
    private TaskEventListenerManager taskEventListenerManager;

    public WorkflowEventListenerManager(WorkflowConfig workflowConfig) {
        processEventListenerManager = new ProcessEventListenerManager(workflowConfig.getWorkflowDataAccessor());
        taskEventListenerManager = new TaskEventListenerManager(workflowConfig.getWorkflowDataAccessor());
    }

    public ProcessEventListenerManager getProcessEventListenerManager() {
        return processEventListenerManager;
    }

    public TaskEventListenerManager getTaskEventListenerManager() {
        return taskEventListenerManager;
    }
}
