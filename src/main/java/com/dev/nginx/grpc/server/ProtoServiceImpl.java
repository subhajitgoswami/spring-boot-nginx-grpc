package com.dev.nginx.grpc.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dev.grpc.server.Greeting;
import com.dev.grpc.server.Person;
import com.dev.grpc.server.PersonProtoServiceGrpc;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class ProtoServiceImpl  extends PersonProtoServiceGrpc.PersonProtoServiceImplBase{
	
	private static final Logger LOGGER =
		      LoggerFactory.getLogger(ProtoServiceImpl.class);
	
	@Override
	  public void sayHello(Person request,
	      StreamObserver<Greeting> responseObserver) {
	    LOGGER.info("server received {}", request);

	    String message = "Hello " + request.getFirstName() + " "
	        + request.getLastName() + "!";
	    Greeting greeting =
	        Greeting.newBuilder().setMessage(message).build();
	    LOGGER.info("server responded {}", greeting);

	    responseObserver.onNext(greeting);
	    responseObserver.onCompleted();
	}

}
