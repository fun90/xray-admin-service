// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proxy/vless/outbound/config.proto

package com.xray.proxy.vless.outbound;

public interface ConfigOrBuilder extends
    // @@protoc_insertion_point(interface_extends:xray.proxy.vless.outbound.Config)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .xray.common.protocol.ServerEndpoint vnext = 1;</code>
   */
  java.util.List<com.xray.common.protocol.ServerEndpoint> 
      getVnextList();
  /**
   * <code>repeated .xray.common.protocol.ServerEndpoint vnext = 1;</code>
   */
  com.xray.common.protocol.ServerEndpoint getVnext(int index);
  /**
   * <code>repeated .xray.common.protocol.ServerEndpoint vnext = 1;</code>
   */
  int getVnextCount();
  /**
   * <code>repeated .xray.common.protocol.ServerEndpoint vnext = 1;</code>
   */
  java.util.List<? extends com.xray.common.protocol.ServerEndpointOrBuilder> 
      getVnextOrBuilderList();
  /**
   * <code>repeated .xray.common.protocol.ServerEndpoint vnext = 1;</code>
   */
  com.xray.common.protocol.ServerEndpointOrBuilder getVnextOrBuilder(
      int index);
}
