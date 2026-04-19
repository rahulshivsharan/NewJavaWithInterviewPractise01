package com.cx.ask.oop01;

public class MainEx01 {

	public static void main(String[] args) {
		Parent parent = new Child();
		parent.hello();
		
		parent.hello("Rahul");
		
		Child child = (Child) parent;
		child.hello();
	}

}
