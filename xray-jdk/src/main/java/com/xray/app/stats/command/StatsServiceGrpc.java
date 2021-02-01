package com.xray.app.stats.command;

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
    comments = "Source: app/stats/command/command.proto")
public final class StatsServiceGrpc {

  private StatsServiceGrpc() {}

  public static final String SERVICE_NAME = "xray.app.stats.command.StatsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.xray.app.stats.command.GetStatsRequest,
      com.xray.app.stats.command.GetStatsResponse> getGetStatsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStats",
      requestType = com.xray.app.stats.command.GetStatsRequest.class,
      responseType = com.xray.app.stats.command.GetStatsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.xray.app.stats.command.GetStatsRequest,
      com.xray.app.stats.command.GetStatsResponse> getGetStatsMethod() {
    io.grpc.MethodDescriptor<com.xray.app.stats.command.GetStatsRequest, com.xray.app.stats.command.GetStatsResponse> getGetStatsMethod;
    if ((getGetStatsMethod = StatsServiceGrpc.getGetStatsMethod) == null) {
      synchronized (StatsServiceGrpc.class) {
        if ((getGetStatsMethod = StatsServiceGrpc.getGetStatsMethod) == null) {
          StatsServiceGrpc.getGetStatsMethod = getGetStatsMethod = 
              io.grpc.MethodDescriptor.<com.xray.app.stats.command.GetStatsRequest, com.xray.app.stats.command.GetStatsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "xray.app.stats.command.StatsService", "GetStats"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.xray.app.stats.command.GetStatsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.xray.app.stats.command.GetStatsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StatsServiceMethodDescriptorSupplier("GetStats"))
                  .build();
          }
        }
     }
     return getGetStatsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.xray.app.stats.command.QueryStatsRequest,
      com.xray.app.stats.command.QueryStatsResponse> getQueryStatsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "QueryStats",
      requestType = com.xray.app.stats.command.QueryStatsRequest.class,
      responseType = com.xray.app.stats.command.QueryStatsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.xray.app.stats.command.QueryStatsRequest,
      com.xray.app.stats.command.QueryStatsResponse> getQueryStatsMethod() {
    io.grpc.MethodDescriptor<com.xray.app.stats.command.QueryStatsRequest, com.xray.app.stats.command.QueryStatsResponse> getQueryStatsMethod;
    if ((getQueryStatsMethod = StatsServiceGrpc.getQueryStatsMethod) == null) {
      synchronized (StatsServiceGrpc.class) {
        if ((getQueryStatsMethod = StatsServiceGrpc.getQueryStatsMethod) == null) {
          StatsServiceGrpc.getQueryStatsMethod = getQueryStatsMethod = 
              io.grpc.MethodDescriptor.<com.xray.app.stats.command.QueryStatsRequest, com.xray.app.stats.command.QueryStatsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "xray.app.stats.command.StatsService", "QueryStats"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.xray.app.stats.command.QueryStatsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.xray.app.stats.command.QueryStatsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StatsServiceMethodDescriptorSupplier("QueryStats"))
                  .build();
          }
        }
     }
     return getQueryStatsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.xray.app.stats.command.SysStatsRequest,
      com.xray.app.stats.command.SysStatsResponse> getGetSysStatsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSysStats",
      requestType = com.xray.app.stats.command.SysStatsRequest.class,
      responseType = com.xray.app.stats.command.SysStatsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.xray.app.stats.command.SysStatsRequest,
      com.xray.app.stats.command.SysStatsResponse> getGetSysStatsMethod() {
    io.grpc.MethodDescriptor<com.xray.app.stats.command.SysStatsRequest, com.xray.app.stats.command.SysStatsResponse> getGetSysStatsMethod;
    if ((getGetSysStatsMethod = StatsServiceGrpc.getGetSysStatsMethod) == null) {
      synchronized (StatsServiceGrpc.class) {
        if ((getGetSysStatsMethod = StatsServiceGrpc.getGetSysStatsMethod) == null) {
          StatsServiceGrpc.getGetSysStatsMethod = getGetSysStatsMethod = 
              io.grpc.MethodDescriptor.<com.xray.app.stats.command.SysStatsRequest, com.xray.app.stats.command.SysStatsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "xray.app.stats.command.StatsService", "GetSysStats"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.xray.app.stats.command.SysStatsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.xray.app.stats.command.SysStatsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StatsServiceMethodDescriptorSupplier("GetSysStats"))
                  .build();
          }
        }
     }
     return getGetSysStatsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StatsServiceStub newStub(io.grpc.Channel channel) {
    return new StatsServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StatsServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new StatsServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StatsServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new StatsServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class StatsServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getStats(com.xray.app.stats.command.GetStatsRequest request,
        io.grpc.stub.StreamObserver<com.xray.app.stats.command.GetStatsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetStatsMethod(), responseObserver);
    }

