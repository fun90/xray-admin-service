// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: common/net/port.proto

package com.xray.common.net;

public interface PortListOrBuilder extends
    // @@protoc_insertion_point(interface_extends:xray.common.net.PortList)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .xray.common.net.PortRange range = 1;</code>
   */
  java.util.List<com.xray.common.net.PortRange> 
      getRangeList();
  /**
   * <code>repeated .xray.common.net.PortRange range = 1;</code>
   */
  com.xray.common.net.PortRange getRange(int index);
  /**
   * <code>repeated .xray.common.net.PortRange range = 1;</code>
   */
  int getRangeCount();
  /**
   * <code>repeated .xray.common.net.PortRange range = 1;</code>
   */
  java.util.List<? extends com.xray.common.net.PortRangeOrBuilder> 
      getRangeOrBuilderList();
  /**
   * <code>repeated .xray.common.net.PortRange range = 1;</code>
   */
  com.xray.common.net.PortRangeOrBuilder getRangeOrBuilder(
      int index);
}
