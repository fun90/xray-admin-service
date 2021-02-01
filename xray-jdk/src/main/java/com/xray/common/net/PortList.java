// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: common/net/port.proto

package com.xray.common.net;

/**
 * <pre>
 * PortList is a list of ports.
 * </pre>
 *
 * Protobuf type {@code xray.common.net.PortList}
 */
public  final class PortList extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:xray.common.net.PortList)
    PortListOrBuilder {
private static final long serialVersionUID = 0L;
  // Use PortList.newBuilder() to construct.
  private PortList(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private PortList() {
    range_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private PortList(
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
              range_ = new java.util.ArrayList<com.xray.common.net.PortRange>();
              mutable_bitField0_ |= 0x00000001;
            }
            range_.add(
                input.readMessage(com.xray.common.net.PortRange.parser(), extensionRegistry));
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
        range_ = java.util.Collections.unmodifiableList(range_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.xray.common.net.Port.internal_static_xray_common_net_PortList_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.xray.common.net.Port.internal_static_xray_common_net_PortList_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.xray.common.net.PortList.class, com.xray.common.net.PortList.Builder.class);
  }

  public static final int RANGE_FIELD_NUMBER = 1;
  private java.util.List<com.xray.common.net.PortRange> range_;
  /**
   * <code>repeated .xray.common.net.PortRange range = 1;</code>
   */
  public java.util.List<com.xray.common.net.PortRange> getRangeList() {
    return range_;
  }
  /**
   * <code>repeated .xray.common.net.PortRange range = 1;</code>
   */
  public java.util.List<? extends com.xray.common.net.PortRangeOrBuilder> 
      getRangeOrBuilderList() {
    return range_;
  }
  /**
   * <code>repeated .xray.common.net.PortRange range = 1;</code>
   */
  public int getRangeCount() {
    return range_.size();
  }
  /**
   * <code>repeated .xray.common.net.PortRange range = 1;</code>
   */
  public com.xray.common.net.PortRange getRange(int index) {
    return range_.get(index);
  }
  /**
   * <code>repeated .xray.common.net.PortRange range = 1;</code>
   */
  public com.xray.common.net.PortRangeOrBuilder getRangeOrBuilder(
      int index) {
    return range_.get(index);
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
    for (int i = 0; i < range_.size(); i++) {
      output.writeMessage(1, range_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < range_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, range_.get(i));
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
    if (!(obj instanceof com.xray.common.net.PortList)) {
      return super.equals(obj);
    }
    com.xray.common.net.PortList other = (com.xray.common.net.PortList) obj;

    if (!getRangeList()
        .equals(other.getRangeList())) return false;
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
    if (getRangeCount() > 0) {
      hash = (37 * hash) + RANGE_FIELD_NUMBER;
      hash = (53 * hash) + getRangeList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.xray.common.net.PortList parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.xray.common.net.PortList parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.xray.common.net.PortList parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.xray.common.net.PortList parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.xray.common.net.PortList parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.xray.common.net.PortList parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.xray.common.net.PortList parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.xray.common.net.PortList parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.xray.common.net.PortList parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.xray.common.net.PortList parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.xray.common.net.PortList parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.xray.common.net.PortList parseFrom(
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
  public static Builder newBuilder(com.xray.common.net.PortList prototype) {
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
   * <pre>
   * PortList is a list of ports.
   * </pre>
   *
   * Protobuf type {@code xray.common.net.PortList}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:xray.common.net.PortList)
      com.xray.common.net.PortListOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.xray.common.net.Port.internal_static_xray_common_net_PortList_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.xray.common.net.Port.internal_static_xray_common_net_PortList_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.xray.common.net.PortList.class, com.xray.common.net.PortList.Builder.class);
    }

    // Construct using com.xray.common.net.PortList.newBuilder()
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
        getRangeFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (rangeBuilder_ == null) {
        range_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        rangeBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.xray.common.net.Port.internal_static_xray_common_net_PortList_descriptor;
    }

    @java.lang.Override
    public com.xray.common.net.PortList getDefaultInstanceForType() {
      return com.xray.common.net.PortList.getDefaultInstance();
    }

    @java.lang.Override
    public com.xray.common.net.PortList build() {
      com.xray.common.net.PortList result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.xray.common.net.PortList buildPartial() {
      com.xray.common.net.PortList result = new com.xray.common.net.PortList(this);
      int from_bitField0_ = bitField0_;
      if (rangeBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          range_ = java.util.Collections.unmodifiableList(range_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.range_ = range_;
      } else {
        result.range_ = rangeBuilder_.build();
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
      if (other instanceof com.xray.common.net.PortList) {
        return mergeFrom((com.xray.common.net.PortList)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.xray.common.net.PortList other) {
      if (other == com.xray.common.net.PortList.getDefaultInstance()) return this;
      if (rangeBuilder_ == null) {
        if (!other.range_.isEmpty()) {
          if (range_.isEmpty()) {
            range_ = other.range_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureRangeIsMutable();
            range_.addAll(other.range_);
          }
          onChanged();
        }
      } else {
        if (!other.range_.isEmpty()) {
          if (rangeBuilder_.isEmpty()) {
            rangeBuilder_.dispose();
            rangeBuilder_ = null;
            range_ = other.range_;
            bitField0_ = (bitField0_ & ~0x00000001);
            rangeBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getRangeFieldBuilder() : null;
          } else {
            rangeBuilder_.addAllMessages(other.range_);
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
      com.xray.common.net.PortList parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.xray.common.net.PortList) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<com.xray.common.net.PortRange> range_ =
      java.util.Collections.emptyList();
    private void ensureRangeIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        range_ = new java.util.ArrayList<com.xray.common.net.PortRange>(range_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.xray.common.net.PortRange, com.xray.common.net.PortRange.Builder, com.xray.common.net.PortRangeOrBuilder> rangeBuilder_;

    /**
     * <code>repeated .xray.common.net.PortRange range = 1;</code>
     */
    public java.util.List<com.xray.common.net.PortRange> getRangeList() {
      if (rangeBuilder_ == null) {
        return java.util.Collections.unmodifiableList(range_);
      } else {
        return rangeBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .xray.common.net.PortRange range = 1;</code>
     */
    public int getRangeCount() {
      if (rangeBuilder_ == null) {
        return range_.size();
      } else {
        return rangeBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .xray.common.net.PortRange range = 1;</code>
     */
    public com.xray.common.net.PortRange getRange(int index) {
      if (rangeBuilder_ == null) {
        return range_.get(index);
      } else {
        return rangeBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .xray.common.net.PortRange range = 1;</code>
     */
    public Builder setRange(
        int index, com.xray.common.net.PortRange value) {
      if (rangeBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureRangeIsMutable();
        range_.set(index, value);
        onChanged();
      } else {
        rangeBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .xray.common.net.PortRange range = 1;</code>
     */
    public Builder setRange(
        int index, com.xray.common.net.PortRange.Builder builderForValue) {
      if (rangeBuilder_ == null) {
        ensureRangeIsMutable();
        range_.set(index, builderForValue.build());
        onChanged();
      } else {
        rangeBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .xray.common.net.PortRange range = 1;</code>
     */
    public Builder addRange(com.xray.common.net.PortRange value) {
      if (rangeBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureRangeIsMutable();
        range_.add(value);
        onChanged();
      } else {
        rangeBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .xray.common.net.PortRange range = 1;</code>
     */
    public Builder addRange(
        int index, com.xray.common.net.PortRange value) {
      if (rangeBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureRangeIsMutable();
        range_.add(index, value);
        onChanged();
      } else {
        rangeBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .xray.common.net.PortRange range = 1;</code>
     */
    public Builder addRange(
        com.xray.common.net.PortRange.Builder builderForValue) {
      if (rangeBuilder_ == null) {
        ensureRangeIsMutable();
        range_.add(builderForValue.build());
        onChanged();
      } else {
        rangeBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .xray.common.net.PortRange range = 1;</code>
     */
    public Builder addRange(
        int index, com.xray.common.net.PortRange.Builder builderForValue) {
      if (rangeBuilder_ == null) {
        ensureRangeIsMutable();
        range_.add(index, builderForValue.build());
        onChanged();
      } else {
        rangeBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .xray.common.net.PortRange range = 1;</code>
     */
    public Builder addAllRange(
        java.lang.Iterable<? extends com.xray.common.net.PortRange> values) {
      if (rangeBuilder_ == null) {
        ensureRangeIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, range_);
        onChanged();
      } else {
        rangeBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .xray.common.net.PortRange range = 1;</code>
     */
    public Builder clearRange() {
      if (rangeBuilder_ == null) {
        range_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        rangeBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .xray.common.net.PortRange range = 1;</code>
     */
    public Builder removeRange(int index) {
      if (rangeBuilder_ == null) {
        ensureRangeIsMutable();
        range_.remove(index);
        onChanged();
      } else {
        rangeBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .xray.common.net.PortRange range = 1;</code>
     */
    public com.xray.common.net.PortRange.Builder getRangeBuilder(
        int index) {
      return getRangeFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .xray.common.net.PortRange range = 1;</code>
     */
    public com.xray.common.net.PortRangeOrBuilder getRangeOrBuilder(
        int index) {
      if (rangeBuilder_ == null) {
        return range_.get(index);  } else {
        return rangeBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .xray.common.net.PortRange range = 1;</code>
     */
    public java.util.List<? extends com.xray.common.net.PortRangeOrBuilder> 
         getRangeOrBuilderList() {
      if (rangeBuilder_ != null) {
        return rangeBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(range_);
      }
    }
    /**
     * <code>repeated .xray.common.net.PortRange range = 1;</code>
     */
    public com.xray.common.net.PortRange.Builder addRangeBuilder() {
      return getRangeFieldBuilder().addBuilder(
          com.xray.common.net.PortRange.getDefaultInstance());
    }
    /**
     * <code>repeated .xray.common.net.PortRange range = 1;</code>
     */
    public com.xray.common.net.PortRange.Builder addRangeBuilder(
        int index) {
      return getRangeFieldBuilder().addBuilder(
          index, com.xray.common.net.PortRange.getDefaultInstance());
    }
    /**
     * <code>repeated .xray.common.net.PortRange range = 1;</code>
     */
    public java.util.List<com.xray.common.net.PortRange.Builder> 
         getRangeBuilderList() {
      return getRangeFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.xray.common.net.PortRange, com.xray.common.net.PortRange.Builder, com.xray.common.net.PortRangeOrBuilder> 
        getRangeFieldBuilder() {
      if (rangeBuilder_ == null) {
        rangeBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.xray.common.net.PortRange, com.xray.common.net.PortRange.Builder, com.xray.common.net.PortRangeOrBuilder>(
                range_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        range_ = null;
      }
      return rangeBuilder_;
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


    // @@protoc_insertion_point(builder_scope:xray.common.net.PortList)
  }

  // @@protoc_insertion_point(class_scope:xray.common.net.PortList)
  private static final com.xray.common.net.PortList DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.xray.common.net.PortList();
  }

  public static com.xray.common.net.PortList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<PortList>
      PARSER = new com.google.protobuf.AbstractParser<PortList>() {
    @java.lang.Override
    public PortList parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new PortList(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<PortList> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<PortList> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.xray.common.net.PortList getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

