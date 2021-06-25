package com.mrozowski.study.grpc.api.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.35.0)",
    comments = "Source: BridgeService.proto")
public final class BridgeServiceGrpc {

  private BridgeServiceGrpc() {}

  public static final String SERVICE_NAME = "com.mrozowski.study.grpc.api.v1.BridgeService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.mrozowski.study.grpc.api.v1.BridgeServiceOuterClass.RequestIdentifier,
      com.google.protobuf.Empty> getNotifyRequestDoneMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "notifyRequestDone",
      requestType = com.mrozowski.study.grpc.api.v1.BridgeServiceOuterClass.RequestIdentifier.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.mrozowski.study.grpc.api.v1.BridgeServiceOuterClass.RequestIdentifier,
      com.google.protobuf.Empty> getNotifyRequestDoneMethod() {
    io.grpc.MethodDescriptor<com.mrozowski.study.grpc.api.v1.BridgeServiceOuterClass.RequestIdentifier, com.google.protobuf.Empty> getNotifyRequestDoneMethod;
    if ((getNotifyRequestDoneMethod = BridgeServiceGrpc.getNotifyRequestDoneMethod) == null) {
      synchronized (BridgeServiceGrpc.class) {
        if ((getNotifyRequestDoneMethod = BridgeServiceGrpc.getNotifyRequestDoneMethod) == null) {
          BridgeServiceGrpc.getNotifyRequestDoneMethod = getNotifyRequestDoneMethod =
              io.grpc.MethodDescriptor.<com.mrozowski.study.grpc.api.v1.BridgeServiceOuterClass.RequestIdentifier, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "notifyRequestDone"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mrozowski.study.grpc.api.v1.BridgeServiceOuterClass.RequestIdentifier.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new BridgeServiceMethodDescriptorSupplier("notifyRequestDone"))
              .build();
        }
      }
    }
    return getNotifyRequestDoneMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BridgeServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BridgeServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BridgeServiceStub>() {
        @java.lang.Override
        public BridgeServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BridgeServiceStub(channel, callOptions);
        }
      };
    return BridgeServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BridgeServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BridgeServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BridgeServiceBlockingStub>() {
        @java.lang.Override
        public BridgeServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BridgeServiceBlockingStub(channel, callOptions);
        }
      };
    return BridgeServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BridgeServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BridgeServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BridgeServiceFutureStub>() {
        @java.lang.Override
        public BridgeServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BridgeServiceFutureStub(channel, callOptions);
        }
      };
    return BridgeServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class BridgeServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void notifyRequestDone(com.mrozowski.study.grpc.api.v1.BridgeServiceOuterClass.RequestIdentifier request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getNotifyRequestDoneMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getNotifyRequestDoneMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.mrozowski.study.grpc.api.v1.BridgeServiceOuterClass.RequestIdentifier,
                com.google.protobuf.Empty>(
                  this, METHODID_NOTIFY_REQUEST_DONE)))
          .build();
    }
  }

  /**
   */
  public static final class BridgeServiceStub extends io.grpc.stub.AbstractAsyncStub<BridgeServiceStub> {
    private BridgeServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BridgeServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BridgeServiceStub(channel, callOptions);
    }

    /**
     */
    public void notifyRequestDone(com.mrozowski.study.grpc.api.v1.BridgeServiceOuterClass.RequestIdentifier request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getNotifyRequestDoneMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class BridgeServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<BridgeServiceBlockingStub> {
    private BridgeServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BridgeServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BridgeServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.google.protobuf.Empty notifyRequestDone(com.mrozowski.study.grpc.api.v1.BridgeServiceOuterClass.RequestIdentifier request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getNotifyRequestDoneMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class BridgeServiceFutureStub extends io.grpc.stub.AbstractFutureStub<BridgeServiceFutureStub> {
    private BridgeServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BridgeServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BridgeServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> notifyRequestDone(
        com.mrozowski.study.grpc.api.v1.BridgeServiceOuterClass.RequestIdentifier request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getNotifyRequestDoneMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_NOTIFY_REQUEST_DONE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BridgeServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BridgeServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_NOTIFY_REQUEST_DONE:
          serviceImpl.notifyRequestDone((com.mrozowski.study.grpc.api.v1.BridgeServiceOuterClass.RequestIdentifier) request,
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

  private static abstract class BridgeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BridgeServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.mrozowski.study.grpc.api.v1.BridgeServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BridgeService");
    }
  }

  private static final class BridgeServiceFileDescriptorSupplier
      extends BridgeServiceBaseDescriptorSupplier {
    BridgeServiceFileDescriptorSupplier() {}
  }

  private static final class BridgeServiceMethodDescriptorSupplier
      extends BridgeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BridgeServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (BridgeServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BridgeServiceFileDescriptorSupplier())
              .addMethod(getNotifyRequestDoneMethod())
              .build();
        }
      }
    }
    return result;
  }
}
