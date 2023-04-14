package com.xray.core.app.observatory.command;

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
    comments = "Source: app/observatory/command/command.proto")
public final class ObservatoryServiceGrpc {

  private ObservatoryServiceGrpc() {}

  public static final String SERVICE_NAME = "xray.core.app.observatory.command.ObservatoryService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.xray.core.app.observatory.command.GetOutboundStatusRequest,
      com.xray.core.app.observatory.command.GetOutboundStatusResponse> getGetOutboundStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetOutboundStatus",
      requestType = com.xray.core.app.observatory.command.GetOutboundStatusRequest.class,
      responseType = com.xray.core.app.observatory.command.GetOutboundStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.xray.core.app.observatory.command.GetOutboundStatusRequest,
      com.xray.core.app.observatory.command.GetOutboundStatusResponse> getGetOutboundStatusMethod() {
    io.grpc.MethodDescriptor<com.xray.core.app.observatory.command.GetOutboundStatusRequest, com.xray.core.app.observatory.command.GetOutboundStatusResponse> getGetOutboundStatusMethod;
    if ((getGetOutboundStatusMethod = ObservatoryServiceGrpc.getGetOutboundStatusMethod) == null) {
      synchronized (ObservatoryServiceGrpc.class) {
        if ((getGetOutboundStatusMethod = ObservatoryServiceGrpc.getGetOutboundStatusMethod) == null) {
          ObservatoryServiceGrpc.getGetOutboundStatusMethod = getGetOutboundStatusMethod = 
              io.grpc.MethodDescriptor.<com.xray.core.app.observatory.command.GetOutboundStatusRequest, com.xray.core.app.observatory.command.GetOutboundStatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "xray.core.app.observatory.command.ObservatoryService", "GetOutboundStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.xray.core.app.observatory.command.GetOutboundStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.xray.core.app.observatory.command.GetOutboundStatusResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ObservatoryServiceMethodDescriptorSupplier("GetOutboundStatus"))
                  .build();
          }
        }
     }
     return getGetOutboundStatusMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ObservatoryServiceStub newStub(io.grpc.Channel channel) {
    return new ObservatoryServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ObservatoryServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ObservatoryServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ObservatoryServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ObservatoryServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ObservatoryServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getOutboundStatus(com.xray.core.app.observatory.command.GetOutboundStatusRequest request,
        io.grpc.stub.StreamObserver<com.xray.core.app.observatory.command.GetOutboundStatusResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetOutboundStatusMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetOutboundStatusMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.xray.core.app.observatory.command.GetOutboundStatusRequest,
                com.xray.core.app.observatory.command.GetOutboundStatusResponse>(
                  this, METHODID_GET_OUTBOUND_STATUS)))
          .build();
    }
  }

  /**
   */
  public static final class ObservatoryServiceStub extends io.grpc.stub.AbstractStub<ObservatoryServiceStub> {
    private ObservatoryServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ObservatoryServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ObservatoryServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ObservatoryServiceStub(channel, callOptions);
    }

    /**
     */
    public void getOutboundStatus(com.xray.core.app.observatory.command.GetOutboundStatusRequest request,
        io.grpc.stub.StreamObserver<com.xray.core.app.observatory.command.GetOutboundStatusResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetOutboundStatusMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ObservatoryServiceBlockingStub extends io.grpc.stub.AbstractStub<ObservatoryServiceBlockingStub> {
    private ObservatoryServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ObservatoryServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ObservatoryServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ObservatoryServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.xray.core.app.observatory.command.GetOutboundStatusResponse getOutboundStatus(com.xray.core.app.observatory.command.GetOutboundStatusRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetOutboundStatusMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ObservatoryServiceFutureStub extends io.grpc.stub.AbstractStub<ObservatoryServiceFutureStub> {
    private ObservatoryServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ObservatoryServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ObservatoryServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ObservatoryServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.xray.core.app.observatory.command.GetOutboundStatusResponse> getOutboundStatus(
        com.xray.core.app.observatory.command.GetOutboundStatusRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetOutboundStatusMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_OUTBOUND_STATUS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ObservatoryServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ObservatoryServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_OUTBOUND_STATUS:
          serviceImpl.getOutboundStatus((com.xray.core.app.observatory.command.GetOutboundStatusRequest) request,
              (io.grpc.stub.StreamObserver<com.xray.core.app.observatory.command.GetOutboundStatusResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ObservatoryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ObservatoryServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.xray.core.app.observatory.command.Command.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ObservatoryService");
    }
  }

  private static final class ObservatoryServiceFileDescriptorSupplier
      extends ObservatoryServiceBaseDescriptorSupplier {
    ObservatoryServiceFileDescriptorSupplier() {}
  }

  private static final class ObservatoryServiceMethodDescriptorSupplier
      extends ObservatoryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ObservatoryServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ObservatoryServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ObservatoryServiceFileDescriptorSupplier())
              .addMethod(getGetOutboundStatusMethod())
              .build();
        }
      }
    }
    return result;
  }
}
