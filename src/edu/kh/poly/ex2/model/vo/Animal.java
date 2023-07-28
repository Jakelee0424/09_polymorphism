package edu.kh.poly.ex2.model.vo;

public abstract class Animal {

	private String type;
	private String eatType;
	
	
	public Animal() {}
	
	public Animal(String type, String eatType) {
		super();
		this.type = type;
		this.eatType = eatType;
	}

	// 추상 클래스의 생성자 존재 이유
	// 추상 클래스는 new 연산자를 통해 직접적인 객체 생성은 불가능하지만
	// 상속박은 객체 생성 시 내부 부모 부분이 생성될 때 사용된다.
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getEatType() {
		return eatType;
	}
	public void setEatType(String eatType) {
		this.eatType = eatType;
	}
	
	
	@Override
	public String toString() {
		
		return type + " / " + eatType;
		
	}
	
	// 동물의 공통 기능 추출(추상화)
	// 먹다
	// 숨쉬다
	// 움직이다
	
	// 동물은 공통적으로 먹고, 숨쉬고, 움직이지만 동물에 따라 방법이 다름
	//   -> 해당 클래스에 메소드를 정의할 수 없음 
	
	//	해결방법 ==> ** 추상 클래스! **
	
	//	미완성 상태로 두고 상속 받은 자식이 해당 메소드를 정의하도록 함
	//  오버라이딩 강제화
	
	// 사용법    			[접근제한자] abstract 반환형 메소드명 () ;
	
	//  1) 미완성 메소드를 보유하고 있는 클래스
	//  2) 객체로 만들면 안되는 클래스
	//  3) 여러 타입들을 관리하기 위한 상위 타입의 목적
	//      -> 객체 생성을 위한 목적이 아님
	//		-> Animal을 상속받아 미완성 분을 구현한 클래스를 이용해 객체 생성
	
	public abstract void eat(); //추상 메소드 -> 추상 클래스 안에서만 사용 가능
	
	public abstract void breath();
	
	public abstract void move();
	

	

	

	
	
}
