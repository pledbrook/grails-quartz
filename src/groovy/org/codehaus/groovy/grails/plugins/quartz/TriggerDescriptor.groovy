/*
 * Copyright 2004-2005 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.codehaus.groovy.grails.plugins.quartz

import org.quartz.Trigger
import org.quartz.Scheduler

/**
 * TriggerDescriptor that stores information about the Quartz trigger to show on webapp.
 *
 * @author Sergey Nebolsin (nebolsin@gmail.com)
 *
 * @since 1.0
 */
class TriggerDescriptor {
    JobDescriptor jobDescriptor
    
    Trigger trigger

    int state

    static build(JobDescriptor jobDescriptor, Trigger trigger, Scheduler scheduler) {
        def result = new TriggerDescriptor(jobDescriptor: jobDescriptor, trigger: trigger)
        result.state =  scheduler.getTriggerState(trigger.name, trigger.group)
        result
    }

    String getName() {
        trigger.name
    }

    String getGroup() {
        trigger.group
    }

}
