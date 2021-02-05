package com.dev.nginx.grpc.resource;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.dev.grpc.server.Greeting;
import com.dev.grpc.server.Person;
import com.dev.grpc.server.PersonProtoServiceGrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PersonService {

	private PersonProtoServiceGrpc.PersonProtoServiceBlockingStub personProtoServiceBlockingStub;

	@PostConstruct
	private void init() {
		log.info("Init Managed Channel");
		ManagedChannel channel = ManagedChannelBuilder.forAddress("172.20.0.2", 9090).usePlaintext().build();

		personProtoServiceBlockingStub = PersonProtoServiceGrpc.newBlockingStub(channel);
	}

	public String sayHello() {
		log.info("Started say Hello");
		Greeting greetingResponse = personProtoServiceBlockingStub
				.sayHello(Person.newBuilder().setFirstName("Citi").setLastName("grpc").build());

		return greetingResponse.getMessage();
	}

}