    /**
     */
    public void queryStats(com.xray.app.stats.command.QueryStatsRequest request,
        io.grpc.stub.StreamObserver<com.xray.app.stats.command.QueryStatsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getQueryStatsMethod(), responseObserver);
    }

    /**
     */
    public void getSysStats(com.xray.app.stats.command.SysStatsRequest request,
        io.grpc.stub.StreamObserver<com.xray.app.stats.command.SysStatsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetSysStatsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetStatsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.xray.app.stats.command.GetStatsRequest,
                com.xray.app.stats.command.GetStatsResponse>(
                  this, METHODID_GET_STATS)))
          .addMethod(
            getQueryStatsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.xray.app.stats.command.QueryStatsRequest,
                com.xray.app.stats.command.QueryStatsResponse>(
                  this, METHODID_QUERY_STATS)))
          .addMethod(
            getGetSysStatsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.xray.app.stats.command.SysStatsRequest,
                com.xray.app.stats.command.SysStatsResponse>(
                  this, METHODID_GET_SYS_STATS)))
          .build();
    }
  }

  /**
   */
  public static final class StatsServiceStub extends io.grpc.stub.AbstractStub<StatsServiceStub> {
    private StatsServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StatsServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StatsServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StatsServiceStub(channel, callOptions);
    }

    /**
     */
    public void getStats(com.xray.app.stats.command.GetStatsRequest request,
        io.grpc.stub.StreamObserver<com.xray.app.stats.command.GetStatsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetStatsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void queryStats(com.xray.app.stats.command.QueryStatsRequest request,
        io.grpc.stub.StreamObserver<com.xray.app.stats.command.QueryStatsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getQueryStatsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getSysStats(com.xray.app.stats.command.SysStatsRequest request,
        io.grpc.stub.StreamObserver<com.xray.app.stats.command.SysStatsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetSysStatsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class StatsServiceBlockingStub extends io.grpc.stub.AbstractStub<StatsServiceBlockingStub> {
    private StatsServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StatsServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StatsServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StatsServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.xray.app.stats.command.GetStatsResponse getStats(com.xray.app.stats.command.GetStatsRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetStatsMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.xray.app.stats.command.QueryStatsResponse queryStats(com.xray.app.stats.command.QueryStatsRequest request) {
      return blockingUnaryCall(
          getChannel(), getQueryStatsMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.xray.app.stats.command.SysStatsResponse getSysStats(com.xray.app.stats.command.SysStatsRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetSysStatsMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class StatsServiceFutureStub extends io.grpc.stub.AbstractStub<StatsServiceFutureStub> {
    private StatsServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StatsServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StatsServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StatsServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.xray.app.stats.command.GetStatsResponse> getStats(
        com.xray.app.stats.command.GetStatsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetStatsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.xray.app.stats.command.QueryStatsResponse> queryStats(
        com.xray.app.stats.command.QueryStatsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getQueryStatsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.xray.app.stats.command.SysStatsResponse> getSysStats(
        com.xray.app.stats.command.SysStatsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetSysStatsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_STATS = 0;
  private static final int METHODID_QUERY_STATS = 1;
  private static final int METHODID_GET_SYS_STATS = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final StatsServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(StatsServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_STATS:
          serviceImpl.getStats((com.xray.app.stats.command.GetStatsRequest) request,
              (io.grpc.stub.StreamObserver<com.xray.app.stats.command.GetStatsResponse>) responseObserver);
          break;
        case METHODID_QUERY_STATS:
          serviceImpl.queryStats((com.xray.app.stats.command.QueryStatsRequest) request,
              (io.grpc.stub.StreamObserver<com.xray.app.stats.command.QueryStatsResponse>) responseObserver);
          break;
        case METHODID_GET_SYS_STATS:
          serviceImpl.getSysStats((com.xray.app.stats.command.SysStatsRequest) request,
              (io.grpc.stub.StreamObserver<com.xray.app.stats.command.SysStatsResponse>) responseObserver);
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

  private static abstract class StatsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StatsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.xray.app.stats.command.Command.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("StatsService");
    }
  }

  private static final class StatsServiceFileDescriptorSupplier
      extends StatsServiceBaseDescriptorSupplier {
    StatsServiceFileDescriptorSupplier() {}
  }

  private static final class StatsServiceMethodDescriptorSupplier
      extends StatsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    StatsServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (StatsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StatsServiceFileDescriptorSupplier())
              .addMethod(getGetStatsMethod())
              .addMethod(getQueryStatsMethod())
              .addMethod(getGetSysStatsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
