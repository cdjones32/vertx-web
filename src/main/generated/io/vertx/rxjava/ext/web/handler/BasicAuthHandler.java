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

package io.vertx.rxjava.ext.web.handler;

import java.util.Map;
import io.vertx.lang.rxjava.InternalHelper;
import rx.Observable;
import java.util.Set;
import io.vertx.rxjava.ext.web.RoutingContext;
import io.vertx.rxjava.ext.auth.AuthProvider;

/**
 * An auth handler that provides HTTP Basic Authentication support.
 *
 * <p/>
 * NOTE: This class has been automatically generated from the {@link io.vertx.ext.web.handler.BasicAuthHandler original} non RX-ified interface using Vert.x codegen.
 */

public class BasicAuthHandler implements AuthHandler {

  final io.vertx.ext.web.handler.BasicAuthHandler delegate;

  public BasicAuthHandler(io.vertx.ext.web.handler.BasicAuthHandler delegate) {
    this.delegate = delegate;
  }

  public Object getDelegate() {
    return delegate;
  }

  public void handle(RoutingContext arg0) { 
    this.delegate.handle((io.vertx.ext.web.RoutingContext) arg0.getDelegate());
  }

  /**
   * Add a required authority for this auth handler
   * @param authority the authority
   * @return a reference to this, so the API can be used fluently
   */
  public AuthHandler addAuthority(String authority) { 
    this.delegate.addAuthority(authority);
    return this;
  }

  /**
   * Add a set of required authorities for this auth handler
   * @param authorities the set of authorities
   * @return a reference to this, so the API can be used fluently
   */
  public AuthHandler addAuthorities(Set<String> authorities) { 
    this.delegate.addAuthorities(authorities);
    return this;
  }

  /**
   * Create a basic auth handler
   * @param authProvider the auth provider to use
   * @return the auth handler
   */
  public static AuthHandler create(AuthProvider authProvider) { 
    AuthHandler ret= AuthHandler.newInstance(io.vertx.ext.web.handler.BasicAuthHandler.create((io.vertx.ext.auth.AuthProvider) authProvider.getDelegate()));
    return ret;
  }

  /**
   * Create a basic auth handler, specifying realm
   * @param authProvider the auth service to use
   * @param realm the realm to use
   * @return the auth handler
   */
  public static AuthHandler create(AuthProvider authProvider, String realm) { 
    AuthHandler ret= AuthHandler.newInstance(io.vertx.ext.web.handler.BasicAuthHandler.create((io.vertx.ext.auth.AuthProvider) authProvider.getDelegate(), realm));
    return ret;
  }


  public static BasicAuthHandler newInstance(io.vertx.ext.web.handler.BasicAuthHandler arg) {
    return arg != null ? new BasicAuthHandler(arg) : null;
  }
}
