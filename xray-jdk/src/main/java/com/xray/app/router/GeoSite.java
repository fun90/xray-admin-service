// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: app/router/config.proto

package com.xray.app.router;

/**
 * Protobuf type {@code xray.app.router.GeoSite}
 */
public final class GeoSite extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:xray.app.router.GeoSite)
    GeoSiteOrBuilder {
private static final long serialVersionUID = 0L;
  // Use GeoSite.newBuilder() to construct.
  private GeoSite(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GeoSite() {
    countryCode_ = "";
    domain_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new GeoSite();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.xray.app.router.ConfigOuterClass.internal_static_xray_app_router_GeoSite_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.xray.app.router.ConfigOuterClass.internal_static_xray_app_router_GeoSite_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.xray.app.router.GeoSite.class, com.xray.app.router.GeoSite.Builder.class);
  }

  public static final int COUNTRY_CODE_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private volatile java.lang.Object countryCode_ = "";
  /**
   * <code>string country_code = 1;</code>
   * @return The countryCode.
   */
  @java.lang.Override
  public java.lang.String getCountryCode() {
    java.lang.Object ref = countryCode_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      countryCode_ = s;
      return s;
    }
  }
  /**
   * <code>string country_code = 1;</code>
   * @return The bytes for countryCode.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getCountryCodeBytes() {
    java.lang.Object ref = countryCode_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      countryCode_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int DOMAIN_FIELD_NUMBER = 2;
  @SuppressWarnings("serial")
  private java.util.List<com.xray.app.router.Domain> domain_;
  /**
   * <code>repeated .xray.app.router.Domain domain = 2;</code>
   */
  @java.lang.Override
  public java.util.List<com.xray.app.router.Domain> getDomainList() {
    return domain_;
  }
  /**
   * <code>repeated .xray.app.router.Domain domain = 2;</code>
   */
  @java.lang.Override
  public java.util.List<? extends com.xray.app.router.DomainOrBuilder> 
      getDomainOrBuilderList() {
    return domain_;
  }
  /**
   * <code>repeated .xray.app.router.Domain domain = 2;</code>
   */
  @java.lang.Override
  public int getDomainCount() {
    return domain_.size();
  }
  /**
   * <code>repeated .xray.app.router.Domain domain = 2;</code>
   */
  @java.lang.Override
  public com.xray.app.router.Domain getDomain(int index) {
    return domain_.get(index);
  }
  /**
   * <code>repeated .xray.app.router.Domain domain = 2;</code>
   */
  @java.lang.Override
  public com.xray.app.router.DomainOrBuilder getDomainOrBuilder(
      int index) {
    return domain_.get(index);
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
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(countryCode_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, countryCode_);
    }
    for (int i = 0; i < domain_.size(); i++) {
      output.writeMessage(2, domain_.get(i));
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(countryCode_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, countryCode_);
    }
    for (int i = 0; i < domain_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, domain_.get(i));
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
    if (!(obj instanceof com.xray.app.router.GeoSite)) {
      return super.equals(obj);
    }
    com.xray.app.router.GeoSite other = (com.xray.app.router.GeoSite) obj;

    if (!getCountryCode()
        .equals(other.getCountryCode())) return false;
    if (!getDomainList()
        .equals(other.getDomainList())) return false;
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
    hash = (37 * hash) + COUNTRY_CODE_FIELD_NUMBER;
    hash = (53 * hash) + getCountryCode().hashCode();
    if (getDomainCount() > 0) {
      hash = (37 * hash) + DOMAIN_FIELD_NUMBER;
      hash = (53 * hash) + getDomainList().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.xray.app.router.GeoSite parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.xray.app.router.GeoSite parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.xray.app.router.GeoSite parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.xray.app.router.GeoSite parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.xray.app.router.GeoSite parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.xray.app.router.GeoSite parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.xray.app.router.GeoSite parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.xray.app.router.GeoSite parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.xray.app.router.GeoSite parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.xray.app.router.GeoSite parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.xray.app.router.GeoSite parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.xray.app.router.GeoSite parseFrom(
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
  public static Builder newBuilder(com.xray.app.router.GeoSite prototype) {
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
   * Protobuf type {@code xray.app.router.GeoSite}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:xray.app.router.GeoSite)
      com.xray.app.router.GeoSiteOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.xray.app.router.ConfigOuterClass.internal_static_xray_app_router_GeoSite_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.xray.app.router.ConfigOuterClass.internal_static_xray_app_router_GeoSite_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.xray.app.router.GeoSite.class, com.xray.app.router.GeoSite.Builder.class);
    }

    // Construct using com.xray.app.router.GeoSite.newBuilder()
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
      countryCode_ = "";
      if (domainBuilder_ == null) {
        domain_ = java.util.Collections.emptyList();
      } else {
        domain_ = null;
        domainBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.xray.app.router.ConfigOuterClass.internal_static_xray_app_router_GeoSite_descriptor;
    }

    @java.lang.Override
    public com.xray.app.router.GeoSite getDefaultInstanceForType() {
      return com.xray.app.router.GeoSite.getDefaultInstance();
    }

    @java.lang.Override
    public com.xray.app.router.GeoSite build() {
      com.xray.app.router.GeoSite result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.xray.app.router.GeoSite buildPartial() {
      com.xray.app.router.GeoSite result = new com.xray.app.router.GeoSite(this);
      buildPartialRepeatedFields(result);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartialRepeatedFields(com.xray.app.router.GeoSite result) {
      if (domainBuilder_ == null) {
        if (((bitField0_ & 0x00000002) != 0)) {
          domain_ = java.util.Collections.unmodifiableList(domain_);
          bitField0_ = (bitField0_ & ~0x00000002);
        }
        result.domain_ = domain_;
      } else {
        result.domain_ = domainBuilder_.build();
      }
    }

    private void buildPartial0(com.xray.app.router.GeoSite result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.countryCode_ = countryCode_;
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
      if (other instanceof com.xray.app.router.GeoSite) {
        return mergeFrom((com.xray.app.router.GeoSite)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.xray.app.router.GeoSite other) {
      if (other == com.xray.app.router.GeoSite.getDefaultInstance()) return this;
      if (!other.getCountryCode().isEmpty()) {
        countryCode_ = other.countryCode_;
        bitField0_ |= 0x00000001;
        onChanged();
      }
      if (domainBuilder_ == null) {
        if (!other.domain_.isEmpty()) {
          if (domain_.isEmpty()) {
            domain_ = other.domain_;
            bitField0_ = (bitField0_ & ~0x00000002);
          } else {
            ensureDomainIsMutable();
            domain_.addAll(other.domain_);
          }
          onChanged();
        }
      } else {
        if (!other.domain_.isEmpty()) {
          if (domainBuilder_.isEmpty()) {
            domainBuilder_.dispose();
            domainBuilder_ = null;
            domain_ = other.domain_;
            bitField0_ = (bitField0_ & ~0x00000002);
            domainBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getDomainFieldBuilder() : null;
          } else {
            domainBuilder_.addAllMessages(other.domain_);
          }
        }
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
              countryCode_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 18: {
              com.xray.app.router.Domain m =
                  input.readMessage(
                      com.xray.app.router.Domain.parser(),
                      extensionRegistry);
              if (domainBuilder_ == null) {
                ensureDomainIsMutable();
                domain_.add(m);
              } else {
                domainBuilder_.addMessage(m);
              }
              break;
            } // case 18
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

    private java.lang.Object countryCode_ = "";
    /**
     * <code>string country_code = 1;</code>
     * @return The countryCode.
     */
    public java.lang.String getCountryCode() {
      java.lang.Object ref = countryCode_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        countryCode_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string country_code = 1;</code>
     * @return The bytes for countryCode.
     */
    public com.google.protobuf.ByteString
        getCountryCodeBytes() {
      java.lang.Object ref = countryCode_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        countryCode_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string country_code = 1;</code>
     * @param value The countryCode to set.
     * @return This builder for chaining.
     */
    public Builder setCountryCode(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      countryCode_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>string country_code = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearCountryCode() {
      countryCode_ = getDefaultInstance().getCountryCode();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>string country_code = 1;</code>
     * @param value The bytes for countryCode to set.
     * @return This builder for chaining.
     */
    public Builder setCountryCodeBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      countryCode_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    private java.util.List<com.xray.app.router.Domain> domain_ =
      java.util.Collections.emptyList();
    private void ensureDomainIsMutable() {
      if (!((bitField0_ & 0x00000002) != 0)) {
        domain_ = new java.util.ArrayList<com.xray.app.router.Domain>(domain_);
        bitField0_ |= 0x00000002;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.xray.app.router.Domain, com.xray.app.router.Domain.Builder, com.xray.app.router.DomainOrBuilder> domainBuilder_;

    /**
     * <code>repeated .xray.app.router.Domain domain = 2;</code>
     */
    public java.util.List<com.xray.app.router.Domain> getDomainList() {
      if (domainBuilder_ == null) {
        return java.util.Collections.unmodifiableList(domain_);
      } else {
        return domainBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .xray.app.router.Domain domain = 2;</code>
     */
    public int getDomainCount() {
      if (domainBuilder_ == null) {
        return domain_.size();
      } else {
        return domainBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .xray.app.router.Domain domain = 2;</code>
     */
    public com.xray.app.router.Domain getDomain(int index) {
      if (domainBuilder_ == null) {
        return domain_.get(index);
      } else {
        return domainBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .xray.app.router.Domain domain = 2;</code>
     */
    public Builder setDomain(
        int index, com.xray.app.router.Domain value) {
      if (domainBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDomainIsMutable();
        domain_.set(index, value);
        onChanged();
      } else {
        domainBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .xray.app.router.Domain domain = 2;</code>
     */
    public Builder setDomain(
        int index, com.xray.app.router.Domain.Builder builderForValue) {
      if (domainBuilder_ == null) {
        ensureDomainIsMutable();
        domain_.set(index, builderForValue.build());
        onChanged();
      } else {
        domainBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .xray.app.router.Domain domain = 2;</code>
     */
    public Builder addDomain(com.xray.app.router.Domain value) {
      if (domainBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDomainIsMutable();
        domain_.add(value);
        onChanged();
      } else {
        domainBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .xray.app.router.Domain domain = 2;</code>
     */
    public Builder addDomain(
        int index, com.xray.app.router.Domain value) {
      if (domainBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDomainIsMutable();
        domain_.add(index, value);
        onChanged();
      } else {
        domainBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .xray.app.router.Domain domain = 2;</code>
     */
    public Builder addDomain(
        com.xray.app.router.Domain.Builder builderForValue) {
      if (domainBuilder_ == null) {
        ensureDomainIsMutable();
        domain_.add(builderForValue.build());
        onChanged();
      } else {
        domainBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .xray.app.router.Domain domain = 2;</code>
     */
    public Builder addDomain(
        int index, com.xray.app.router.Domain.Builder builderForValue) {
      if (domainBuilder_ == null) {
        ensureDomainIsMutable();
        domain_.add(index, builderForValue.build());
        onChanged();
      } else {
        domainBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .xray.app.router.Domain domain = 2;</code>
     */
    public Builder addAllDomain(
        java.lang.Iterable<? extends com.xray.app.router.Domain> values) {
      if (domainBuilder_ == null) {
        ensureDomainIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, domain_);
        onChanged();
      } else {
        domainBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .xray.app.router.Domain domain = 2;</code>
     */
    public Builder clearDomain() {
      if (domainBuilder_ == null) {
        domain_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000002);
        onChanged();
      } else {
        domainBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .xray.app.router.Domain domain = 2;</code>
     */
    public Builder removeDomain(int index) {
      if (domainBuilder_ == null) {
        ensureDomainIsMutable();
        domain_.remove(index);
        onChanged();
      } else {
        domainBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .xray.app.router.Domain domain = 2;</code>
     */
    public com.xray.app.router.Domain.Builder getDomainBuilder(
        int index) {
      return getDomainFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .xray.app.router.Domain domain = 2;</code>
     */
    public com.xray.app.router.DomainOrBuilder getDomainOrBuilder(
        int index) {
      if (domainBuilder_ == null) {
        return domain_.get(index);  } else {
        return domainBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .xray.app.router.Domain domain = 2;</code>
     */
    public java.util.List<? extends com.xray.app.router.DomainOrBuilder> 
         getDomainOrBuilderList() {
      if (domainBuilder_ != null) {
        return domainBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(domain_);
      }
    }
    /**
     * <code>repeated .xray.app.router.Domain domain = 2;</code>
     */
    public com.xray.app.router.Domain.Builder addDomainBuilder() {
      return getDomainFieldBuilder().addBuilder(
          com.xray.app.router.Domain.getDefaultInstance());
    }
    /**
     * <code>repeated .xray.app.router.Domain domain = 2;</code>
     */
    public com.xray.app.router.Domain.Builder addDomainBuilder(
        int index) {
      return getDomainFieldBuilder().addBuilder(
          index, com.xray.app.router.Domain.getDefaultInstance());
    }
    /**
     * <code>repeated .xray.app.router.Domain domain = 2;</code>
     */
    public java.util.List<com.xray.app.router.Domain.Builder> 
         getDomainBuilderList() {
      return getDomainFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.xray.app.router.Domain, com.xray.app.router.Domain.Builder, com.xray.app.router.DomainOrBuilder> 
        getDomainFieldBuilder() {
      if (domainBuilder_ == null) {
        domainBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.xray.app.router.Domain, com.xray.app.router.Domain.Builder, com.xray.app.router.DomainOrBuilder>(
                domain_,
                ((bitField0_ & 0x00000002) != 0),
                getParentForChildren(),
                isClean());
        domain_ = null;
      }
      return domainBuilder_;
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


    // @@protoc_insertion_point(builder_scope:xray.app.router.GeoSite)
  }

  // @@protoc_insertion_point(class_scope:xray.app.router.GeoSite)
  private static final com.xray.app.router.GeoSite DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.xray.app.router.GeoSite();
  }

  public static com.xray.app.router.GeoSite getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GeoSite>
      PARSER = new com.google.protobuf.AbstractParser<GeoSite>() {
    @java.lang.Override
    public GeoSite parsePartialFrom(
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

  public static com.google.protobuf.Parser<GeoSite> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GeoSite> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.xray.app.router.GeoSite getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

