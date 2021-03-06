// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proxy/shadowsocks/config.proto

package com.xray.proxy.shadowsocks;

public final class Config {
  private Config() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_xray_proxy_shadowsocks_Account_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_xray_proxy_shadowsocks_Account_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_xray_proxy_shadowsocks_ServerConfig_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_xray_proxy_shadowsocks_ServerConfig_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_xray_proxy_shadowsocks_ClientConfig_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_xray_proxy_shadowsocks_ClientConfig_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\036proxy/shadowsocks/config.proto\022\026xray.p" +
      "roxy.shadowsocks\032\030common/net/network.pro" +
      "to\032\032common/protocol/user.proto\032!common/p" +
      "rotocol/server_spec.proto\"T\n\007Account\022\020\n\010" +
      "password\030\001 \001(\t\0227\n\013cipher_type\030\002 \001(\0162\".xr" +
      "ay.proxy.shadowsocks.CipherType\"d\n\014Serve" +
      "rConfig\022)\n\005users\030\001 \003(\0132\032.xray.common.pro" +
      "tocol.User\022)\n\007network\030\002 \003(\0162\030.xray.commo" +
      "n.net.Network\"D\n\014ClientConfig\0224\n\006server\030" +
      "\001 \003(\0132$.xray.common.protocol.ServerEndpo" +
      "int*\237\001\n\nCipherType\022\013\n\007UNKNOWN\020\000\022\017\n\013AES_1" +
      "28_CFB\020\001\022\017\n\013AES_256_CFB\020\002\022\014\n\010CHACHA20\020\003\022" +
      "\021\n\rCHACHA20_IETF\020\004\022\017\n\013AES_128_GCM\020\005\022\017\n\013A" +
      "ES_256_GCM\020\006\022\025\n\021CHACHA20_POLY1305\020\007\022\010\n\004N" +
      "ONE\020\010Bd\n\032com.xray.proxy.shadowsocksP\001Z+g" +
      "ithub.com/xtls/xray-core/proxy/shadowsoc" +
      "ks\252\002\026Xray.Proxy.Shadowsocksb\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.xray.common.net.NetworkOuterClass.getDescriptor(),
          com.xray.common.protocol.UserOuterClass.getDescriptor(),
          com.xray.common.protocol.ServerSpec.getDescriptor(),
        }, assigner);
    internal_static_xray_proxy_shadowsocks_Account_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_xray_proxy_shadowsocks_Account_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_xray_proxy_shadowsocks_Account_descriptor,
        new java.lang.String[] { "Password", "CipherType", });
    internal_static_xray_proxy_shadowsocks_ServerConfig_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_xray_proxy_shadowsocks_ServerConfig_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_xray_proxy_shadowsocks_ServerConfig_descriptor,
        new java.lang.String[] { "Users", "Network", });
    internal_static_xray_proxy_shadowsocks_ClientConfig_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_xray_proxy_shadowsocks_ClientConfig_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_xray_proxy_shadowsocks_ClientConfig_descriptor,
        new java.lang.String[] { "Server", });
    com.xray.common.net.NetworkOuterClass.getDescriptor();
    com.xray.common.protocol.UserOuterClass.getDescriptor();
    com.xray.common.protocol.ServerSpec.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
