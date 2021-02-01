// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: app/commander/config.proto

package com.xray.app.commander;

public interface ConfigOrBuilder extends
    // @@protoc_insertion_point(interface_extends:xray.app.commander.Config)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Tag of the outbound handler that handles grpc connections.
   * </pre>
   *
   * <code>string tag = 1;</code>
   */
  java.lang.String getTag();
  /**
   * <pre>
   * Tag of the outbound handler that handles grpc connections.
   * </pre>
   *
   * <code>string tag = 1;</code>
   */
  com.google.protobuf.ByteString
      getTagBytes();

  /**
   * <pre>
   * Services that supported by this server. All services must implement Service
   * interface.
   * </pre>
   *
   * <code>repeated .xray.common.serial.TypedMessage service = 2;</code>
   */
  java.util.List<com.xray.common.serial.TypedMessage> 
      getServiceList();
  /**
   * <pre>
   * Services that supported by this server. All services must implement Service
   * interface.
   * </pre>
   *
   * <code>repeated .xray.common.serial.TypedMessage service = 2;</code>
   */
  com.xray.common.serial.TypedMessage getService(int index);
  /**
   * <pre>
   * Services that supported by this server. All services must implement Service
   * interface.
   * </pre>
   *
   * <code>repeated .xray.common.serial.TypedMessage service = 2;</code>
   */
  int getServiceCount();
  /**
   * <pre>
   * Services that supported by this server. All services must implement Service
   * interface.
   * </pre>
   *
   * <code>repeated .xray.common.serial.TypedMessage service = 2;</code>
   */
  java.util.List<? extends com.xray.common.serial.TypedMessageOrBuilder> 
      getServiceOrBuilderList();
  /**
   * <pre>
   * Services that supported by this server. All services must implement Service
   * interface.
   * </pre>
   *
   * <code>repeated .xray.common.serial.TypedMessage service = 2;</code>
   */
  com.xray.common.serial.TypedMessageOrBuilder getServiceOrBuilder(
      int index);
}
