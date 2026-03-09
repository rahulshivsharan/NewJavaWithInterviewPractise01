package com.cx.fn.interview.ex12;

import java.util.LinkedHashMap;

public class MyConcurrentLRUCache<K, V> {
	private final int capacity;
	private final LinkedHashMap<K, V> cache;
	
	public MyConcurrentLRUCache(int capacity) {
		if(capacity < 0) 
			throw new IllegalArgumentException("Cache size must be more than zero");
		
		this.capacity = capacity;
		
		this.cache = new LinkedHashMap<K, V>(capacity, 0.75f, true){
			@Override
			protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {	
				if(size() > MyConcurrentLRUCache.this.capacity) {
					return true;
				}
				return false;
			}
		};	
		
	}
	
	public synchronized V get(K key) {
		return this.cache.get(key);
	}
	
	public synchronized void put(K key, V value) {
		if(key == null || value == null) 
			throw new IllegalArgumentException("Key or value cant be null in cache");
		
		this.cache.put(key, value);
	}
	
	public synchronized int size() {
		return this.cache.size();
	}
	
	public synchronized void clear() {
		this.cache.clear();
	}
	
	public synchronized boolean containsKey(K key) {
		return this.cache.containsKey(key);
	}
}
