// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proxy/vmess/inbound/config.proto

package com.xray.proxy.vmess.inbound;

/**
 * Protobuf type {@code xray.proxy.vmess.inbound.Config}
 */
public final class Config extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:xray.proxy.vmess.inbound.Config)
    ConfigOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Config.newBuilder() to construct.
  private Config(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Config() {
    user_ = java.util.Collections.emptyList();
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
    return com.xray.proxy.vmess.inbound.ConfigOuterClass.internal_static_xray_proxy_vmess_inbound_Config_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.xray.proxy.vmess.inbound.ConfigOuterClass.internal_static_xray_proxy_vmess_inbound_Config_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.xray.proxy.vmess.inbound.Config.class, com.xray.proxy.vmess.inbound.Config.Builder.class);
  }

  public static final int USER_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private java.util.List<com.xray.common.protocol.User> user_;
  /**
   * <code>repeated .xray.common.protocol.User user = 1;</code>
   */
  @java.lang.Override
  public java.util.List<com.xray.common.protocol.User> getUserList() {
    return user_;
  }
  /**
   * <code>repeated .xray.common.protocol.User user = 1;</code>
   */
  @java.lang.Override
  public java.util.List<? extends com.xray.common.protocol.UserOrBuilder> 
      getUserOrBuilderList() {
    return user_;
  }
  /**
   * <code>repeated .xray.common.protocol.User user = 1;</code>
   */
  @java.lang.Override
  public int getUserCount() {
    return user_.size();
  }
  /**
   * <code>repeated .xray.common.protocol.User user = 1;</code>
   */
  @java.lang.Override
  public com.xray.common.protocol.User getUser(int index) {
    return user_.get(index);
  }
  /**
   * <code>repeated .xray.common.protocol.User user = 1;</code>
   */
  @java.lang.Override
  public com.xray.common.protocol.UserOrBuilder getUserOrBuilder(
      int index) {
    return user_.get(index);
  }

  public static final int DEFAULT_FIELD_NUMBER = 2;
  private com.xray.proxy.vmess.inbound.DefaultConfig default_;
  /**
   * <code>.xray.proxy.vmess.inbound.DefaultConfig default = 2;</code>
   * @return Whether the default field is set.
   */
  @java.lang.Override
  public boolean hasDefault() {
    return default_ != null;
  }
  /**
   * <code>.xray.proxy.vmess.inbound.DefaultConfig default = 2;</code>
   * @return The default.
   */
  @java.lang.Override
  public com.xray.proxy.vmess.inbound.DefaultConfig getDefault() {
    return default_ == null ? com.xray.proxy.vmess.inbound.DefaultConfig.getDefaultInstance() : default_;
  }
  /**
   * <code>.xray.proxy.vmess.inbound.DefaultConfig default = 2;</code>
   */
  @java.lang.Override
  public com.xray.proxy.vmess.inbound.DefaultConfigOrBuilder getDefaultOrBuilder() {
    return default_ == null ? com.xray.proxy.vmess.inbound.DefaultConfig.getDefaultInstance() : default_;
  }

  public static final int DETOUR_FIELD_NUMBER = 3;
  private com.xray.proxy.vmess.inbound.DetourConfig detour_;
  /**
   * <code>.xray.proxy.vmess.inbound.DetourConfig detour = 3;</code>
   * @return Whether the detour field is set.
   */
  @java.lang.Override
  public boolean hasDetour() {
    return detour_ != null;
  }
  /**
   * <code>.xray.proxy.vmess.inbound.DetourConfig detour = 3;</code>
   * @return The detour.
   */
  @java.lang.Override
  public com.xray.proxy.vmess.inbound.DetourConfig getDetour() {
    return detour_ == null ? com.xray.proxy.vmess.inbound.DetourConfig.getDefaultInstance() : detour_;
  }
  /**
   * <code>.xray.proxy.vmess.inbound.DetourConfig detour = 3;</code>
   */
  @java.lang.Override
  public com.xray.proxy.vmess.inbound.DetourConfigOrBuilder getDetourOrBuilder() {
    return detour_ == null ? com.xray.proxy.vmess.inbound.DetourConfig.getDefaultInstance() : detour_;
  }

  public static final int SECURE_ENCRYPTION_ONLY_FIELD_NUMBER = 4;
  private boolean secureEncryptionOnly_ = false;
  /**
   * <code>bool secure_encryption_only = 4;</code>
   * @return The secureEncryptionOnly.
   */
  @java.lang.Override
  public boolean getSecureEncryptionOnly() {
    return secureEncryptionOnly_;
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
    if (default_ != null) {
      output.writeMessage(2, getDefault());
    }
    if (detour_ != null) {
      output.writeMessage(3, getDetour());
    }
    if (secureEncryptionOnly_ != false) {
      output.writeBool(4, secureEncryptionOnly_);
    }
    getUnknownFields().writeTo(output);
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
    if (default_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getDefault());
    }
    if (detour_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, getDetour());
    }
    if (secureEncryptionOnly_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(4, secureEncryptionOnly_);
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
    if (!(obj instanceof com.xray.proxy.vmess.inbound.Config)) {
      return super.equals(obj);
    }
    com.xray.proxy.vmess.inbound.Config other = (com.xray.proxy.vmess.inbound.Config) obj;

    if (!getUserList()
        .equals(other.getUserList())) return false;
    if (hasDefault() != other.hasDefault()) return false;
    if (hasDefault()) {
      if (!getDefault()
          .equals(other.getDefault())) return false;
    }
    if (hasDetour() != other.hasDetour()) return false;
    if (hasDetour()) {
      if (!getDetour()
          .equals(other.getDetour())) return false;
    }
    if (getSecureEncryptionOnly()
        != other.getSecureEncryptionOnly()) return false;
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
    if (getUserCount() > 0) {
      hash = (37 * hash) + USER_FIELD_NUMBER;
      hash = (53 * hash) + getUserList().hashCode();
    }
    if (hasDefault()) {
      hash = (37 * hash) + DEFAULT_FIELD_NUMBER;
      hash = (53 * hash) + getDefault().hashCode();
    }
    if (hasDetour()) {
      hash = (37 * hash) + DETOUR_FIELD_NUMBER;
      hash = (53 * hash) + getDetour().hashCode();
    }
    hash = (37 * hash) + SECURE_ENCRYPTION_ONLY_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getSecureEncryptionOnly());
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.xray.proxy.vmess.inbound.Config parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.xray.proxy.vmess.inbound.Config parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.xray.proxy.vmess.inbound.Config parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.xray.proxy.vmess.inbound.Config parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.xray.proxy.vmess.inbound.Config parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.xray.proxy.vmess.inbound.Config parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.xray.proxy.vmess.inbound.Config parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.xray.proxy.vmess.inbound.Config parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.xray.proxy.vmess.inbound.Config parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.xray.proxy.vmess.inbound.Config parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.xray.proxy.vmess.inbound.Config parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.xray.proxy.vmess.inbound.Config parseFrom(
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
  public static Builder newBuilder(com.xray.proxy.vmess.inbound.Config prototype) {
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
   * Protobuf type {@code xray.proxy.vmess.inbound.Config}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:xray.proxy.vmess.inbound.Config)
      com.xray.proxy.vmess.inbound.ConfigOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.xray.proxy.vmess.inbound.ConfigOuterClass.internal_static_xray_proxy_vmess_inbound_Config_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.xray.proxy.vmess.inbound.ConfigOuterClass.internal_static_xray_proxy_vmess_inbound_Config_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.xray.proxy.vmess.inbound.Config.class, com.xray.proxy.vmess.inbound.Config.Builder.class);
    }

    // Construct using com.xray.proxy.vmess.inbound.Config.newBuilder()
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
      if (userBuilder_ == null) {
        user_ = java.util.Collections.emptyList();
      } else {
        user_ = null;
        userBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      default_ = null;
      if (defaultBuilder_ != null) {
        defaultBuilder_.dispose();
        defaultBuilder_ = null;
      }
      detour_ = null;
      if (detourBuilder_ != null) {
        detourBuilder_.dispose();
        detourBuilder_ = null;
      }
      secureEncryptionOnly_ = false;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.xray.proxy.vmess.inbound.ConfigOuterClass.internal_static_xray_proxy_vmess_inbound_Config_descriptor;
    }

    @java.lang.Override
    public com.xray.proxy.vmess.inbound.Config getDefaultInstanceForType() {
      return com.xray.proxy.vmess.inbound.Config.getDefaultInstance();
    }

    @java.lang.Override
    public com.xray.proxy.vmess.inbound.Config build() {
      com.xray.proxy.vmess.inbound.Config result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.xray.proxy.vmess.inbound.Config buildPartial() {
      com.xray.proxy.vmess.inbound.Config result = new com.xray.proxy.vmess.inbound.Config(this);
      buildPartialRepeatedFields(result);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartialRepeatedFields(com.xray.proxy.vmess.inbound.Config result) {
      if (userBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          user_ = java.util.Collections.unmodifiableList(user_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.user_ = user_;
      } else {
        result.user_ = userBuilder_.build();
      }
    }

    private void buildPartial0(com.xray.proxy.vmess.inbound.Config result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.default_ = defaultBuilder_ == null
            ? default_
            : defaultBuilder_.build();
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.detour_ = detourBuilder_ == null
            ? detour_
            : detourBuilder_.build();
      }
      if (((from_bitField0_ & 0x00000008) != 0)) {
        result.secureEncryptionOnly_ = secureEncryptionOnly_;
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
      if (other instanceof com.xray.proxy.vmess.inbound.Config) {
        return mergeFrom((com.xray.proxy.vmess.inbound.Config)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.xray.proxy.vmess.inbound.Config other) {
      if (other == com.xray.proxy.vmess.inbound.Config.getDefaultInstance()) return this;
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
      if (other.hasDefault()) {
        mergeDefault(other.getDefault());
      }
      if (other.hasDetour()) {
        mergeDetour(other.getDetour());
      }
      if (other.getSecureEncryptionOnly() != false) {
        setSecureEncryptionOnly(other.getSecureEncryptionOnly());
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
              com.xray.common.protocol.User m =
                  input.readMessage(
                      com.xray.common.protocol.User.parser(),
                      extensionRegistry);
              if (userBuilder_ == null) {
                ensureUserIsMutable();
                user_.add(m);
              } else {
                userBuilder_.addMessage(m);
              }
              break;
            } // case 10
            case 18: {
              input.readMessage(
                  getDefaultFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000002;
              break;
            } // case 18
            case 26: {
              input.readMessage(
                  getDetourFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000004;
              break;
            } // case 26
            case 32: {
              secureEncryptionOnly_ = input.readBool();
              bitField0_ |= 0x00000008;
              break;
            } // case 32
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
     * <code>repeated .xray.common.protocol.User user = 1;</code>
     */
    public com.xray.common.protocol.User.Builder getUserBuilder(
        int index) {
      return getUserFieldBuilder().getBuilder(index);
    }
    /**
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
     * <code>repeated .xray.common.protocol.User user = 1;</code>
     */
    public com.xray.common.protocol.User.Builder addUserBuilder() {
      return getUserFieldBuilder().addBuilder(
          com.xray.common.protocol.User.getDefaultInstance());
    }
    /**
     * <code>repeated .xray.common.protocol.User user = 1;</code>
     */
    public com.xray.common.protocol.User.Builder addUserBuilder(
        int index) {
      return getUserFieldBuilder().addBuilder(
          index, com.xray.common.protocol.User.getDefaultInstance());
    }
    /**
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

    private com.xray.proxy.vmess.inbound.DefaultConfig default_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.xray.proxy.vmess.inbound.DefaultConfig, com.xray.proxy.vmess.inbound.DefaultConfig.Builder, com.xray.proxy.vmess.inbound.DefaultConfigOrBuilder> defaultBuilder_;
    /**
     * <code>.xray.proxy.vmess.inbound.DefaultConfig default = 2;</code>
     * @return Whether the default field is set.
     */
    public boolean hasDefault() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>.xray.proxy.vmess.inbound.DefaultConfig default = 2;</code>
     * @return The default.
     */
    public com.xray.proxy.vmess.inbound.DefaultConfig getDefault() {
      if (defaultBuilder_ == null) {
        return default_ == null ? com.xray.proxy.vmess.inbound.DefaultConfig.getDefaultInstance() : default_;
      } else {
        return defaultBuilder_.getMessage();
      }
    }
    /**
     * <code>.xray.proxy.vmess.inbound.DefaultConfig default = 2;</code>
     */
    public Builder setDefault(com.xray.proxy.vmess.inbound.DefaultConfig value) {
      if (defaultBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        default_ = value;
      } else {
        defaultBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>.xray.proxy.vmess.inbound.DefaultConfig default = 2;</code>
     */
    public Builder setDefault(
        com.xray.proxy.vmess.inbound.DefaultConfig.Builder builderForValue) {
      if (defaultBuilder_ == null) {
        default_ = builderForValue.build();
      } else {
        defaultBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>.xray.proxy.vmess.inbound.DefaultConfig default = 2;</code>
     */
    public Builder mergeDefault(com.xray.proxy.vmess.inbound.DefaultConfig value) {
      if (defaultBuilder_ == null) {
        if (((bitField0_ & 0x00000002) != 0) &&
          default_ != null &&
          default_ != com.xray.proxy.vmess.inbound.DefaultConfig.getDefaultInstance()) {
          getDefaultBuilder().mergeFrom(value);
        } else {
          default_ = value;
        }
      } else {
        defaultBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>.xray.proxy.vmess.inbound.DefaultConfig default = 2;</code>
     */
    public Builder clearDefault() {
      bitField0_ = (bitField0_ & ~0x00000002);
      default_ = null;
      if (defaultBuilder_ != null) {
        defaultBuilder_.dispose();
        defaultBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <code>.xray.proxy.vmess.inbound.DefaultConfig default = 2;</code>
     */
    public com.xray.proxy.vmess.inbound.DefaultConfig.Builder getDefaultBuilder() {
      bitField0_ |= 0x00000002;
      onChanged();
      return getDefaultFieldBuilder().getBuilder();
    }
    /**
     * <code>.xray.proxy.vmess.inbound.DefaultConfig default = 2;</code>
     */
    public com.xray.proxy.vmess.inbound.DefaultConfigOrBuilder getDefaultOrBuilder() {
      if (defaultBuilder_ != null) {
        return defaultBuilder_.getMessageOrBuilder();
      } else {
        return default_ == null ?
            com.xray.proxy.vmess.inbound.DefaultConfig.getDefaultInstance() : default_;
      }
    }
    /**
     * <code>.xray.proxy.vmess.inbound.DefaultConfig default = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.xray.proxy.vmess.inbound.DefaultConfig, com.xray.proxy.vmess.inbound.DefaultConfig.Builder, com.xray.proxy.vmess.inbound.DefaultConfigOrBuilder> 
        getDefaultFieldBuilder() {
      if (defaultBuilder_ == null) {
        defaultBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.xray.proxy.vmess.inbound.DefaultConfig, com.xray.proxy.vmess.inbound.DefaultConfig.Builder, com.xray.proxy.vmess.inbound.DefaultConfigOrBuilder>(
                getDefault(),
                getParentForChildren(),
                isClean());
        default_ = null;
      }
      return defaultBuilder_;
    }

    private com.xray.proxy.vmess.inbound.DetourConfig detour_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.xray.proxy.vmess.inbound.DetourConfig, com.xray.proxy.vmess.inbound.DetourConfig.Builder, com.xray.proxy.vmess.inbound.DetourConfigOrBuilder> detourBuilder_;
    /**
     * <code>.xray.proxy.vmess.inbound.DetourConfig detour = 3;</code>
     * @return Whether the detour field is set.
     */
    public boolean hasDetour() {
      return ((bitField0_ & 0x00000004) != 0);
    }
    /**
     * <code>.xray.proxy.vmess.inbound.DetourConfig detour = 3;</code>
     * @return The detour.
     */
    public com.xray.proxy.vmess.inbound.DetourConfig getDetour() {
      if (detourBuilder_ == null) {
        return detour_ == null ? com.xray.proxy.vmess.inbound.DetourConfig.getDefaultInstance() : detour_;
      } else {
        return detourBuilder_.getMessage();
      }
    }
    /**
     * <code>.xray.proxy.vmess.inbound.DetourConfig detour = 3;</code>
     */
    public Builder setDetour(com.xray.proxy.vmess.inbound.DetourConfig value) {
      if (detourBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        detour_ = value;
      } else {
        detourBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>.xray.proxy.vmess.inbound.DetourConfig detour = 3;</code>
     */
    public Builder setDetour(
        com.xray.proxy.vmess.inbound.DetourConfig.Builder builderForValue) {
      if (detourBuilder_ == null) {
        detour_ = builderForValue.build();
      } else {
        detourBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>.xray.proxy.vmess.inbound.DetourConfig detour = 3;</code>
     */
    public Builder mergeDetour(com.xray.proxy.vmess.inbound.DetourConfig value) {
      if (detourBuilder_ == null) {
        if (((bitField0_ & 0x00000004) != 0) &&
          detour_ != null &&
          detour_ != com.xray.proxy.vmess.inbound.DetourConfig.getDefaultInstance()) {
          getDetourBuilder().mergeFrom(value);
        } else {
          detour_ = value;
        }
      } else {
        detourBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>.xray.proxy.vmess.inbound.DetourConfig detour = 3;</code>
     */
    public Builder clearDetour() {
      bitField0_ = (bitField0_ & ~0x00000004);
      detour_ = null;
      if (detourBuilder_ != null) {
        detourBuilder_.dispose();
        detourBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <code>.xray.proxy.vmess.inbound.DetourConfig detour = 3;</code>
     */
    public com.xray.proxy.vmess.inbound.DetourConfig.Builder getDetourBuilder() {
      bitField0_ |= 0x00000004;
      onChanged();
      return getDetourFieldBuilder().getBuilder();
    }
    /**
     * <code>.xray.proxy.vmess.inbound.DetourConfig detour = 3;</code>
     */
    public com.xray.proxy.vmess.inbound.DetourConfigOrBuilder getDetourOrBuilder() {
      if (detourBuilder_ != null) {
        return detourBuilder_.getMessageOrBuilder();
      } else {
        return detour_ == null ?
            com.xray.proxy.vmess.inbound.DetourConfig.getDefaultInstance() : detour_;
      }
    }
    /**
     * <code>.xray.proxy.vmess.inbound.DetourConfig detour = 3;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.xray.proxy.vmess.inbound.DetourConfig, com.xray.proxy.vmess.inbound.DetourConfig.Builder, com.xray.proxy.vmess.inbound.DetourConfigOrBuilder> 
        getDetourFieldBuilder() {
      if (detourBuilder_ == null) {
        detourBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.xray.proxy.vmess.inbound.DetourConfig, com.xray.proxy.vmess.inbound.DetourConfig.Builder, com.xray.proxy.vmess.inbound.DetourConfigOrBuilder>(
                getDetour(),
                getParentForChildren(),
                isClean());
        detour_ = null;
      }
      return detourBuilder_;
    }

    private boolean secureEncryptionOnly_ ;
    /**
     * <code>bool secure_encryption_only = 4;</code>
     * @return The secureEncryptionOnly.
     */
    @java.lang.Override
    public boolean getSecureEncryptionOnly() {
      return secureEncryptionOnly_;
    }
    /**
     * <code>bool secure_encryption_only = 4;</code>
     * @param value The secureEncryptionOnly to set.
     * @return This builder for chaining.
     */
    public Builder setSecureEncryptionOnly(boolean value) {
      
      secureEncryptionOnly_ = value;
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    /**
     * <code>bool secure_encryption_only = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearSecureEncryptionOnly() {
      bitField0_ = (bitField0_ & ~0x00000008);
      secureEncryptionOnly_ = false;
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


    // @@protoc_insertion_point(builder_scope:xray.proxy.vmess.inbound.Config)
  }

  // @@protoc_insertion_point(class_scope:xray.proxy.vmess.inbound.Config)
  private static final com.xray.proxy.vmess.inbound.Config DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.xray.proxy.vmess.inbound.Config();
  }

  public static com.xray.proxy.vmess.inbound.Config getDefaultInstance() {
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
  public com.xray.proxy.vmess.inbound.Config getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

