/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.agent.core.plugin.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * Service supervisor.
 */
@Slf4j
@RequiredArgsConstructor
public final class ServiceSupervisor {
    
    private final List<BootService> bootServices;
    
    /**
     * Set up services.
     */
    public void setUpAllServices() {
        bootServices.forEach(each -> {
            try {
                each.setup();
                // CHECKSTYLE:OFF
            } catch (final Throwable ex) {
                // CHECKSTYLE:ON
                log.error("Failed to initial service.", ex);
            }
        });
    }
    
    /**
     * Start all services.
     */
    public void startAllServices() {
        bootServices.forEach(each -> {
            try {
                each.start();
                // CHECKSTYLE:OFF
            } catch (final Throwable ex) {
                // CHECKSTYLE:ON
                log.error("Failed to start service.", ex);
            }
        });
    }
    
    /**
     * Clean up all services.
     */
    public void cleanUpAllServices() {
        bootServices.forEach(each -> {
            try {
                each.cleanup();
                // CHECKSTYLE:OFF
            } catch (final Throwable ex) {
                // CHECKSTYLE:ON
                log.error("Failed to shutdown service.", ex);
            }
        });
    }
}
