// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: app/observatory/config.proto

package com.xray.app.observatory;

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
    internal_static_xray_core_app_observatory_ObservationResult_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_xray_core_app_observatory_ObservationResult_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_xray_core_app_observatory_OutboundStatus_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_xray_core_app_observatory_OutboundStatus_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_xray_core_app_observatory_ProbeResult_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_xray_core_app_observatory_ProbeResult_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_xray_core_app_observatory_Intensity_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_xray_core_app_observatory_Intensity_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_xray_core_app_observatory_Config_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_xray_core_app_observatory_Config_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\034app/observatory/config.proto\022\031xray.cor" +
      "e.app.observatory\"N\n\021ObservationResult\0229" +
      "\n\006status\030\001 \003(\0132).xray.core.app.observato" +
      "ry.OutboundStatus\"\216\001\n\016OutboundStatus\022\r\n\005" +
      "alive\030\001 \001(\010\022\r\n\005delay\030\002 \001(\003\022\031\n\021last_error" +
      "_reason\030\003 \001(\t\022\024\n\014outbound_tag\030\004 \001(\t\022\026\n\016l" +
      "ast_seen_time\030\005 \001(\003\022\025\n\rlast_try_time\030\006 \001" +
      "(\003\"F\n\013ProbeResult\022\r\n\005alive\030\001 \001(\010\022\r\n\005dela" +
      "y\030\002 \001(\003\022\031\n\021last_error_reason\030\003 \001(\t\"#\n\tIn" +
      "tensity\022\026\n\016probe_interval\030\001 \001(\r\"i\n\006Confi" +
      "g\022\030\n\020subject_selector\030\002 \003(\t\022\021\n\tprobe_url" +
      "\030\003 \001(\t\022\026\n\016probe_interval\030\004 \001(\003\022\032\n\022enable" +
      "_concurrency\030\005 \001(\010B^\n\030com.xray.app.obser" +
      "vatoryP\001Z)github.com/xtls/xray-core/app/" +
      "observatory\252\002\024Xray.App.Observatoryb\006prot" +
      "o3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_xray_core_app_observatory_ObservationResult_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_xray_core_app_observatory_ObservationResult_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_xray_core_app_observatory_ObservationResult_descriptor,
        new java.lang.String[] { "Status", });
    internal_static_xray_core_app_observatory_OutboundStatus_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_xray_core_app_observatory_OutboundStatus_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_xray_core_app_observatory_OutboundStatus_descriptor,
        new java.lang.String[] { "Alive", "Delay", "LastErrorReason", "OutboundTag", "LastSeenTime", "LastTryTime", });
    internal_static_xray_core_app_observatory_ProbeResult_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_xray_core_app_observatory_ProbeResult_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_xray_core_app_observatory_ProbeResult_descriptor,
        new java.lang.String[] { "Alive", "Delay", "LastErrorReason", });
    internal_static_xray_core_app_observatory_Intensity_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_xray_core_app_observatory_Intensity_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_xray_core_app_observatory_Intensity_descriptor,
        new java.lang.String[] { "ProbeInterval", });
    internal_static_xray_core_app_observatory_Config_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_xray_core_app_observatory_Config_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_xray_core_app_observatory_Config_descriptor,
        new java.lang.String[] { "SubjectSelector", "ProbeUrl", "ProbeInterval", "EnableConcurrency", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
