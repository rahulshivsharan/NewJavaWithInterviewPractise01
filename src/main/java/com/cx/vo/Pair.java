package com.cx.vo;

public class Pair<K,V> {
	private K key;
	private V value;
	
	public static <K,V>Pair<K,V> of(K id, V value) {
		Pair<K, V> pair = new Pair<K, V>();
		pair.key = id;
		pair.value = value;
		
		return pair;
	}
	
	public K getKey() {
		return this.key;
	}
	
	public V getValue() {
		return this.value;
	}
}
