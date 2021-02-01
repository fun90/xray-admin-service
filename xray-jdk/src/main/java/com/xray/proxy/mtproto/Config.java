// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proxy/mtproto/config.proto

package com.xray.proxy.mtproto;

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
    internal_static_xray_proxy_mtproto_Account_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_xray_proxy_mtproto_Account_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_xray_proxy_mtproto_ServerConfig_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_xray_proxy_mtproto_ServerConfig_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_xray_proxy_mtproto_ClientConfig_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_xray_proxy_mtproto_ClientConfig_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\032proxy/mtproto/config.proto\022\022xray.proxy" +
      ".mtproto\032\032common/protocol/user.proto\"\031\n\007" +
      "Account\022\016\n\006secret\030\001 \001(\014\"8\n\014ServerConfig\022" +
      "(\n\004user\030\001 \003(\0132\032.xray.common.protocol.Use" +
      "r\"\016\n\014ClientConfigBX\n\026com.xray.proxy.mtpr" +
      "otoP\001Z\'github.com/xtls/xray-core/proxy/m" +
      "tproto\252\002\022Xray.Proxy.Mtprotob\006proto3"
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
          com.xray.common.protocol.UserOuterClass.getDescriptor(),
        }, assigner);
    internal_static_xray_proxy_mtproto_Account_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_xray_proxy_mtproto_Account_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_xray_proxy_mtproto_Account_descriptor,
        new java.lang.String[] { "Secret", });
    internal_static_xray_proxy_mtproto_ServerConfig_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_xray_proxy_mtproto_ServerConfig_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_xray_proxy_mtproto_ServerConfig_descriptor,
        new java.lang.String[] { "User", });
    internal_static_xray_proxy_mtproto_ClientConfig_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_xray_proxy_mtproto_ClientConfig_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_xray_proxy_mtproto_ClientConfig_descriptor,
        new java.lang.String[] { });
    com.xray.common.protocol.UserOuterClass.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
