// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: app/proxyman/config.proto

package com.xray.app.proxyman;

public interface InboundHandlerConfigOrBuilder extends
    // @@protoc_insertion_point(interface_extends:xray.app.proxyman.InboundHandlerConfig)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string tag = 1;</code>
   */
  java.lang.String getTag();
  /**
   * <code>string tag = 1;</code>
   */
  com.google.protobuf.ByteString
      getTagBytes();

  /**
   * <code>.xray.common.serial.TypedMessage receiver_settings = 2;</code>
   */
  boolean hasReceiverSettings();
  /**
   * <code>.xray.common.serial.TypedMessage receiver_settings = 2;</code>
   */
  com.xray.common.serial.TypedMessage getReceiverSettings();
  /**
   * <code>.xray.common.serial.TypedMessage receiver_settings = 2;</code>
   */
  com.xray.common.serial.TypedMessageOrBuilder getReceiverSettingsOrBuilder();

  /**
   * <code>.xray.common.serial.TypedMessage proxy_settings = 3;</code>
   */
  boolean hasProxySettings();
  /**
   * <code>.xray.common.serial.TypedMessage proxy_settings = 3;</code>
   */
  com.xray.common.serial.TypedMessage getProxySettings();
  /**
   * <code>.xray.common.serial.TypedMessage proxy_settings = 3;</code>
   */
  com.xray.common.serial.TypedMessageOrBuilder getProxySettingsOrBuilder();
}
