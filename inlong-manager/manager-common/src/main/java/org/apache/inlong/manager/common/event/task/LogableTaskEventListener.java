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

package org.apache.inlong.manager.common.event.task;

import org.apache.inlong.manager.common.event.LogableEventListener;
import org.apache.inlong.manager.common.dao.EventLogStorage;
import org.apache.inlong.manager.common.model.WorkflowContext;
import org.apache.inlong.manager.common.model.instance.EventLog;
import org.apache.inlong.manager.common.model.instance.TaskInstance;

/**
 * Listener of logable task event
 */
public class LogableTaskEventListener extends LogableEventListener<TaskEvent> implements TaskEventListener {

    public LogableTaskEventListener(TaskEventListener eventListener, EventLogStorage eventLogStorage) {
        super(eventListener, eventLogStorage);
    }

    @Override
    protected EventLog buildEventLog(WorkflowContext context) {
        EventLog eventLog = super.buildEventLog(context);
        eventLog.setTaskInstId(getTaskInstId(context));
        return eventLog;
    }

    private Integer getTaskInstId(WorkflowContext context) {
        if (TaskEvent.CREATE.equals(this.event())) {
            return context.getNewTaskInstances().stream()
                    .filter(taskInstance -> taskInstance.getName().equals(context.getCurrentElement().getName()))
                    .findFirst()
                    .map(TaskInstance::getId)
                    .orElse(null);
        }

        return context.getActionContext().getActionTaskInstance().getId();
    }
}
