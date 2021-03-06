// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: app/proxyman/config.proto

package com.xray.app.proxyman;

public interface AllocationStrategyOrBuilder extends
    // @@protoc_insertion_point(interface_extends:xray.app.proxyman.AllocationStrategy)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.xray.app.proxyman.AllocationStrategy.Type type = 1;</code>
   */
  int getTypeValue();
  /**
   * <code>.xray.app.proxyman.AllocationStrategy.Type type = 1;</code>
   */
  com.xray.app.proxyman.AllocationStrategy.Type getType();

  /**
   * <pre>
   * Number of handlers (ports) running in parallel.
   * Default value is 3 if unset.
   * </pre>
   *
   * <code>.xray.app.proxyman.AllocationStrategy.AllocationStrategyConcurrency concurrency = 2;</code>
   */
  boolean hasConcurrency();
  /**
   * <pre>
   * Number of handlers (ports) running in parallel.
   * Default value is 3 if unset.
   * </pre>
   *
   * <code>.xray.app.proxyman.AllocationStrategy.AllocationStrategyConcurrency concurrency = 2;</code>
   */
  com.xray.app.proxyman.AllocationStrategy.AllocationStrategyConcurrency getConcurrency();
  /**
   * <pre>
   * Number of handlers (ports) running in parallel.
   * Default value is 3 if unset.
   * </pre>
   *
   * <code>.xray.app.proxyman.AllocationStrategy.AllocationStrategyConcurrency concurrency = 2;</code>
   */
  com.xray.app.proxyman.AllocationStrategy.AllocationStrategyConcurrencyOrBuilder getConcurrencyOrBuilder();

  /**
   * <pre>
   * Number of minutes before a handler is regenerated.
   * Default value is 5 if unset.
   * </pre>
   *
   * <code>.xray.app.proxyman.AllocationStrategy.AllocationStrategyRefresh refresh = 3;</code>
   */
  boolean hasRefresh();
  /**
   * <pre>
   * Number of minutes before a handler is regenerated.
   * Default value is 5 if unset.
   * </pre>
   *
   * <code>.xray.app.proxyman.AllocationStrategy.AllocationStrategyRefresh refresh = 3;</code>
   */
  com.xray.app.proxyman.AllocationStrategy.AllocationStrategyRefresh getRefresh();
  /**
   * <pre>
   * Number of minutes before a handler is regenerated.
   * Default value is 5 if unset.
   * </pre>
   *
   * <code>.xray.app.proxyman.AllocationStrategy.AllocationStrategyRefresh refresh = 3;</code>
   */
  com.xray.app.proxyman.AllocationStrategy.AllocationStrategyRefreshOrBuilder getRefreshOrBuilder();
}
