package com.cx.fn.interview.ex12;

public class ExampleEx03 {

	public static void main(String[] args) {
		try {
			int capacity = 5;
			MyConcurrentLRUCache<Integer,CustomerVO> customerCache = new MyConcurrentLRUCache<Integer,CustomerVO>(capacity);
			CustomerVO customerInstance = null;
			CustomerVO[] customers = new CustomerVO[] {
					new CustomerVO(11, "Tom Holand", "New Hamshire, West Block"),
					new CustomerVO(12, "Jack Nicholson", "Kings Bay"),
					new CustomerVO(13, "Tim Mc Larren", "Pacific Heights"),
					new CustomerVO(14, "Joy Smith", "Livinston East"),
					new CustomerVO(15, "Peter Pan", "Parkinson County"),
					new CustomerVO(16, "June Kemel", "Lighstone Chambers")
			};
			CustomerVO vo1 = customers[0];
			Thread.sleep(2000);
			System.out.println("Inserting "+vo1);
			customerCache.put(vo1.getId(),vo1);
			
			CustomerVO vo2 = customers[1];
			Thread.sleep(2000);
			System.out.println("Inserting "+vo2);
			customerCache.put(vo2.getId(),vo2);
			
			CustomerVO vo3 = customers[2];
			Thread.sleep(2000);
			System.out.println("Inserting "+vo3);
			customerCache.put(vo3.getId(),vo3);
			
			CustomerVO vo4 = customers[3];
			Thread.sleep(2000);
			System.out.println("Inserting "+vo4);
			customerCache.put(vo4.getId(),vo4);
			
			Thread.sleep(2000);
			customerInstance = (CustomerVO) customerCache.get(vo1.getId());
			System.out.println("retrieve "+vo1.getId()+" from Cache : "+customerInstance);
			
			CustomerVO vo5 = customers[4];			
			Thread.sleep(2000);
			System.out.println("Inserting "+vo5);
			customerCache.put(vo5.getId(),vo5);
			
			CustomerVO vo6 = customers[5];
			Thread.sleep(2000);
			System.out.println("Inserting "+vo6);
			customerCache.put(vo6.getId(),vo6);
			
			Thread.sleep(2000);
			customerInstance = (CustomerVO) customerCache.get(vo2.getId());
			System.out.println("retrieve "+vo2.getId()+" from Cache : "+customerInstance);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
