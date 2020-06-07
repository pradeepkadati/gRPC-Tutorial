package io.javanuts.grpc.service;

import io.grpc.stub.StreamObserver;
import io.javanuts.grpc.codegen.User.APIResponse;
import io.javanuts.grpc.codegen.User.Empty;
import io.javanuts.grpc.codegen.User.LoginRequest;
import io.javanuts.grpc.codegen.userGrpc.userImplBase;

public class UserService extends userImplBase {

	@Override
	public void login(LoginRequest request, StreamObserver<APIResponse> responseObserver) {
		
		System.out.println("Inside login method");
		
		APIResponse.Builder resBuilder =  APIResponse.newBuilder();
		if (request == null ) {
			
			resBuilder.setResponseCode(404).setResponseMessage("invalid request");
			
			responseObserver.onNext(resBuilder.build()); 
			responseObserver.onCompleted();
		}
		
		if (request.getUsername().equals("pradeep") && request.getPassword().equals("123456")) {
			resBuilder.setResponseCode(200).setResponseMessage("success");
		}else {
			resBuilder.setResponseCode(501).setResponseMessage("invalid user");
		}
		
		responseObserver.onNext(resBuilder.build()); 
		responseObserver.onCompleted();
		
	}

	@Override
	public void logout(Empty request, StreamObserver<APIResponse> responseObserver) {
		// TODO Auto-generated method stub
		super.logout(request, responseObserver);
	}

}
