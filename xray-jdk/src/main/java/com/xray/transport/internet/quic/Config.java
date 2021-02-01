// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: transport/internet/quic/config.proto

package com.xray.transport.internet.quic;

/**
 * Protobuf type {@code xray.transport.internet.quic.Config}
 */
public  final class Config extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:xray.transport.internet.quic.Config)
    ConfigOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Config.newBuilder() to construct.
  private Config(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Config() {
    key_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Config(
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
            java.lang.String s = input.readStringRequireUtf8();

            key_ = s;
            break;
          }
          case 18: {
            com.xray.common.protocol.SecurityConfig.Builder subBuilder = null;
            if (security_ != null) {
              subBuilder = security_.toBuilder();
            }
            security_ = input.readMessage(com.xray.common.protocol.SecurityConfig.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(security_);
              security_ = subBuilder.buildPartial();
            }

            break;
          }
          case 26: {
            com.xray.common.serial.TypedMessage.Builder subBuilder = null;
            if (header_ != null) {
              subBuilder = header_.toBuilder();
            }
            header_ = input.readMessage(com.xray.common.serial.TypedMessage.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(header_);
              header_ = subBuilder.buildPartial();
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
    return com.xray.transport.internet.quic.ConfigOuterClass.internal_static_xray_transport_internet_quic_Config_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.xray.transport.internet.quic.ConfigOuterClass.internal_static_xray_transport_internet_quic_Config_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.xray.transport.internet.quic.Config.class, com.xray.transport.internet.quic.Config.Builder.class);
  }

  public static final int KEY_FIELD_NUMBER = 1;
  private volatile java.lang.Object key_;
  /**
   * <code>string key = 1;</code>
   */
  public java.lang.String getKey() {
    java.lang.Object ref = key_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      key_ = s;
      return s;
    }
  }
  /**
   * <code>string key = 1;</code>
   */
  public com.google.protobuf.ByteString
      getKeyBytes() {
    java.lang.Object ref = key_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      key_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int SECURITY_FIELD_NUMBER = 2;
  private com.xray.common.protocol.SecurityConfig security_;
  /**
   * <code>.xray.common.protocol.SecurityConfig security = 2;</code>
   */
  public boolean hasSecurity() {
    return security_ != null;
  }
  /**
   * <code>.xray.common.protocol.SecurityConfig security = 2;</code>
   */
  public com.xray.common.protocol.SecurityConfig getSecurity() {
    return security_ == null ? com.xray.common.protocol.SecurityConfig.getDefaultInstance() : security_;
  }
  /**
   * <code>.xray.common.protocol.SecurityConfig security = 2;</code>
   */
  public com.xray.common.protocol.SecurityConfigOrBuilder getSecurityOrBuilder() {
    return getSecurity();
  }

  public static final int HEADER_FIELD_NUMBER = 3;
  private com.xray.common.serial.TypedMessage header_;
  /**
   * <code>.xray.common.serial.TypedMessage header = 3;</code>
   */
  public boolean hasHeader() {
    return header_ != null;
  }
  /**
   * <code>.xray.common.serial.TypedMessage header = 3;</code>
   */
  public com.xray.common.serial.TypedMessage getHeader() {
    return header_ == null ? com.xray.common.serial.TypedMessage.getDefaultInstance() : header_;
  }
  /**
   * <code>.xray.common.serial.TypedMessage header = 3;</code>
   */
  public com.xray.common.serial.TypedMessageOrBuilder getHeaderOrBuilder() {
    return getHeader();
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
    if (!getKeyBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, key_);
    }
    if (security_ != null) {
      output.writeMessage(2, getSecurity());
    }
    if (header_ != null) {
      output.writeMessage(3, getHeader());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getKeyBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, key_);
    }
    if (security_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getSecurity());
    }
    if (header_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, getHeader());
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
    if (!(obj instanceof com.xray.transport.internet.quic.Config)) {
      return super.equals(obj);
    }
    com.xray.transport.internet.quic.Config other = (com.xray.transport.internet.quic.Config) obj;

    if (!getKey()
        .equals(other.getKey())) return false;
    if (hasSecurity() != other.hasSecurity()) return false;
    if (hasSecurity()) {
      if (!getSecurity()
          .equals(other.getSecurity())) return false;
    }
    if (hasHeader() != other.hasHeader()) return false;
    if (hasHeader()) {
      if (!getHeader()
          .equals(other.getHeader())) return false;
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
    hash = (37 * hash) + KEY_FIELD_NUMBER;
    hash = (53 * hash) + getKey().hashCode();
    if (hasSecurity()) {
      hash = (37 * hash) + SECURITY_FIELD_NUMBER;
      hash = (53 * hash) + getSecurity().hashCode();
    }
    if (hasHeader()) {
      hash = (37 * hash) + HEADER_FIELD_NUMBER;
      hash = (53 * hash) + getHeader().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.xray.transport.internet.quic.Config parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.xray.transport.internet.quic.Config parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.xray.transport.internet.quic.Config parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.xray.transport.internet.quic.Config parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.xray.transport.internet.quic.Config parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.xray.transport.internet.quic.Config parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.xray.transport.internet.quic.Config parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.xray.transport.internet.quic.Config parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.xray.transport.internet.quic.Config parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.xray.transport.internet.quic.Config parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.xray.transport.internet.quic.Config parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.xray.transport.internet.quic.Config parseFrom(
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
  public static Builder newBuilder(com.xray.transport.internet.quic.Config prototype) {
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
   * Protobuf type {@code xray.transport.internet.quic.Config}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:xray.transport.internet.quic.Config)
      com.xray.transport.internet.quic.ConfigOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.xray.transport.internet.quic.ConfigOuterClass.internal_static_xray_transport_internet_quic_Config_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.xray.transport.internet.quic.ConfigOuterClass.internal_static_xray_transport_internet_quic_Config_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.xray.transport.internet.quic.Config.class, com.xray.transport.internet.quic.Config.Builder.class);
    }

    // Construct using com.xray.transport.internet.quic.Config.newBuilder()
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
      key_ = "";

      if (securityBuilder_ == null) {
        security_ = null;
      } else {
        security_ = null;
        securityBuilder_ = null;
      }
      if (headerBuilder_ == null) {
        header_ = null;
      } else {
        header_ = null;
        headerBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.xray.transport.internet.quic.ConfigOuterClass.internal_static_xray_transport_internet_quic_Config_descriptor;
    }

    @java.lang.Override
    public com.xray.transport.internet.quic.Config getDefaultInstanceForType() {
      return com.xray.transport.internet.quic.Config.getDefaultInstance();
    }

    @java.lang.Override
    public com.xray.transport.internet.quic.Config build() {
      com.xray.transport.internet.quic.Config result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.xray.transport.internet.quic.Config buildPartial() {
      com.xray.transport.internet.quic.Config result = new com.xray.transport.internet.quic.Config(this);
      result.key_ = key_;
      if (securityBuilder_ == null) {
        result.security_ = security_;
      } else {
        result.security_ = securityBuilder_.build();
      }
      if (headerBuilder_ == null) {
        result.header_ = header_;
      } else {
        result.header_ = headerBuilder_.build();
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
      if (other instanceof com.xray.transport.internet.quic.Config) {
        return mergeFrom((com.xray.transport.internet.quic.Config)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.xray.transport.internet.quic.Config other) {
      if (other == com.xray.transport.internet.quic.Config.getDefaultInstance()) return this;
      if (!other.getKey().isEmpty()) {
        key_ = other.key_;
        onChanged();
      }
      if (other.hasSecurity()) {
        mergeSecurity(other.getSecurity());
      }
      if (other.hasHeader()) {
        mergeHeader(other.getHeader());
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
      com.xray.transport.internet.quic.Config parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.xray.transport.internet.quic.Config) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object key_ = "";
    /**
     * <code>string key = 1;</code>
     */
    public java.lang.String getKey() {
      java.lang.Object ref = key_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        key_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string key = 1;</code>
     */
    public com.google.protobuf.ByteString
        getKeyBytes() {
      java.lang.Object ref = key_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        key_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string key = 1;</code>
     */
    public Builder setKey(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      key_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string key = 1;</code>
     */
    public Builder clearKey() {
      
      key_ = getDefaultInstance().getKey();
      onChanged();
      return this;
    }
    /**
     * <code>string key = 1;</code>
     */
    public Builder setKeyBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      key_ = value;
      onChanged();
      return this;
    }

    private com.xray.common.protocol.SecurityConfig security_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.xray.common.protocol.SecurityConfig, com.xray.common.protocol.SecurityConfig.Builder, com.xray.common.protocol.SecurityConfigOrBuilder> securityBuilder_;
    /**
     * <code>.xray.common.protocol.SecurityConfig security = 2;</code>
     */
    public boolean hasSecurity() {
      return securityBuilder_ != null || security_ != null;
    }
    /**
     * <code>.xray.common.protocol.SecurityConfig security = 2;</code>
     */
    public com.xray.common.protocol.SecurityConfig getSecurity() {
      if (securityBuilder_ == null) {
        return security_ == null ? com.xray.common.protocol.SecurityConfig.getDefaultInstance() : security_;
      } else {
        return securityBuilder_.getMessage();
      }
    }
    /**
     * <code>.xray.common.protocol.SecurityConfig security = 2;</code>
     */
    public Builder setSecurity(com.xray.common.protocol.SecurityConfig value) {
      if (securityBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        security_ = value;
        onChanged();
      } else {
        securityBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.xray.common.protocol.SecurityConfig security = 2;</code>
     */
    public Builder setSecurity(
        com.xray.common.protocol.SecurityConfig.Builder builderForValue) {
      if (securityBuilder_ == null) {
        security_ = builderForValue.build();
        onChanged();
      } else {
        securityBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.xray.common.protocol.SecurityConfig security = 2;</code>
     */
    public Builder mergeSecurity(com.xray.common.protocol.SecurityConfig value) {
      if (securityBuilder_ == null) {
        if (security_ != null) {
          security_ =
            com.xray.common.protocol.SecurityConfig.newBuilder(security_).mergeFrom(value).buildPartial();
        } else {
          security_ = value;
        }
        onChanged();
      } else {
        securityBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.xray.common.protocol.SecurityConfig security = 2;</code>
     */
    public Builder clearSecurity() {
      if (securityBuilder_ == null) {
        security_ = null;
        onChanged();
      } else {
        security_ = null;
        securityBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.xray.common.protocol.SecurityConfig security = 2;</code>
     */
    public com.xray.common.protocol.SecurityConfig.Builder getSecurityBuilder() {
      
      onChanged();
      return getSecurityFieldBuilder().getBuilder();
    }
    /**
     * <code>.xray.common.protocol.SecurityConfig security = 2;</code>
     */
    public com.xray.common.protocol.SecurityConfigOrBuilder getSecurityOrBuilder() {
      if (securityBuilder_ != null) {
        return securityBuilder_.getMessageOrBuilder();
      } else {
        return security_ == null ?
            com.xray.common.protocol.SecurityConfig.getDefaultInstance() : security_;
      }
    }
    /**
     * <code>.xray.common.protocol.SecurityConfig security = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.xray.common.protocol.SecurityConfig, com.xray.common.protocol.SecurityConfig.Builder, com.xray.common.protocol.SecurityConfigOrBuilder> 
        getSecurityFieldBuilder() {
      if (securityBuilder_ == null) {
        securityBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.xray.common.protocol.SecurityConfig, com.xray.common.protocol.SecurityConfig.Builder, com.xray.common.protocol.SecurityConfigOrBuilder>(
                getSecurity(),
                getParentForChildren(),
                isClean());
        security_ = null;
      }
      return securityBuilder_;
    }

    private com.xray.common.serial.TypedMessage header_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.xray.common.serial.TypedMessage, com.xray.common.serial.TypedMessage.Builder, com.xray.common.serial.TypedMessageOrBuilder> headerBuilder_;
    /**
     * <code>.xray.common.serial.TypedMessage header = 3;</code>
     */
    public boolean hasHeader() {
      return headerBuilder_ != null || header_ != null;
    }
    /**
     * <code>.xray.common.serial.TypedMessage header = 3;</code>
     */
    public com.xray.common.serial.TypedMessage getHeader() {
      if (headerBuilder_ == null) {
        return header_ == null ? com.xray.common.serial.TypedMessage.getDefaultInstance() : header_;
      } else {
        return headerBuilder_.getMessage();
      }
    }
    /**
     * <code>.xray.common.serial.TypedMessage header = 3;</code>
     */
    public Builder setHeader(com.xray.common.serial.TypedMessage value) {
      if (headerBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        header_ = value;
        onChanged();
      } else {
        headerBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.xray.common.serial.TypedMessage header = 3;</code>
     */
    public Builder setHeader(
        com.xray.common.serial.TypedMessage.Builder builderForValue) {
      if (headerBuilder_ == null) {
        header_ = builderForValue.build();
        onChanged();
      } else {
        headerBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.xray.common.serial.TypedMessage header = 3;</code>
     */
    public Builder mergeHeader(com.xray.common.serial.TypedMessage value) {
      if (headerBuilder_ == null) {
        if (header_ != null) {
          header_ =
            com.xray.common.serial.TypedMessage.newBuilder(header_).mergeFrom(value).buildPartial();
        } else {
          header_ = value;
        }
        onChanged();
      } else {
        headerBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.xray.common.serial.TypedMessage header = 3;</code>
     */
    public Builder clearHeader() {
      if (headerBuilder_ == null) {
        header_ = null;
        onChanged();
      } else {
        header_ = null;
        headerBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.xray.common.serial.TypedMessage header = 3;</code>
     */
    public com.xray.common.serial.TypedMessage.Builder getHeaderBuilder() {
      
      onChanged();
      return getHeaderFieldBuilder().getBuilder();
    }
    /**
     * <code>.xray.common.serial.TypedMessage header = 3;</code>
     */
    public com.xray.common.serial.TypedMessageOrBuilder getHeaderOrBuilder() {
      if (headerBuilder_ != null) {
        return headerBuilder_.getMessageOrBuilder();
      } else {
        return header_ == null ?
            com.xray.common.serial.TypedMessage.getDefaultInstance() : header_;
      }
    }
    /**
     * <code>.xray.common.serial.TypedMessage header = 3;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.xray.common.serial.TypedMessage, com.xray.common.serial.TypedMessage.Builder, com.xray.common.serial.TypedMessageOrBuilder> 
        getHeaderFieldBuilder() {
      if (headerBuilder_ == null) {
        headerBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.xray.common.serial.TypedMessage, com.xray.common.serial.TypedMessage.Builder, com.xray.common.serial.TypedMessageOrBuilder>(
                getHeader(),
                getParentForChildren(),
                isClean());
        header_ = null;
      }
      return headerBuilder_;
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


    // @@protoc_insertion_point(builder_scope:xray.transport.internet.quic.Config)
  }

  // @@protoc_insertion_point(class_scope:xray.transport.internet.quic.Config)
  private static final com.xray.transport.internet.quic.Config DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.xray.transport.internet.quic.Config();
  }

  public static com.xray.transport.internet.quic.Config getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Config>
      PARSER = new com.google.protobuf.AbstractParser<Config>() {
    @java.lang.Override
    public Config parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Config(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Config> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Config> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.xray.transport.internet.quic.Config getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

