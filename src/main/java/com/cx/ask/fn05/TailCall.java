package com.cx.ask.fn05;

import java.util.Optional;
import java.util.stream.Stream;

@FunctionalInterface
public interface TailCall<T> {
	public TailCall<T> apply();
	
	
	default boolean isComplete() {
		return false;
	}
	
	default T result() {
		throw new Error("Not Completed Yet");
	}
	
	default T invoke() {
		Optional<TailCall<T>> opt = Stream.iterate(this, TailCall::apply)
										   .filter(TailCall::isComplete)
										   .findFirst();
		 
		TailCall<T> tailCall = opt.get();
		return tailCall.result();
	}
}
