package io.javanuts.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.javanuts.grpc.codegen.User.APIResponse;
import io.javanuts.grpc.codegen.User.LoginRequest;
import io.javanuts.grpc.codegen.userGrpc;
import io.javanuts.grpc.codegen.userGrpc.userBlockingStub;

public class HelloWorldClient {

	public static void main(String[] args) {
		
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();
		
		userBlockingStub userStub =  userGrpc.newBlockingStub(channel);
		
		LoginRequest request = LoginRequest.newBuilder().setUsername("pradeep1").setPassword("123456").build();
		
	    APIResponse response = userStub.login(request);
		
	    System.out.println(response.getResponseMessage());

	}

}
