// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: transport/internet/domainsocket/config.proto

package com.xray.transport.internet.domainsocket;

public interface ConfigOrBuilder extends
    // @@protoc_insertion_point(interface_extends:xray.transport.internet.domainsocket.Config)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Path of the domain socket. This overrides the IP/Port parameter from
   * upstream caller.
   * </pre>
   *
   * <code>string path = 1;</code>
   */
  java.lang.String getPath();
  /**
   * <pre>
   * Path of the domain socket. This overrides the IP/Port parameter from
   * upstream caller.
   * </pre>
   *
   * <code>string path = 1;</code>
   */
  com.google.protobuf.ByteString
      getPathBytes();

  /**
   * <pre>
   * Abstract speicifies whether to use abstract namespace or not.
   * Traditionally Unix domain socket is file system based. Abstract domain
   * socket can be used without acquiring file lock.
   * </pre>
   *
   * <code>bool abstract = 2;</code>
   */
  boolean getAbstract();

  /**
   * <pre>
   * Some apps, eg. haproxy, use the full length of sockaddr_un.sun_path to
   * connect(2) or bind(2) when using abstract UDS.
   * </pre>
   *
   * <code>bool padding = 3;</code>
   */
  boolean getPadding();
}
