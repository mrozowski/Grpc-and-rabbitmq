package com.mrozowski.study.grpc.api.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.35.0)",
    comments = "Source: RequestProcessor.proto")
public final class RequestProcessorServiceGrpc {

  private RequestProcessorServiceGrpc() {}

  public static final String SERVICE_NAME = "com.mrozowski.study.grpc.api.v1.RequestProcessorService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.mrozowski.study.grpc.api.v1.BridgeServiceOuterClass.RequestIdentifier,
      com.mrozowski.study.grpc.api.v1.RequestProcessor.Result> getGetResultMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getResult",
      requestType = com.mrozowski.study.grpc.api.v1.BridgeServiceOuterClass.RequestIdentifier.class,
      responseType = com.mrozowski.study.grpc.api.v1.RequestProcessor.Result.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.mrozowski.study.grpc.api.v1.BridgeServiceOuterClass.RequestIdentifier,
      com.mrozowski.study.grpc.api.v1.RequestProcessor.Result> getGetResultMethod() {
    io.grpc.MethodDescriptor<com.mrozowski.study.grpc.api.v1.BridgeServiceOuterClass.RequestIdentifier, com.mrozowski.study.grpc.api.v1.RequestProcessor.Result> getGetResultMethod;
    if ((getGetResultMethod = RequestProcessorServiceGrpc.getGetResultMethod) == null) {
      synchronized (RequestProcessorServiceGrpc.class) {
        if ((getGetResultMethod = RequestProcessorServiceGrpc.getGetResultMethod) == null) {
          RequestProcessorServiceGrpc.getGetResultMethod = getGetResultMethod =
              io.grpc.MethodDescriptor.<com.mrozowski.study.grpc.api.v1.BridgeServiceOuterClass.RequestIdentifier, com.mrozowski.study.grpc.api.v1.RequestProcessor.Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getResult"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mrozowski.study.grpc.api.v1.BridgeServiceOuterClass.RequestIdentifier.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mrozowski.study.grpc.api.v1.RequestProcessor.Result.getDefaultInstance()))
              .setSchemaDescriptor(new RequestProcessorServiceMethodDescriptorSupplier("getResult"))
              .build();
        }
      }
    }
    return getGetResultMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.mrozowski.study.grpc.api.v1.BridgeServiceOuterClass.Request,
      com.google.protobuf.Empty> getProcessRequestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "processRequest",
      requestType = com.mrozowski.study.grpc.api.v1.BridgeServiceOuterClass.Request.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.mrozowski.study.grpc.api.v1.BridgeServiceOuterClass.Request,
      com.google.protobuf.Empty> getProcessRequestMethod() {
    io.grpc.MethodDescriptor<com.mrozowski.study.grpc.api.v1.BridgeServiceOuterClass.Request, com.google.protobuf.Empty> getProcessRequestMethod;
    if ((getProcessRequestMethod = RequestProcessorServiceGrpc.getProcessRequestMethod) == null) {
      synchronized (RequestProcessorServiceGrpc.class) {
        if ((getProcessRequestMethod = RequestProcessorServiceGrpc.getProcessRequestMethod) == null) {
          RequestProcessorServiceGrpc.getProcessRequestMethod = getProcessRequestMethod =
              io.grpc.MethodDescriptor.<com.mrozowski.study.grpc.api.v1.BridgeServiceOuterClass.Request, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "processRequest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mrozowski.study.grpc.api.v1.BridgeServiceOuterClass.Request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new RequestProcessorServiceMethodDescriptorSupplier("processRequest"))
              .build();
        }
      }
    }
    return getProcessRequestMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RequestProcessorServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RequestProcessorServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RequestProcessorServiceStub>() {
        @java.lang.Override
        public RequestProcessorServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RequestProcessorServiceStub(channel, callOptions);
        }
      };
    return RequestProcessorServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RequestProcessorServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RequestProcessorServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RequestProcessorServiceBlockingStub>() {
        @java.lang.Override
        public RequestProcessorServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RequestProcessorServiceBlockingStub(channel, callOptions);
        }
      };
    return RequestProcessorServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RequestProcessorServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RequestProcessorServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RequestProcessorServiceFutureStub>() {
        @java.lang.Override
        public RequestProcessorServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RequestProcessorServiceFutureStub(channel, callOptions);
        }
      };
    return RequestProcessorServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class RequestProcessorServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getResult(com.mrozowski.study.grpc.api.v1.BridgeServiceOuterClass.RequestIdentifier request,
        io.grpc.stub.StreamObserver<com.mrozowski.study.grpc.api.v1.RequestProcessor.Result> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetResultMethod(), responseObserver);
    }

    /**
     */
    public void processRequest(com.mrozowski.study.grpc.api.v1.BridgeServiceOuterClass.Request request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getProcessRequestMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetResultMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.mrozowski.study.grpc.api.v1.BridgeServiceOuterClass.RequestIdentifier,
                com.mrozowski.study.grpc.api.v1.RequestProcessor.Result>(
                  this, METHODID_GET_RESULT)))
          .addMethod(
            getProcessRequestMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.mrozowski.study.grpc.api.v1.BridgeServiceOuterClass.Request,
                com.google.protobuf.Empty>(
                  this, METHODID_PROCESS_REQUEST)))
          .build();
    }
  }

  /**
   */
  public static final class RequestProcessorServiceStub extends io.grpc.stub.AbstractAsyncStub<RequestProcessorServiceStub> {
    private RequestProcessorServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RequestProcessorServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RequestProcessorServiceStub(channel, callOptions);
    }

    /**
     */
    public void getResult(com.mrozowski.study.grpc.api.v1.BridgeServiceOuterClass.RequestIdentifier request,
        io.grpc.stub.StreamObserver<com.mrozowski.study.grpc.api.v1.RequestProcessor.Result> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetResultMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void processRequest(com.mrozowski.study.grpc.api.v1.BridgeServiceOuterClass.Request request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getProcessRequestMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RequestProcessorServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<RequestProcessorServiceBlockingStub> {
    private RequestProcessorServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RequestProcessorServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RequestProcessorServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.mrozowski.study.grpc.api.v1.RequestProcessor.Result getResult(com.mrozowski.study.grpc.api.v1.BridgeServiceOuterClass.RequestIdentifier request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetResultMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty processRequest(com.mrozowski.study.grpc.api.v1.BridgeServiceOuterClass.Request request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getProcessRequestMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RequestProcessorServiceFutureStub extends io.grpc.stub.AbstractFutureStub<RequestProcessorServiceFutureStub> {
    private RequestProcessorServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RequestProcessorServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RequestProcessorServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.mrozowski.study.grpc.api.v1.RequestProcessor.Result> getResult(
        com.mrozowski.study.grpc.api.v1.BridgeServiceOuterClass.RequestIdentifier request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetResultMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> processRequest(
        com.mrozowski.study.grpc.api.v1.BridgeServiceOuterClass.Request request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getProcessRequestMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_RESULT = 0;
  private static final int METHODID_PROCESS_REQUEST = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RequestProcessorServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RequestProcessorServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_RESULT:
          serviceImpl.getResult((com.mrozowski.study.grpc.api.v1.BridgeServiceOuterClass.RequestIdentifier) request,
              (io.grpc.stub.StreamObserver<com.mrozowski.study.grpc.api.v1.RequestProcessor.Result>) responseObserver);
          break;
        case METHODID_PROCESS_REQUEST:
          serviceImpl.processRequest((com.mrozowski.study.grpc.api.v1.BridgeServiceOuterClass.Request) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
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

  private static abstract class RequestProcessorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RequestProcessorServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.mrozowski.study.grpc.api.v1.RequestProcessor.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RequestProcessorService");
    }
  }

  private static final class RequestProcessorServiceFileDescriptorSupplier
      extends RequestProcessorServiceBaseDescriptorSupplier {
    RequestProcessorServiceFileDescriptorSupplier() {}
  }

  private static final class RequestProcessorServiceMethodDescriptorSupplier
      extends RequestProcessorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RequestProcessorServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (RequestProcessorServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RequestProcessorServiceFileDescriptorSupplier())
              .addMethod(getGetResultMethod())
              .addMethod(getProcessRequestMethod())
              .build();
        }
      }
    }
    return result;
  }
}
