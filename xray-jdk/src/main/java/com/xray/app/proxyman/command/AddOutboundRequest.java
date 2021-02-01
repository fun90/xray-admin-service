// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: app/proxyman/command/command.proto

package com.xray.app.proxyman.command;

/**
 * Protobuf type {@code xray.app.proxyman.command.AddOutboundRequest}
 */
public  final class AddOutboundRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:xray.app.proxyman.command.AddOutboundRequest)
    AddOutboundRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use AddOutboundRequest.newBuilder() to construct.
  private AddOutboundRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private AddOutboundRequest() {
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private AddOutboundRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            com.xray.core.OutboundHandlerConfig.Builder subBuilder = null;
            if (outbound_ != null) {
              subBuilder = outbound_.toBuilder();
            }
            outbound_ = input.readMessage(com.xray.core.OutboundHandlerConfig.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(outbound_);
              outbound_ = subBuilder.buildPartial();
            }

            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.xray.app.proxyman.command.Command.internal_static_xray_app_proxyman_command_AddOutboundRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.xray.app.proxyman.command.Command.internal_static_xray_app_proxyman_command_AddOutboundRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.xray.app.proxyman.command.AddOutboundRequest.class, com.xray.app.proxyman.command.AddOutboundRequest.Builder.class);
  }

  public static final int OUTBOUND_FIELD_NUMBER = 1;
  private com.xray.core.OutboundHandlerConfig outbound_;
  /**
   * <code>.xray.core.OutboundHandlerConfig outbound = 1;</code>
   */
  public boolean hasOutbound() {
    return outbound_ != null;
  }
  /**
   * <code>.xray.core.OutboundHandlerConfig outbound = 1;</code>
   */
  public com.xray.core.OutboundHandlerConfig getOutbound() {
    return outbound_ == null ? com.xray.core.OutboundHandlerConfig.getDefaultInstance() : outbound_;
  }
  /**
   * <code>.xray.core.OutboundHandlerConfig outbound = 1;</code>
   */
  public com.xray.core.OutboundHandlerConfigOrBuilder getOutboundOrBuilder() {
    return getOutbound();
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (outbound_ != null) {
      output.writeMessage(1, getOutbound());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (outbound_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getOutbound());
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.xray.app.proxyman.command.AddOutboundRequest)) {
      return super.equals(obj);
    }
    com.xray.app.proxyman.command.AddOutboundRequest other = (com.xray.app.proxyman.command.AddOutboundRequest) obj;

    if (hasOutbound() != other.hasOutbound()) return false;
    if (hasOutbound()) {
      if (!getOutbound()
          .equals(other.getOutbound())) return false;
    }
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasOutbound()) {
      hash = (37 * hash) + OUTBOUND_FIELD_NUMBER;
      hash = (53 * hash) + getOutbound().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.xray.app.proxyman.command.AddOutboundRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.xray.app.proxyman.command.AddOutboundRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.xray.app.proxyman.command.AddOutboundRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.xray.app.proxyman.command.AddOutboundRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.xray.app.proxyman.command.AddOutboundRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.xray.app.proxyman.command.AddOutboundRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.xray.app.proxyman.command.AddOutboundRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.xray.app.proxyman.command.AddOutboundRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.xray.app.proxyman.command.AddOutboundRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.xray.app.proxyman.command.AddOutboundRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.xray.app.proxyman.command.AddOutboundRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.xray.app.proxyman.command.AddOutboundRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.xray.app.proxyman.command.AddOutboundRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code xray.app.proxyman.command.AddOutboundRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:xray.app.proxyman.command.AddOutboundRequest)
      com.xray.app.proxyman.command.AddOutboundRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.xray.app.proxyman.command.Command.internal_static_xray_app_proxyman_command_AddOutboundRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.xray.app.proxyman.command.Command.internal_static_xray_app_proxyman_command_AddOutboundRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.xray.app.proxyman.command.AddOutboundRequest.class, com.xray.app.proxyman.command.AddOutboundRequest.Builder.class);
    }

    // Construct using com.xray.app.proxyman.command.AddOutboundRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (outboundBuilder_ == null) {
        outbound_ = null;
      } else {
        outbound_ = null;
        outboundBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.xray.app.proxyman.command.Command.internal_static_xray_app_proxyman_command_AddOutboundRequest_descriptor;
    }

    @java.lang.Override
    public com.xray.app.proxyman.command.AddOutboundRequest getDefaultInstanceForType() {
      return com.xray.app.proxyman.command.AddOutboundRequest.getDefaultInstance();
    }

    @java.lang.Override
    public com.xray.app.proxyman.command.AddOutboundRequest build() {
      com.xray.app.proxyman.command.AddOutboundRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.xray.app.proxyman.command.AddOutboundRequest buildPartial() {
      com.xray.app.proxyman.command.AddOutboundRequest result = new com.xray.app.proxyman.command.AddOutboundRequest(this);
      if (outboundBuilder_ == null) {
        result.outbound_ = outbound_;
      } else {
        result.outbound_ = outboundBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.xray.app.proxyman.command.AddOutboundRequest) {
        return mergeFrom((com.xray.app.proxyman.command.AddOutboundRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.xray.app.proxyman.command.AddOutboundRequest other) {
      if (other == com.xray.app.proxyman.command.AddOutboundRequest.getDefaultInstance()) return this;
      if (other.hasOutbound()) {
        mergeOutbound(other.getOutbound());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.xray.app.proxyman.command.AddOutboundRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.xray.app.proxyman.command.AddOutboundRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private com.xray.core.OutboundHandlerConfig outbound_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.xray.core.OutboundHandlerConfig, com.xray.core.OutboundHandlerConfig.Builder, com.xray.core.OutboundHandlerConfigOrBuilder> outboundBuilder_;
    /**
     * <code>.xray.core.OutboundHandlerConfig outbound = 1;</code>
     */
    public boolean hasOutbound() {
      return outboundBuilder_ != null || outbound_ != null;
    }
    /**
     * <code>.xray.core.OutboundHandlerConfig outbound = 1;</code>
     */
    public com.xray.core.OutboundHandlerConfig getOutbound() {
      if (outboundBuilder_ == null) {
        return outbound_ == null ? com.xray.core.OutboundHandlerConfig.getDefaultInstance() : outbound_;
      } else {
        return outboundBuilder_.getMessage();
      }
    }
    /**
     * <code>.xray.core.OutboundHandlerConfig outbound = 1;</code>
     */
    public Builder setOutbound(com.xray.core.OutboundHandlerConfig value) {
      if (outboundBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        outbound_ = value;
        onChanged();
      } else {
        outboundBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.xray.core.OutboundHandlerConfig outbound = 1;</code>
     */
    public Builder setOutbound(
        com.xray.core.OutboundHandlerConfig.Builder builderForValue) {
      if (outboundBuilder_ == null) {
        outbound_ = builderForValue.build();
        onChanged();
      } else {
        outboundBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.xray.core.OutboundHandlerConfig outbound = 1;</code>
     */
    public Builder mergeOutbound(com.xray.core.OutboundHandlerConfig value) {
      if (outboundBuilder_ == null) {
        if (outbound_ != null) {
          outbound_ =
            com.xray.core.OutboundHandlerConfig.newBuilder(outbound_).mergeFrom(value).buildPartial();
        } else {
          outbound_ = value;
        }
        onChanged();
      } else {
        outboundBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.xray.core.OutboundHandlerConfig outbound = 1;</code>
     */
    public Builder clearOutbound() {
      if (outboundBuilder_ == null) {
        outbound_ = null;
        onChanged();
      } else {
        outbound_ = null;
        outboundBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.xray.core.OutboundHandlerConfig outbound = 1;</code>
     */
    public com.xray.core.OutboundHandlerConfig.Builder getOutboundBuilder() {
      
      onChanged();
      return getOutboundFieldBuilder().getBuilder();
    }
    /**
     * <code>.xray.core.OutboundHandlerConfig outbound = 1;</code>
     */
    public com.xray.core.OutboundHandlerConfigOrBuilder getOutboundOrBuilder() {
      if (outboundBuilder_ != null) {
        return outboundBuilder_.getMessageOrBuilder();
      } else {
        return outbound_ == null ?
            com.xray.core.OutboundHandlerConfig.getDefaultInstance() : outbound_;
      }
    }
    /**
     * <code>.xray.core.OutboundHandlerConfig outbound = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.xray.core.OutboundHandlerConfig, com.xray.core.OutboundHandlerConfig.Builder, com.xray.core.OutboundHandlerConfigOrBuilder> 
        getOutboundFieldBuilder() {
      if (outboundBuilder_ == null) {
        outboundBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.xray.core.OutboundHandlerConfig, com.xray.core.OutboundHandlerConfig.Builder, com.xray.core.OutboundHandlerConfigOrBuilder>(
                getOutbound(),
                getParentForChildren(),
                isClean());
        outbound_ = null;
      }
      return outboundBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:xray.app.proxyman.command.AddOutboundRequest)
  }

  // @@protoc_insertion_point(class_scope:xray.app.proxyman.command.AddOutboundRequest)
  private static final com.xray.app.proxyman.command.AddOutboundRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.xray.app.proxyman.command.AddOutboundRequest();
  }

  public static com.xray.app.proxyman.command.AddOutboundRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<AddOutboundRequest>
      PARSER = new com.google.protobuf.AbstractParser<AddOutboundRequest>() {
    @java.lang.Override
    public AddOutboundRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new AddOutboundRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<AddOutboundRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<AddOutboundRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.xray.app.proxyman.command.AddOutboundRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

