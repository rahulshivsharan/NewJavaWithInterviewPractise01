package com.cx.ask.fn05;

public class TailCalls {

	public static <T> TailCall<T> done(final T value){
		
		TailCall<T> tailCall = new TailCall<T>() {
			
			@Override
			public TailCall<T> apply() {
				throw new Error("Already finished");
			}
			
			@Override
			public boolean isComplete() {
				return true;
			}
			
			@Override
			public T result() {
				return value;
			}
		};
		
		return tailCall; 
	}
	
	public static <T> TailCall<T> call(final TailCall<T> nextCall){
		return nextCall;
	}
}
