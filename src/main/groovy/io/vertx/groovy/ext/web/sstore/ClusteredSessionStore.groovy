/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package io.vertx.groovy.ext.web.sstore;
import groovy.transform.CompileStatic
import io.vertx.lang.groovy.InternalHelper
import io.vertx.groovy.core.Vertx
/**
 * A session store which stores sessions in a distributed map so they are available across the cluster.
*/
@CompileStatic
public class ClusteredSessionStore extends SessionStore {
  private final def io.vertx.ext.web.sstore.ClusteredSessionStore delegate;
  public ClusteredSessionStore(Object delegate) {
    super((io.vertx.ext.web.sstore.ClusteredSessionStore) delegate);
    this.delegate = (io.vertx.ext.web.sstore.ClusteredSessionStore) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  /**
   * Create a session store
   * @param vertx the Vert.x instance
   * @param sessionMapName the session map name
   * @return the session store
   */
  public static ClusteredSessionStore create(Vertx vertx, String sessionMapName) {
    def ret= InternalHelper.safeCreate(io.vertx.ext.web.sstore.ClusteredSessionStore.create((io.vertx.core.Vertx)vertx.getDelegate(), sessionMapName), io.vertx.groovy.ext.web.sstore.ClusteredSessionStore.class);
    return ret;
  }
  /**
   * Create a session store
   * @param vertx the Vert.x instance
   * @return the session store
   */
  public static ClusteredSessionStore create(Vertx vertx) {
    def ret= InternalHelper.safeCreate(io.vertx.ext.web.sstore.ClusteredSessionStore.create((io.vertx.core.Vertx)vertx.getDelegate()), io.vertx.groovy.ext.web.sstore.ClusteredSessionStore.class);
    return ret;
  }
}
