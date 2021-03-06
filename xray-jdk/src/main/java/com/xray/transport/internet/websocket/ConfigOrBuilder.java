// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: transport/internet/websocket/config.proto

package com.xray.transport.internet.websocket;

public interface ConfigOrBuilder extends
    // @@protoc_insertion_point(interface_extends:xray.transport.internet.websocket.Config)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * URL path to the WebSocket service. Empty value means root(/).
   * </pre>
   *
   * <code>string path = 2;</code>
   */
  java.lang.String getPath();
  /**
   * <pre>
   * URL path to the WebSocket service. Empty value means root(/).
   * </pre>
   *
   * <code>string path = 2;</code>
   */
  com.google.protobuf.ByteString
      getPathBytes();

  /**
   * <code>repeated .xray.transport.internet.websocket.Header header = 3;</code>
   */
  java.util.List<com.xray.transport.internet.websocket.Header> 
      getHeaderList();
  /**
   * <code>repeated .xray.transport.internet.websocket.Header header = 3;</code>
   */
  com.xray.transport.internet.websocket.Header getHeader(int index);
  /**
   * <code>repeated .xray.transport.internet.websocket.Header header = 3;</code>
   */
  int getHeaderCount();
  /**
   * <code>repeated .xray.transport.internet.websocket.Header header = 3;</code>
   */
  java.util.List<? extends com.xray.transport.internet.websocket.HeaderOrBuilder> 
      getHeaderOrBuilderList();
  /**
   * <code>repeated .xray.transport.internet.websocket.Header header = 3;</code>
   */
  com.xray.transport.internet.websocket.HeaderOrBuilder getHeaderOrBuilder(
      int index);

  /**
   * <code>bool accept_proxy_protocol = 4;</code>
   */
  boolean getAcceptProxyProtocol();
}
