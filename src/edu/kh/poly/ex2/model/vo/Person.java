package edu.kh.poly.ex2.model.vo;

public class Person extends Animal {
// must implement the inherited abstract method Animal.move() -> 오버라이드 필수
	
	private String name;
	
	
	public Person() {}
	
	public Person(String type, String eatType, String name) {
		super(type, eatType);
		this.name = name;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Person : " + super.toString() + " / " + name;
	}
	
	@Override
	public void eat() {
		System.out.println("수저 등 도구를 이용해 먹는다");
	}

	@Override
	public void breath() {
		System.out.println("코와 입으로 호흡한다");
	}

	@Override
	public void move() {
		System.out.println("직립보행을 한다");
	}

}
