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

import org.apache.inlong.manager.common.event.process.ProcessEventNotifier;
import org.apache.inlong.manager.common.event.task.TaskEventNotifier;

/**
 * Workflow event notifier
 */
public class WorkflowEventNotifier {

    private ProcessEventNotifier processEventNotifier;

    private TaskEventNotifier taskEventNotifier;

    public WorkflowEventNotifier(WorkflowEventListenerManager workflowEventListenerManager) {
        taskEventNotifier = new TaskEventNotifier(workflowEventListenerManager.getTaskEventListenerManager());
        processEventNotifier = new ProcessEventNotifier(workflowEventListenerManager.getProcessEventListenerManager());
    }

    public ProcessEventNotifier getProcessEventNotifier() {
        return processEventNotifier;
    }

    public TaskEventNotifier getTaskEventNotifier() {
        return taskEventNotifier;
    }
}
