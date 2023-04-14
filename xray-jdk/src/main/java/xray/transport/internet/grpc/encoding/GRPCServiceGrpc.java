package xray.transport.internet.grpc.encoding;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.21.0)",
    comments = "Source: transport/internet/grpc/encoding/stream.proto")
public final class GRPCServiceGrpc {

  private GRPCServiceGrpc() {}

  public static final String SERVICE_NAME = "xray.transport.internet.grpc.encoding.GRPCService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<xray.transport.internet.grpc.encoding.Stream.Hunk,
      xray.transport.internet.grpc.encoding.Stream.Hunk> getTunMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Tun",
      requestType = xray.transport.internet.grpc.encoding.Stream.Hunk.class,
      responseType = xray.transport.internet.grpc.encoding.Stream.Hunk.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<xray.transport.internet.grpc.encoding.Stream.Hunk,
      xray.transport.internet.grpc.encoding.Stream.Hunk> getTunMethod() {
    io.grpc.MethodDescriptor<xray.transport.internet.grpc.encoding.Stream.Hunk, xray.transport.internet.grpc.encoding.Stream.Hunk> getTunMethod;
    if ((getTunMethod = GRPCServiceGrpc.getTunMethod) == null) {
      synchronized (GRPCServiceGrpc.class) {
        if ((getTunMethod = GRPCServiceGrpc.getTunMethod) == null) {
          GRPCServiceGrpc.getTunMethod = getTunMethod = 
              io.grpc.MethodDescriptor.<xray.transport.internet.grpc.encoding.Stream.Hunk, xray.transport.internet.grpc.encoding.Stream.Hunk>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "xray.transport.internet.grpc.encoding.GRPCService", "Tun"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  xray.transport.internet.grpc.encoding.Stream.Hunk.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  xray.transport.internet.grpc.encoding.Stream.Hunk.getDefaultInstance()))
                  .setSchemaDescriptor(new GRPCServiceMethodDescriptorSupplier("Tun"))
                  .build();
          }
        }
     }
     return getTunMethod;
  }

  private static volatile io.grpc.MethodDescriptor<xray.transport.internet.grpc.encoding.Stream.MultiHunk,
      xray.transport.internet.grpc.encoding.Stream.MultiHunk> getTunMultiMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TunMulti",
      requestType = xray.transport.internet.grpc.encoding.Stream.MultiHunk.class,
      responseType = xray.transport.internet.grpc.encoding.Stream.MultiHunk.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<xray.transport.internet.grpc.encoding.Stream.MultiHunk,
      xray.transport.internet.grpc.encoding.Stream.MultiHunk> getTunMultiMethod() {
    io.grpc.MethodDescriptor<xray.transport.internet.grpc.encoding.Stream.MultiHunk, xray.transport.internet.grpc.encoding.Stream.MultiHunk> getTunMultiMethod;
    if ((getTunMultiMethod = GRPCServiceGrpc.getTunMultiMethod) == null) {
      synchronized (GRPCServiceGrpc.class) {
        if ((getTunMultiMethod = GRPCServiceGrpc.getTunMultiMethod) == null) {
          GRPCServiceGrpc.getTunMultiMethod = getTunMultiMethod = 
              io.grpc.MethodDescriptor.<xray.transport.internet.grpc.encoding.Stream.MultiHunk, xray.transport.internet.grpc.encoding.Stream.MultiHunk>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "xray.transport.internet.grpc.encoding.GRPCService", "TunMulti"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  xray.transport.internet.grpc.encoding.Stream.MultiHunk.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  xray.transport.internet.grpc.encoding.Stream.MultiHunk.getDefaultInstance()))
                  .setSchemaDescriptor(new GRPCServiceMethodDescriptorSupplier("TunMulti"))
                  .build();
          }
        }
     }
     return getTunMultiMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GRPCServiceStub newStub(io.grpc.Channel channel) {
    return new GRPCServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GRPCServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new GRPCServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GRPCServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new GRPCServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class GRPCServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<xray.transport.internet.grpc.encoding.Stream.Hunk> tun(
        io.grpc.stub.StreamObserver<xray.transport.internet.grpc.encoding.Stream.Hunk> responseObserver) {
      return asyncUnimplementedStreamingCall(getTunMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<xray.transport.internet.grpc.encoding.Stream.MultiHunk> tunMulti(
        io.grpc.stub.StreamObserver<xray.transport.internet.grpc.encoding.Stream.MultiHunk> responseObserver) {
      return asyncUnimplementedStreamingCall(getTunMultiMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getTunMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                xray.transport.internet.grpc.encoding.Stream.Hunk,
                xray.transport.internet.grpc.encoding.Stream.Hunk>(
                  this, METHODID_TUN)))
          .addMethod(
            getTunMultiMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                xray.transport.internet.grpc.encoding.Stream.MultiHunk,
                xray.transport.internet.grpc.encoding.Stream.MultiHunk>(
                  this, METHODID_TUN_MULTI)))
          .build();
    }
  }

  /**
   */
  public static final class GRPCServiceStub extends io.grpc.stub.AbstractStub<GRPCServiceStub> {
    private GRPCServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GRPCServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GRPCServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GRPCServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<xray.transport.internet.grpc.encoding.Stream.Hunk> tun(
        io.grpc.stub.StreamObserver<xray.transport.internet.grpc.encoding.Stream.Hunk> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getTunMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<xray.transport.internet.grpc.encoding.Stream.MultiHunk> tunMulti(
        io.grpc.stub.StreamObserver<xray.transport.internet.grpc.encoding.Stream.MultiHunk> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getTunMultiMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class GRPCServiceBlockingStub extends io.grpc.stub.AbstractStub<GRPCServiceBlockingStub> {
    private GRPCServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GRPCServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GRPCServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GRPCServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class GRPCServiceFutureStub extends io.grpc.stub.AbstractStub<GRPCServiceFutureStub> {
    private GRPCServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GRPCServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GRPCServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GRPCServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_TUN = 0;
  private static final int METHODID_TUN_MULTI = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GRPCServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GRPCServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_TUN:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.tun(
              (io.grpc.stub.StreamObserver<xray.transport.internet.grpc.encoding.Stream.Hunk>) responseObserver);
        case METHODID_TUN_MULTI:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.tunMulti(
              (io.grpc.stub.StreamObserver<xray.transport.internet.grpc.encoding.Stream.MultiHunk>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class GRPCServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GRPCServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return xray.transport.internet.grpc.encoding.Stream.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GRPCService");
    }
  }

  private static final class GRPCServiceFileDescriptorSupplier
      extends GRPCServiceBaseDescriptorSupplier {
    GRPCServiceFileDescriptorSupplier() {}
  }

  private static final class GRPCServiceMethodDescriptorSupplier
      extends GRPCServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GRPCServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (GRPCServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GRPCServiceFileDescriptorSupplier())
              .addMethod(getTunMethod())
              .addMethod(getTunMultiMethod())
              .build();
        }
      }
    }
    return result;
  }
}
