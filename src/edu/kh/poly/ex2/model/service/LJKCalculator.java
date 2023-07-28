package edu.kh.poly.ex2.model.service;

// implements -> 인터페이스 상속 예약어
public class LJKCalculator implements Calculator{
//(부모) 클래스 - (자식)클래스 -> extends 
//(부모) 인터페이스 - (자식)클래스 -> implements

// 인터페이스, 클래스 동시 상속 가능(다중 상속 가능)
		
	
	@Override
	public int plus(int num1, int num2) {
		return num1 + num2;
	}

	@Override
	public int minus(int num1, int num2) {
		return num1 - num2;
	}

	@Override
	public int multiple(int num1, int num2) {
		return num1 * num2;
	}

	@Override
	public int divide(int num1, int num2) {
		return num1 / num2;
	}

}
