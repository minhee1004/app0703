package org.sp.app0703.animal;

public class UseDog {
	public void setAge(Dog d) {
		d.age=7;

	}
	public static void main(String[] args) {
		UseDog ud= new UseDog();
		int x = 8;
		Dog d =new Dog();
		System.out.println(d.age);
		ud.setAge(d); //call by reference
		System.out.println(d.age);
		
	}
}
