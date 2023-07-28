package edu.kh.poly.ex2.model.service;

// 계산기 인터페이스
// -> 모든 계산기에 대한 공통 필드, 기능명을 제공하는 접점의 용도
public interface Calculator {
	
	// 인터페이스 : 추상 클래스의 변형체 (추상도가 높음 more than 추상 클래스)
	
	// 			    추상 메서드 개수
	// 인터페이스 : 모두   ||   추상클래스 : 0개 이상
	
	// 필드 : 묵시적으로 "public static final" => 상수 사용
	
	public static final double PI = 3.14;
	static final int MAX_NUM = 100000;
	public int MIN_NUM = 100000;
	int ZERO = 0;
	
	// 메서드 : 묵시적으로 "public abstract"
	
	public abstract int plus(int num1, int num2);
	public abstract int minus(int num1, int num2);
	public abstract int multiple(int num1, int num2);
	public abstract int divide(int num1, int num2);
}
