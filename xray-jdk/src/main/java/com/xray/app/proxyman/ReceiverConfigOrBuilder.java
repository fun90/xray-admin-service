// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: app/proxyman/config.proto

package com.xray.app.proxyman;

public interface ReceiverConfigOrBuilder extends
    // @@protoc_insertion_point(interface_extends:xray.app.proxyman.ReceiverConfig)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * PortRange specifies the ports which the Receiver should listen on.
   * </pre>
   *
   * <code>.xray.common.net.PortRange port_range = 1;</code>
   */
  boolean hasPortRange();
  /**
   * <pre>
   * PortRange specifies the ports which the Receiver should listen on.
   * </pre>
   *
   * <code>.xray.common.net.PortRange port_range = 1;</code>
   */
  com.xray.common.net.PortRange getPortRange();
  /**
   * <pre>
   * PortRange specifies the ports which the Receiver should listen on.
   * </pre>
   *
   * <code>.xray.common.net.PortRange port_range = 1;</code>
   */
  com.xray.common.net.PortRangeOrBuilder getPortRangeOrBuilder();

  /**
   * <pre>
   * Listen specifies the IP address that the Receiver should listen on.
   * </pre>
   *
   * <code>.xray.common.net.IPOrDomain listen = 2;</code>
   */
  boolean hasListen();
  /**
   * <pre>
   * Listen specifies the IP address that the Receiver should listen on.
   * </pre>
   *
   * <code>.xray.common.net.IPOrDomain listen = 2;</code>
   */
  com.xray.common.net.IPOrDomain getListen();
  /**
   * <pre>
   * Listen specifies the IP address that the Receiver should listen on.
   * </pre>
   *
   * <code>.xray.common.net.IPOrDomain listen = 2;</code>
   */
  com.xray.common.net.IPOrDomainOrBuilder getListenOrBuilder();

  /**
   * <code>.xray.app.proxyman.AllocationStrategy allocation_strategy = 3;</code>
   */
  boolean hasAllocationStrategy();
  /**
   * <code>.xray.app.proxyman.AllocationStrategy allocation_strategy = 3;</code>
   */
  com.xray.app.proxyman.AllocationStrategy getAllocationStrategy();
  /**
   * <code>.xray.app.proxyman.AllocationStrategy allocation_strategy = 3;</code>
   */
  com.xray.app.proxyman.AllocationStrategyOrBuilder getAllocationStrategyOrBuilder();

  /**
   * <code>.xray.transport.internet.StreamConfig stream_settings = 4;</code>
   */
  boolean hasStreamSettings();
  /**
   * <code>.xray.transport.internet.StreamConfig stream_settings = 4;</code>
   */
  com.xray.transport.internet.StreamConfig getStreamSettings();
  /**
   * <code>.xray.transport.internet.StreamConfig stream_settings = 4;</code>
   */
  com.xray.transport.internet.StreamConfigOrBuilder getStreamSettingsOrBuilder();

  /**
   * <code>bool receive_original_destination = 5;</code>
   */
  boolean getReceiveOriginalDestination();

  /**
   * <pre>
   * Override domains for the given protocol.
   * Deprecated. Use sniffing_settings.
   * </pre>
   *
   * <code>repeated .xray.app.proxyman.KnownProtocols domain_override = 7 [deprecated = true];</code>
   */
  @java.lang.Deprecated java.util.List<com.xray.app.proxyman.KnownProtocols> getDomainOverrideList();
  /**
   * <pre>
   * Override domains for the given protocol.
   * Deprecated. Use sniffing_settings.
   * </pre>
   *
   * <code>repeated .xray.app.proxyman.KnownProtocols domain_override = 7 [deprecated = true];</code>
   */
  @java.lang.Deprecated int getDomainOverrideCount();
  /**
   * <pre>
   * Override domains for the given protocol.
   * Deprecated. Use sniffing_settings.
   * </pre>
   *
   * <code>repeated .xray.app.proxyman.KnownProtocols domain_override = 7 [deprecated = true];</code>
   */
  @java.lang.Deprecated com.xray.app.proxyman.KnownProtocols getDomainOverride(int index);
  /**
   * <pre>
   * Override domains for the given protocol.
   * Deprecated. Use sniffing_settings.
   * </pre>
   *
   * <code>repeated .xray.app.proxyman.KnownProtocols domain_override = 7 [deprecated = true];</code>
   */
  @java.lang.Deprecated java.util.List<java.lang.Integer>
  getDomainOverrideValueList();
  /**
   * <pre>
   * Override domains for the given protocol.
   * Deprecated. Use sniffing_settings.
   * </pre>
   *
   * <code>repeated .xray.app.proxyman.KnownProtocols domain_override = 7 [deprecated = true];</code>
   */
  @java.lang.Deprecated int getDomainOverrideValue(int index);

  /**
   * <code>.xray.app.proxyman.SniffingConfig sniffing_settings = 8;</code>
   */
  boolean hasSniffingSettings();
  /**
   * <code>.xray.app.proxyman.SniffingConfig sniffing_settings = 8;</code>
   */
  com.xray.app.proxyman.SniffingConfig getSniffingSettings();
  /**
   * <code>.xray.app.proxyman.SniffingConfig sniffing_settings = 8;</code>
   */
  com.xray.app.proxyman.SniffingConfigOrBuilder getSniffingSettingsOrBuilder();
}
