// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proxy/dns/config.proto

package com.xray.proxy.dns;

/**
 * Protobuf type {@code xray.proxy.dns.Config}
 */
public final class Config extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:xray.proxy.dns.Config)
    ConfigOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Config.newBuilder() to construct.
  private Config(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Config() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new Config();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.xray.proxy.dns.ConfigOuterClass.internal_static_xray_proxy_dns_Config_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.xray.proxy.dns.ConfigOuterClass.internal_static_xray_proxy_dns_Config_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.xray.proxy.dns.Config.class, com.xray.proxy.dns.Config.Builder.class);
  }

  public static final int SERVER_FIELD_NUMBER = 1;
  private com.xray.common.net.Endpoint server_;
  /**
   * <pre>
   * Server is the DNS server address. If specified, this address overrides the
   * original one.
   * </pre>
   *
   * <code>.xray.common.net.Endpoint server = 1;</code>
   * @return Whether the server field is set.
   */
  @java.lang.Override
  public boolean hasServer() {
    return server_ != null;
  }
  /**
   * <pre>
   * Server is the DNS server address. If specified, this address overrides the
   * original one.
   * </pre>
   *
   * <code>.xray.common.net.Endpoint server = 1;</code>
   * @return The server.
   */
  @java.lang.Override
  public com.xray.common.net.Endpoint getServer() {
    return server_ == null ? com.xray.common.net.Endpoint.getDefaultInstance() : server_;
  }
  /**
   * <pre>
   * Server is the DNS server address. If specified, this address overrides the
   * original one.
   * </pre>
   *
   * <code>.xray.common.net.Endpoint server = 1;</code>
   */
  @java.lang.Override
  public com.xray.common.net.EndpointOrBuilder getServerOrBuilder() {
    return server_ == null ? com.xray.common.net.Endpoint.getDefaultInstance() : server_;
  }

  public static final int USER_LEVEL_FIELD_NUMBER = 2;
  private int userLevel_ = 0;
  /**
   * <code>uint32 user_level = 2;</code>
   * @return The userLevel.
   */
  @java.lang.Override
  public int getUserLevel() {
    return userLevel_;
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
    if (server_ != null) {
      output.writeMessage(1, getServer());
    }
    if (userLevel_ != 0) {
      output.writeUInt32(2, userLevel_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (server_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getServer());
    }
    if (userLevel_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt32Size(2, userLevel_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.xray.proxy.dns.Config)) {
      return super.equals(obj);
    }
    com.xray.proxy.dns.Config other = (com.xray.proxy.dns.Config) obj;

    if (hasServer() != other.hasServer()) return false;
    if (hasServer()) {
      if (!getServer()
          .equals(other.getServer())) return false;
    }
    if (getUserLevel()
        != other.getUserLevel()) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasServer()) {
      hash = (37 * hash) + SERVER_FIELD_NUMBER;
      hash = (53 * hash) + getServer().hashCode();
    }
    hash = (37 * hash) + USER_LEVEL_FIELD_NUMBER;
    hash = (53 * hash) + getUserLevel();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.xray.proxy.dns.Config parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.xray.proxy.dns.Config parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.xray.proxy.dns.Config parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.xray.proxy.dns.Config parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.xray.proxy.dns.Config parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.xray.proxy.dns.Config parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.xray.proxy.dns.Config parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.xray.proxy.dns.Config parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.xray.proxy.dns.Config parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.xray.proxy.dns.Config parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.xray.proxy.dns.Config parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.xray.proxy.dns.Config parseFrom(
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
  public static Builder newBuilder(com.xray.proxy.dns.Config prototype) {
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
   * Protobuf type {@code xray.proxy.dns.Config}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:xray.proxy.dns.Config)
      com.xray.proxy.dns.ConfigOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.xray.proxy.dns.ConfigOuterClass.internal_static_xray_proxy_dns_Config_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.xray.proxy.dns.ConfigOuterClass.internal_static_xray_proxy_dns_Config_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.xray.proxy.dns.Config.class, com.xray.proxy.dns.Config.Builder.class);
    }

    // Construct using com.xray.proxy.dns.Config.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      server_ = null;
      if (serverBuilder_ != null) {
        serverBuilder_.dispose();
        serverBuilder_ = null;
      }
      userLevel_ = 0;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.xray.proxy.dns.ConfigOuterClass.internal_static_xray_proxy_dns_Config_descriptor;
    }

    @java.lang.Override
    public com.xray.proxy.dns.Config getDefaultInstanceForType() {
      return com.xray.proxy.dns.Config.getDefaultInstance();
    }

    @java.lang.Override
    public com.xray.proxy.dns.Config build() {
      com.xray.proxy.dns.Config result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.xray.proxy.dns.Config buildPartial() {
      com.xray.proxy.dns.Config result = new com.xray.proxy.dns.Config(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.xray.proxy.dns.Config result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.server_ = serverBuilder_ == null
            ? server_
            : serverBuilder_.build();
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.userLevel_ = userLevel_;
      }
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
      if (other instanceof com.xray.proxy.dns.Config) {
        return mergeFrom((com.xray.proxy.dns.Config)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.xray.proxy.dns.Config other) {
      if (other == com.xray.proxy.dns.Config.getDefaultInstance()) return this;
      if (other.hasServer()) {
        mergeServer(other.getServer());
      }
      if (other.getUserLevel() != 0) {
        setUserLevel(other.getUserLevel());
      }
      this.mergeUnknownFields(other.getUnknownFields());
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
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              input.readMessage(
                  getServerFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 16: {
              userLevel_ = input.readUInt32();
              bitField0_ |= 0x00000002;
              break;
            } // case 16
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private com.xray.common.net.Endpoint server_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.xray.common.net.Endpoint, com.xray.common.net.Endpoint.Builder, com.xray.common.net.EndpointOrBuilder> serverBuilder_;
    /**
     * <pre>
     * Server is the DNS server address. If specified, this address overrides the
     * original one.
     * </pre>
     *
     * <code>.xray.common.net.Endpoint server = 1;</code>
     * @return Whether the server field is set.
     */
    public boolean hasServer() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <pre>
     * Server is the DNS server address. If specified, this address overrides the
     * original one.
     * </pre>
     *
     * <code>.xray.common.net.Endpoint server = 1;</code>
     * @return The server.
     */
    public com.xray.common.net.Endpoint getServer() {
      if (serverBuilder_ == null) {
        return server_ == null ? com.xray.common.net.Endpoint.getDefaultInstance() : server_;
      } else {
        return serverBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     * Server is the DNS server address. If specified, this address overrides the
     * original one.
     * </pre>
     *
     * <code>.xray.common.net.Endpoint server = 1;</code>
     */
    public Builder setServer(com.xray.common.net.Endpoint value) {
      if (serverBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        server_ = value;
      } else {
        serverBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Server is the DNS server address. If specified, this address overrides the
     * original one.
     * </pre>
     *
     * <code>.xray.common.net.Endpoint server = 1;</code>
     */
    public Builder setServer(
        com.xray.common.net.Endpoint.Builder builderForValue) {
      if (serverBuilder_ == null) {
        server_ = builderForValue.build();
      } else {
        serverBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Server is the DNS server address. If specified, this address overrides the
     * original one.
     * </pre>
     *
     * <code>.xray.common.net.Endpoint server = 1;</code>
     */
    public Builder mergeServer(com.xray.common.net.Endpoint value) {
      if (serverBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0) &&
          server_ != null &&
          server_ != com.xray.common.net.Endpoint.getDefaultInstance()) {
          getServerBuilder().mergeFrom(value);
        } else {
          server_ = value;
        }
      } else {
        serverBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Server is the DNS server address. If specified, this address overrides the
     * original one.
     * </pre>
     *
     * <code>.xray.common.net.Endpoint server = 1;</code>
     */
    public Builder clearServer() {
      bitField0_ = (bitField0_ & ~0x00000001);
      server_ = null;
      if (serverBuilder_ != null) {
        serverBuilder_.dispose();
        serverBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Server is the DNS server address. If specified, this address overrides the
     * original one.
     * </pre>
     *
     * <code>.xray.common.net.Endpoint server = 1;</code>
     */
    public com.xray.common.net.Endpoint.Builder getServerBuilder() {
      bitField0_ |= 0x00000001;
      onChanged();
      return getServerFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     * Server is the DNS server address. If specified, this address overrides the
     * original one.
     * </pre>
     *
     * <code>.xray.common.net.Endpoint server = 1;</code>
     */
    public com.xray.common.net.EndpointOrBuilder getServerOrBuilder() {
      if (serverBuilder_ != null) {
        return serverBuilder_.getMessageOrBuilder();
      } else {
        return server_ == null ?
            com.xray.common.net.Endpoint.getDefaultInstance() : server_;
      }
    }
    /**
     * <pre>
     * Server is the DNS server address. If specified, this address overrides the
     * original one.
     * </pre>
     *
     * <code>.xray.common.net.Endpoint server = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.xray.common.net.Endpoint, com.xray.common.net.Endpoint.Builder, com.xray.common.net.EndpointOrBuilder> 
        getServerFieldBuilder() {
      if (serverBuilder_ == null) {
        serverBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.xray.common.net.Endpoint, com.xray.common.net.Endpoint.Builder, com.xray.common.net.EndpointOrBuilder>(
                getServer(),
                getParentForChildren(),
                isClean());
        server_ = null;
      }
      return serverBuilder_;
    }

    private int userLevel_ ;
    /**
     * <code>uint32 user_level = 2;</code>
     * @return The userLevel.
     */
    @java.lang.Override
    public int getUserLevel() {
      return userLevel_;
    }
    /**
     * <code>uint32 user_level = 2;</code>
     * @param value The userLevel to set.
     * @return This builder for chaining.
     */
    public Builder setUserLevel(int value) {
      
      userLevel_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>uint32 user_level = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearUserLevel() {
      bitField0_ = (bitField0_ & ~0x00000002);
      userLevel_ = 0;
      onChanged();
      return this;
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


    // @@protoc_insertion_point(builder_scope:xray.proxy.dns.Config)
  }

  // @@protoc_insertion_point(class_scope:xray.proxy.dns.Config)
  private static final com.xray.proxy.dns.Config DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.xray.proxy.dns.Config();
  }

  public static com.xray.proxy.dns.Config getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Config>
      PARSER = new com.google.protobuf.AbstractParser<Config>() {
    @java.lang.Override
    public Config parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
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
  public com.xray.proxy.dns.Config getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

