// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proxy/mtproto/config.proto

package com.xray.proxy.mtproto;

/**
 * Protobuf type {@code xray.proxy.mtproto.ServerConfig}
 */
public  final class ServerConfig extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:xray.proxy.mtproto.ServerConfig)
    ServerConfigOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ServerConfig.newBuilder() to construct.
  private ServerConfig(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ServerConfig() {
    user_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ServerConfig(
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
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              user_ = new java.util.ArrayList<com.xray.common.protocol.User>();
              mutable_bitField0_ |= 0x00000001;
            }
            user_.add(
                input.readMessage(com.xray.common.protocol.User.parser(), extensionRegistry));
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
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        user_ = java.util.Collections.unmodifiableList(user_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.xray.proxy.mtproto.Config.internal_static_xray_proxy_mtproto_ServerConfig_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.xray.proxy.mtproto.Config.internal_static_xray_proxy_mtproto_ServerConfig_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.xray.proxy.mtproto.ServerConfig.class, com.xray.proxy.mtproto.ServerConfig.Builder.class);
  }

  public static final int USER_FIELD_NUMBER = 1;
  private java.util.List<com.xray.common.protocol.User> user_;
  /**
   * <pre>
   * User is a list of users that allowed to connect to this inbound.
   * Although this is a repeated field, only the first user is effective for
   * now.
   * </pre>
   *
   * <code>repeated .xray.common.protocol.User user = 1;</code>
   */
  public java.util.List<com.xray.common.protocol.User> getUserList() {
    return user_;
  }
  /**
   * <pre>
   * User is a list of users that allowed to connect to this inbound.
   * Although this is a repeated field, only the first user is effective for
   * now.
   * </pre>
   *
   * <code>repeated .xray.common.protocol.User user = 1;</code>
   */
  public java.util.List<? extends com.xray.common.protocol.UserOrBuilder> 
      getUserOrBuilderList() {
    return user_;
  }
  /**
   * <pre>
   * User is a list of users that allowed to connect to this inbound.
   * Although this is a repeated field, only the first user is effective for
   * now.
   * </pre>
   *
   * <code>repeated .xray.common.protocol.User user = 1;</code>
   */
  public int getUserCount() {
    return user_.size();
  }
  /**
   * <pre>
   * User is a list of users that allowed to connect to this inbound.
   * Although this is a repeated field, only the first user is effective for
   * now.
   * </pre>
   *
   * <code>repeated .xray.common.protocol.User user = 1;</code>
   */
  public com.xray.common.protocol.User getUser(int index) {
    return user_.get(index);
  }
  /**
   * <pre>
   * User is a list of users that allowed to connect to this inbound.
   * Although this is a repeated field, only the first user is effective for
   * now.
   * </pre>
   *
   * <code>repeated .xray.common.protocol.User user = 1;</code>
   */
  public com.xray.common.protocol.UserOrBuilder getUserOrBuilder(
      int index) {
    return user_.get(index);
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
    for (int i = 0; i < user_.size(); i++) {
      output.writeMessage(1, user_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < user_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, user_.get(i));
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
    if (!(obj instanceof com.xray.proxy.mtproto.ServerConfig)) {
      return super.equals(obj);
    }
    com.xray.proxy.mtproto.ServerConfig other = (com.xray.proxy.mtproto.ServerConfig) obj;

    if (!getUserList()
        .equals(other.getUserList())) return false;
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
    if (getUserCount() > 0) {
      hash = (37 * hash) + USER_FIELD_NUMBER;
      hash = (53 * hash) + getUserList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.xray.proxy.mtproto.ServerConfig parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.xray.proxy.mtproto.ServerConfig parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.xray.proxy.mtproto.ServerConfig parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.xray.proxy.mtproto.ServerConfig parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.xray.proxy.mtproto.ServerConfig parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.xray.proxy.mtproto.ServerConfig parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.xray.proxy.mtproto.ServerConfig parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.xray.proxy.mtproto.ServerConfig parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.xray.proxy.mtproto.ServerConfig parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.xray.proxy.mtproto.ServerConfig parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.xray.proxy.mtproto.ServerConfig parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.xray.proxy.mtproto.ServerConfig parseFrom(
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
  public static Builder newBuilder(com.xray.proxy.mtproto.ServerConfig prototype) {
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
   * Protobuf type {@code xray.proxy.mtproto.ServerConfig}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:xray.proxy.mtproto.ServerConfig)
      com.xray.proxy.mtproto.ServerConfigOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.xray.proxy.mtproto.Config.internal_static_xray_proxy_mtproto_ServerConfig_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.xray.proxy.mtproto.Config.internal_static_xray_proxy_mtproto_ServerConfig_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.xray.proxy.mtproto.ServerConfig.class, com.xray.proxy.mtproto.ServerConfig.Builder.class);
    }

    // Construct using com.xray.proxy.mtproto.ServerConfig.newBuilder()
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
        getUserFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (userBuilder_ == null) {
        user_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        userBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.xray.proxy.mtproto.Config.internal_static_xray_proxy_mtproto_ServerConfig_descriptor;
    }

    @java.lang.Override
    public com.xray.proxy.mtproto.ServerConfig getDefaultInstanceForType() {
      return com.xray.proxy.mtproto.ServerConfig.getDefaultInstance();
    }

    @java.lang.Override
    public com.xray.proxy.mtproto.ServerConfig build() {
      com.xray.proxy.mtproto.ServerConfig result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.xray.proxy.mtproto.ServerConfig buildPartial() {
      com.xray.proxy.mtproto.ServerConfig result = new com.xray.proxy.mtproto.ServerConfig(this);
      int from_bitField0_ = bitField0_;
      if (userBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          user_ = java.util.Collections.unmodifiableList(user_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.user_ = user_;
      } else {
        result.user_ = userBuilder_.build();
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
      if (other instanceof com.xray.proxy.mtproto.ServerConfig) {
        return mergeFrom((com.xray.proxy.mtproto.ServerConfig)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.xray.proxy.mtproto.ServerConfig other) {
      if (other == com.xray.proxy.mtproto.ServerConfig.getDefaultInstance()) return this;
      if (userBuilder_ == null) {
        if (!other.user_.isEmpty()) {
          if (user_.isEmpty()) {
            user_ = other.user_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureUserIsMutable();
            user_.addAll(other.user_);
          }
          onChanged();
        }
      } else {
        if (!other.user_.isEmpty()) {
          if (userBuilder_.isEmpty()) {
            userBuilder_.dispose();
            userBuilder_ = null;
            user_ = other.user_;
            bitField0_ = (bitField0_ & ~0x00000001);
            userBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getUserFieldBuilder() : null;
          } else {
            userBuilder_.addAllMessages(other.user_);
          }
        }
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
      com.xray.proxy.mtproto.ServerConfig parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.xray.proxy.mtproto.ServerConfig) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<com.xray.common.protocol.User> user_ =
      java.util.Collections.emptyList();
    private void ensureUserIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        user_ = new java.util.ArrayList<com.xray.common.protocol.User>(user_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.xray.common.protocol.User, com.xray.common.protocol.User.Builder, com.xray.common.protocol.UserOrBuilder> userBuilder_;

    /**
     * <pre>
     * User is a list of users that allowed to connect to this inbound.
     * Although this is a repeated field, only the first user is effective for
     * now.
     * </pre>
     *
     * <code>repeated .xray.common.protocol.User user = 1;</code>
     */
    public java.util.List<com.xray.common.protocol.User> getUserList() {
      if (userBuilder_ == null) {
        return java.util.Collections.unmodifiableList(user_);
      } else {
        return userBuilder_.getMessageList();
      }
    }
    /**
     * <pre>
     * User is a list of users that allowed to connect to this inbound.
     * Although this is a repeated field, only the first user is effective for
     * now.
     * </pre>
     *
     * <code>repeated .xray.common.protocol.User user = 1;</code>
     */
    public int getUserCount() {
      if (userBuilder_ == null) {
        return user_.size();
      } else {
        return userBuilder_.getCount();
      }
    }
    /**
     * <pre>
     * User is a list of users that allowed to connect to this inbound.
     * Although this is a repeated field, only the first user is effective for
     * now.
     * </pre>
     *
     * <code>repeated .xray.common.protocol.User user = 1;</code>
     */
    public com.xray.common.protocol.User getUser(int index) {
      if (userBuilder_ == null) {
        return user_.get(index);
      } else {
        return userBuilder_.getMessage(index);
      }
    }
    /**
     * <pre>
     * User is a list of users that allowed to connect to this inbound.
     * Although this is a repeated field, only the first user is effective for
     * now.
     * </pre>
     *
     * <code>repeated .xray.common.protocol.User user = 1;</code>
     */
    public Builder setUser(
        int index, com.xray.common.protocol.User value) {
      if (userBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureUserIsMutable();
        user_.set(index, value);
        onChanged();
      } else {
        userBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <pre>
     * User is a list of users that allowed to connect to this inbound.
     * Although this is a repeated field, only the first user is effective for
     * now.
     * </pre>
     *
     * <code>repeated .xray.common.protocol.User user = 1;</code>
     */
    public Builder setUser(
        int index, com.xray.common.protocol.User.Builder builderForValue) {
      if (userBuilder_ == null) {
        ensureUserIsMutable();
        user_.set(index, builderForValue.build());
        onChanged();
      } else {
        userBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     * User is a list of users that allowed to connect to this inbound.
     * Although this is a repeated field, only the first user is effective for
     * now.
     * </pre>
     *
     * <code>repeated .xray.common.protocol.User user = 1;</code>
     */
    public Builder addUser(com.xray.common.protocol.User value) {
      if (userBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureUserIsMutable();
        user_.add(value);
        onChanged();
      } else {
        userBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <pre>
     * User is a list of users that allowed to connect to this inbound.
     * Although this is a repeated field, only the first user is effective for
     * now.
     * </pre>
     *
     * <code>repeated .xray.common.protocol.User user = 1;</code>
     */
    public Builder addUser(
        int index, com.xray.common.protocol.User value) {
      if (userBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureUserIsMutable();
        user_.add(index, value);
        onChanged();
      } else {
        userBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <pre>
     * User is a list of users that allowed to connect to this inbound.
     * Although this is a repeated field, only the first user is effective for
     * now.
     * </pre>
     *
     * <code>repeated .xray.common.protocol.User user = 1;</code>
     */
    public Builder addUser(
        com.xray.common.protocol.User.Builder builderForValue) {
      if (userBuilder_ == null) {
        ensureUserIsMutable();
        user_.add(builderForValue.build());
        onChanged();
      } else {
        userBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     * User is a list of users that allowed to connect to this inbound.
     * Although this is a repeated field, only the first user is effective for
     * now.
     * </pre>
     *
     * <code>repeated .xray.common.protocol.User user = 1;</code>
     */
    public Builder addUser(
        int index, com.xray.common.protocol.User.Builder builderForValue) {
      if (userBuilder_ == null) {
        ensureUserIsMutable();
        user_.add(index, builderForValue.build());
        onChanged();
      } else {
        userBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     * User is a list of users that allowed to connect to this inbound.
     * Although this is a repeated field, only the first user is effective for
     * now.
     * </pre>
     *
     * <code>repeated .xray.common.protocol.User user = 1;</code>
     */
    public Builder addAllUser(
        java.lang.Iterable<? extends com.xray.common.protocol.User> values) {
      if (userBuilder_ == null) {
        ensureUserIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, user_);
        onChanged();
      } else {
        userBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <pre>
     * User is a list of users that allowed to connect to this inbound.
     * Although this is a repeated field, only the first user is effective for
     * now.
     * </pre>
     *
     * <code>repeated .xray.common.protocol.User user = 1;</code>
     */
    public Builder clearUser() {
      if (userBuilder_ == null) {
        user_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        userBuilder_.clear();
      }
      return this;
    }
    /**
     * <pre>
     * User is a list of users that allowed to connect to this inbound.
     * Although this is a repeated field, only the first user is effective for
     * now.
     * </pre>
     *
     * <code>repeated .xray.common.protocol.User user = 1;</code>
     */
    public Builder removeUser(int index) {
      if (userBuilder_ == null) {
        ensureUserIsMutable();
        user_.remove(index);
        onChanged();
      } else {
        userBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <pre>
     * User is a list of users that allowed to connect to this inbound.
     * Although this is a repeated field, only the first user is effective for
     * now.
     * </pre>
     *
     * <code>repeated .xray.common.protocol.User user = 1;</code>
     */
    public com.xray.common.protocol.User.Builder getUserBuilder(
        int index) {
      return getUserFieldBuilder().getBuilder(index);
    }
    /**
     * <pre>
     * User is a list of users that allowed to connect to this inbound.
     * Although this is a repeated field, only the first user is effective for
     * now.
     * </pre>
     *
     * <code>repeated .xray.common.protocol.User user = 1;</code>
     */
    public com.xray.common.protocol.UserOrBuilder getUserOrBuilder(
        int index) {
      if (userBuilder_ == null) {
        return user_.get(index);  } else {
        return userBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <pre>
     * User is a list of users that allowed to connect to this inbound.
     * Although this is a repeated field, only the first user is effective for
     * now.
     * </pre>
     *
     * <code>repeated .xray.common.protocol.User user = 1;</code>
     */
    public java.util.List<? extends com.xray.common.protocol.UserOrBuilder> 
         getUserOrBuilderList() {
      if (userBuilder_ != null) {
        return userBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(user_);
      }
    }
    /**
     * <pre>
     * User is a list of users that allowed to connect to this inbound.
     * Although this is a repeated field, only the first user is effective for
     * now.
     * </pre>
     *
     * <code>repeated .xray.common.protocol.User user = 1;</code>
     */
    public com.xray.common.protocol.User.Builder addUserBuilder() {
      return getUserFieldBuilder().addBuilder(
          com.xray.common.protocol.User.getDefaultInstance());
    }
    /**
     * <pre>
     * User is a list of users that allowed to connect to this inbound.
     * Although this is a repeated field, only the first user is effective for
     * now.
     * </pre>
     *
     * <code>repeated .xray.common.protocol.User user = 1;</code>
     */
    public com.xray.common.protocol.User.Builder addUserBuilder(
        int index) {
      return getUserFieldBuilder().addBuilder(
          index, com.xray.common.protocol.User.getDefaultInstance());
    }
    /**
     * <pre>
     * User is a list of users that allowed to connect to this inbound.
     * Although this is a repeated field, only the first user is effective for
     * now.
     * </pre>
     *
     * <code>repeated .xray.common.protocol.User user = 1;</code>
     */
    public java.util.List<com.xray.common.protocol.User.Builder> 
         getUserBuilderList() {
      return getUserFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.xray.common.protocol.User, com.xray.common.protocol.User.Builder, com.xray.common.protocol.UserOrBuilder> 
        getUserFieldBuilder() {
      if (userBuilder_ == null) {
        userBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.xray.common.protocol.User, com.xray.common.protocol.User.Builder, com.xray.common.protocol.UserOrBuilder>(
                user_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        user_ = null;
      }
      return userBuilder_;
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


    // @@protoc_insertion_point(builder_scope:xray.proxy.mtproto.ServerConfig)
  }

  // @@protoc_insertion_point(class_scope:xray.proxy.mtproto.ServerConfig)
  private static final com.xray.proxy.mtproto.ServerConfig DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.xray.proxy.mtproto.ServerConfig();
  }

  public static com.xray.proxy.mtproto.ServerConfig getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ServerConfig>
      PARSER = new com.google.protobuf.AbstractParser<ServerConfig>() {
    @java.lang.Override
    public ServerConfig parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ServerConfig(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ServerConfig> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ServerConfig> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.xray.proxy.mtproto.ServerConfig getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

