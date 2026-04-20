package com.cx.ask.fn04;

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
		return Stream.iterate(this, TailCall::apply)
					 .filter(TailCall::isComplete)
					 .findFirst()
					 .get()
					 .result();
	}
}
