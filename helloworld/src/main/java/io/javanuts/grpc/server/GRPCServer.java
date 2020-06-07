package io.javanuts.grpc.server;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.javanuts.grpc.service.UserService;

public class GRPCServer {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		Server server = ServerBuilder.forPort(9090).addService(new UserService()).build();
		
		server.start();
		
		System.out.println("server started at "+server.getPort());
		server.awaitTermination();
	}

}
