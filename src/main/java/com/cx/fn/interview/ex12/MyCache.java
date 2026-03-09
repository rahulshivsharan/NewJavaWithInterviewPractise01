package com.cx.fn.interview.ex12;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class MyCache<T> {	
	
	private ConcurrentHashMap<T, Object[]> map = null;
	private static final int CACHE_SIZE = 5;
	
	/**
	 * Inner class Holder which holds
	 * instance of MyCache, implemented using singleton
	 * pattern.
	 */
	private static class Holder{
		private static final MyCache  INSTANCE;
		static {
			INSTANCE = new MyCache();
		}
	}	
	
	/**
	 * MyCache with private contructor
	 * so that they can be instantiated internally. 
	 */
	private MyCache() {
		System.out.println("MyCache instatiated");

		// instatiating cache with is key-value
		map = new ConcurrentHashMap<T, Object[]>(); 
	}
	
	/**
	 * Returns the same singleton MyCache instance
	 * @return
	 */
	public static MyCache getInstance() {
		return Holder.INSTANCE;
	}
	
	/**
	 * Get the value from cache 
	 * and update the timestamp 
	 * which is used for LRU (Least Recently Used) cache.
	 * @param objkey
	 * @return
	 * @throws Exception
	 */
	public Object get(T objkey) throws Exception{
		Object value = null;
		Object[] valueArray = this.map.get(objkey);
		
		if(valueArray != null) {
			value = valueArray[1];
			Date currentTimestamp = new Date();
			this.map.replace(objkey, valueArray, new Object[] { currentTimestamp, value});
		}
		return value;
	}
	
	/**
	 * Adds new entry inside cache. 
	 * If cache size exceeds limit of 5 entries,
	 * old entries are removed on the basis of 
	 * timestamp stored accross each entries.
	 * Timestamp is used to compare which cache entry is 
	 * the oldest. 
	 * @param obj
	 * @throws Exception
	 */
	public void put(T obj) throws Exception{
		Object [] valueArray = null;
		
		// add new entry in cache if less than 
		// cache size.
		if(this.map.size() < this.CACHE_SIZE) {
			valueArray = new Object[2];
			valueArray[0] = new Date();
			valueArray[1] = obj;
			this.map.put(obj, valueArray);
		}else {
			// for LRU, to find oldest entry to be removed
			Set<Map.Entry<T, Object[]>> entrySet = this.map.entrySet();
			Date oldestTimestamp = null;
			T keyWithLeastTimestamp = null;
			
			// iterate through cache values
			for(Iterator<Map.Entry<T, Object[]>> itr = entrySet.iterator(); itr.hasNext();) {
				Map.Entry<T, Object[]> entry = itr.next();
				T keyVal = entry.getKey();
				Object[] values = entry.getValue();
				Date timestampOfCurrentData = (Date) values[0];
				
				// for first iteration
				if(oldestTimestamp == null) {
					oldestTimestamp = timestampOfCurrentData;
					keyWithLeastTimestamp = keyVal;
				}else {
					
					// for second iteration onwards 
					// compare the timestamp to capture
					// which entry to be replaced by LRU
					if(timestampOfCurrentData.compareTo(oldestTimestamp) == -1) {
						oldestTimestamp = timestampOfCurrentData;
						keyWithLeastTimestamp = keyVal;
					}
				}
			}
			this.map.remove(keyWithLeastTimestamp); // remove the oldest entry
			valueArray = new Object[2];
			valueArray[0] = new Date();
			valueArray[1] = obj;
			this.map.put(obj, valueArray); // add new entry in cache
		}
	}
}
