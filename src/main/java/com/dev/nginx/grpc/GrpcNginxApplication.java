package com.dev.nginx.grpc;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class GrpcNginxApplication implements ApplicationListener<ApplicationReadyEvent> {

	@Autowired
	private ApplicationContext applicationContext;

	public static void main(String[] args) {
		SpringApplication.run(GrpcNginxApplication.class, args);
	}

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		try {
			String ip = InetAddress.getLocalHost().getHostAddress();
			int port = applicationContext.getBean(Environment.class).getProperty("server.port", Integer.class, 8080);

			log.info("logging ip and port of backend service=> " + ip + ":" + port);

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}
}