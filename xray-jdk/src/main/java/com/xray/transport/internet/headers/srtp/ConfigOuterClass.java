// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: transport/internet/headers/srtp/config.proto

package com.xray.transport.internet.headers.srtp;

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
    internal_static_xray_transport_internet_headers_srtp_Config_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_xray_transport_internet_headers_srtp_Config_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n,transport/internet/headers/srtp/config" +
      ".proto\022$xray.transport.internet.headers." +
      "srtp\"w\n\006Config\022\017\n\007version\030\001 \001(\r\022\017\n\007paddi" +
      "ng\030\002 \001(\010\022\021\n\textension\030\003 \001(\010\022\022\n\ncsrc_coun" +
      "t\030\004 \001(\r\022\016\n\006marker\030\005 \001(\010\022\024\n\014payload_type\030" +
      "\006 \001(\rB\216\001\n(com.xray.transport.internet.he" +
      "aders.srtpP\001Z9github.com/xtls/xray-core/" +
      "transport/internet/headers/srtp\252\002$Xray.T" +
      "ransport.Internet.Headers.Srtpb\006proto3"
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
    internal_static_xray_transport_internet_headers_srtp_Config_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_xray_transport_internet_headers_srtp_Config_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_xray_transport_internet_headers_srtp_Config_descriptor,
        new java.lang.String[] { "Version", "Padding", "Extension", "CsrcCount", "Marker", "PayloadType", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
