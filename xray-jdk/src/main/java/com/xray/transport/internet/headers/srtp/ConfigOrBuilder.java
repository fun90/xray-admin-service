// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: transport/internet/headers/srtp/config.proto

package com.xray.transport.internet.headers.srtp;

public interface ConfigOrBuilder extends
    // @@protoc_insertion_point(interface_extends:xray.transport.internet.headers.srtp.Config)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>uint32 version = 1;</code>
   * @return The version.
   */
  int getVersion();

  /**
   * <code>bool padding = 2;</code>
   * @return The padding.
   */
  boolean getPadding();

  /**
   * <code>bool extension = 3;</code>
   * @return The extension.
   */
  boolean getExtension();

  /**
   * <code>uint32 csrc_count = 4;</code>
   * @return The csrcCount.
   */
  int getCsrcCount();

  /**
   * <code>bool marker = 5;</code>
   * @return The marker.
   */
  boolean getMarker();

  /**
   * <code>uint32 payload_type = 6;</code>
   * @return The payloadType.
   */
  int getPayloadType();
}
