package io.vertx.ext.web.impl;

import io.vertx.core.Handler;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.RoutingContext;

import java.util.Objects;

/**
 * Wraps a handler that would normally block and turn it into a non-blocking handler.
 * This is done by calling {@link io.vertx.core.Vertx#executeBlocking(Handler, Handler)} 
 * and wrapping the context to overload {@link io.vertx.ext.web.RoutingContext#next()} so that
 * the next handler is run on the original event loop
 * 
 * @author <a href="mailto:stephane.bastian.dev@gmail.com>Stéphane Bastian</a>
 *
 */
public class BlockingHandlerDecorator implements Handler<RoutingContext> {

  private boolean ordered;
  private final Handler<RoutingContext> decoratedHandler;
  
  public BlockingHandlerDecorator(Handler<RoutingContext> decoratedHandler, boolean ordered) {
    Objects.requireNonNull(decoratedHandler);
    this.decoratedHandler = decoratedHandler;
    this.ordered = ordered;
  }
  
  @Override
  public void handle(RoutingContext context) {
    Route currentRoute = context.currentRoute();
    context.vertx().executeBlocking(fut -> {
      decoratedHandler.handle(new RoutingContextDecorator(currentRoute, context));
      fut.complete();
    }, ordered, res -> {
      if (res.failed()) {
        // This means an exception was thrown from the blocking handler
        context.fail(res.cause());
      }
    });
  }

}
