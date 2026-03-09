package com.cx.fn.interview.ex13;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateCompareTest {

	public static void main(String[] args) {
		try {
			Date dateOne = null;
			Date dateTwo = null;
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy h:mm a");
			dateOne = df.parse("28/11/2024 12:34 PM");
			dateTwo = df.parse("28/11/2024 02:34 PM");
			System.out.println(dateOne.compareTo(dateTwo));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
