// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: app/reverse/config.proto

package com.xray.proxy.reverse;

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
    internal_static_xray_app_reverse_Control_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_xray_app_reverse_Control_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_xray_app_reverse_BridgeConfig_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_xray_app_reverse_BridgeConfig_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_xray_app_reverse_PortalConfig_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_xray_app_reverse_PortalConfig_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_xray_app_reverse_Config_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_xray_app_reverse_Config_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\030app/reverse/config.proto\022\020xray.app.rev" +
      "erse\"i\n\007Control\022.\n\005state\030\001 \001(\0162\037.xray.ap" +
      "p.reverse.Control.State\022\016\n\006random\030c \001(\014\"" +
      "\036\n\005State\022\n\n\006ACTIVE\020\000\022\t\n\005DRAIN\020\001\"+\n\014Bridg" +
      "eConfig\022\013\n\003tag\030\001 \001(\t\022\016\n\006domain\030\002 \001(\t\"+\n\014" +
      "PortalConfig\022\013\n\003tag\030\001 \001(\t\022\016\n\006domain\030\002 \001(" +
      "\t\"v\n\006Config\0225\n\rbridge_config\030\001 \003(\0132\036.xra" +
      "y.app.reverse.BridgeConfig\0225\n\rportal_con" +
      "fig\030\002 \003(\0132\036.xray.app.reverse.PortalConfi" +
      "gBV\n\026com.xray.proxy.reverseP\001Z%github.co" +
      "m/xtls/xray-core/app/reverse\252\002\022Xray.Prox" +
      "y.Reverseb\006proto3"
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
        }, assigner);
    internal_static_xray_app_reverse_Control_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_xray_app_reverse_Control_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_xray_app_reverse_Control_descriptor,
        new java.lang.String[] { "State", "Random", });
    internal_static_xray_app_reverse_BridgeConfig_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_xray_app_reverse_BridgeConfig_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_xray_app_reverse_BridgeConfig_descriptor,
        new java.lang.String[] { "Tag", "Domain", });
    internal_static_xray_app_reverse_PortalConfig_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_xray_app_reverse_PortalConfig_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_xray_app_reverse_PortalConfig_descriptor,
        new java.lang.String[] { "Tag", "Domain", });
    internal_static_xray_app_reverse_Config_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_xray_app_reverse_Config_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_xray_app_reverse_Config_descriptor,
        new java.lang.String[] { "BridgeConfig", "PortalConfig", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
