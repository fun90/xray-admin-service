// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proxy/vmess/inbound/config.proto

package com.xray.proxy.vmess.inbound;

public final class ConfigOuterClass {
  private ConfigOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_xray_proxy_vmess_inbound_DetourConfig_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_xray_proxy_vmess_inbound_DetourConfig_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_xray_proxy_vmess_inbound_DefaultConfig_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_xray_proxy_vmess_inbound_DefaultConfig_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_xray_proxy_vmess_inbound_Config_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_xray_proxy_vmess_inbound_Config_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n proxy/vmess/inbound/config.proto\022\030xray" +
      ".proxy.vmess.inbound\032\032common/protocol/us" +
      "er.proto\"\032\n\014DetourConfig\022\n\n\002to\030\001 \001(\t\"\036\n\r" +
      "DefaultConfig\022\r\n\005level\030\002 \001(\r\"\244\001\n\006Config\022" +
      "(\n\004user\030\001 \003(\0132\032.xray.common.protocol.Use" +
      "r\0228\n\007default\030\002 \001(\0132\'.xray.proxy.vmess.in" +
      "bound.DefaultConfig\0226\n\006detour\030\003 \001(\0132&.xr" +
      "ay.proxy.vmess.inbound.DetourConfigBj\n\034c" +
      "om.xray.proxy.vmess.inboundP\001Z-github.co" +
      "m/xtls/xray-core/proxy/vmess/inbound\252\002\030X" +
      "ray.Proxy.Vmess.Inboundb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.xray.common.protocol.UserOuterClass.getDescriptor(),
        });
    internal_static_xray_proxy_vmess_inbound_DetourConfig_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_xray_proxy_vmess_inbound_DetourConfig_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_xray_proxy_vmess_inbound_DetourConfig_descriptor,
        new java.lang.String[] { "To", });
    internal_static_xray_proxy_vmess_inbound_DefaultConfig_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_xray_proxy_vmess_inbound_DefaultConfig_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_xray_proxy_vmess_inbound_DefaultConfig_descriptor,
        new java.lang.String[] { "Level", });
    internal_static_xray_proxy_vmess_inbound_Config_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_xray_proxy_vmess_inbound_Config_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_xray_proxy_vmess_inbound_Config_descriptor,
        new java.lang.String[] { "User", "Default", "Detour", });
    com.xray.common.protocol.UserOuterClass.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
