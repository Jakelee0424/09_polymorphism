package edu.kh.poly.ex1.model.service;

import java.util.Scanner;

import edu.kh.poly.ex1.model.vo.Car;
import edu.kh.poly.ex1.model.vo.Spark;
import edu.kh.poly.ex1.model.vo.Tesla;

public class PolyService {

	
	public void ex1() {
	
		Car car = new Car(); // 부모객체 참조 변수
		Tesla tesla = new Tesla(); // 자식타입 참조변수
		
		/*************** 다형성 ****************/
		
		Car car2 = new Tesla(); // 오류 발생 X
		//Tesla 객체를 참조하는 변수의 타입이 Car(부모)이기 때문에
		//Tesla 객체가 Car객체로 변화함.
		
		Car car3 = new Spark();
	
	}
	
	public void ex2() { // 다형성 중 업캐스팅 작성방법

	
		Car car = new Car(); // 엔진, 퓨엘, 휠
		Tesla tesla = new Tesla(); // 배터리
		Spark spark = new Spark(); // 디스카운트오퍼
		Car car2 = new Tesla(); 
		Car car3 = new Spark();
		
		//부모가 부모꺼
		car.setEngine(null);
		car.setFuel(null);
		car.setWheel(0);
		
		//자식이 자식꺼
		tesla.getEngine();
		tesla.setFuel(null);
		tesla.setWheel(0);
		tesla.setBatteryCapacity(0);
				
		//자식이 부모꺼
		car2.getEngine();
		car2.setFuel(null);
		car2.setWheel(0);
//		car2.setBatteryCapacity(0); // 자식 고유의 필드 사용 불가
		
		car3.getEngine();
		car3.setFuel(null);
		car3.setWheel(0);
//		car3.setBatteryCapacity(0); // 자식 
//		car3.setDiscountOffer(0.0);
		
	//**********************************************	
			
	}
	
	public void ex3() { // 다형성을 이용한 객체 배열
		// 객체배열 = 같은 객체 참조 자료형의 변수를 하나의 묶음으로 다루는 것
		//			= 부모타입 참조 자료형의 변수를 하나의 묶음으로 다루는 것
		
		Car car = new Car(); // 엔진, 퓨엘, 휠
		Tesla tesla = new Tesla(); // 배터리
		Spark spark = new Spark(); // 디스카운트오퍼
		Car car2 = new Tesla(); 
		Car car3 = new Spark();
		
		
		Car[] arr = new Car[3]; // 부모타입 참조변수 배열 선언 및 할당
		arr[0] = car;  // Car 주소
		arr[1] = car2; // Tesla 주소
		arr[2] = car3;  // Spark 주소
		
		for(int i = 0 ; i < arr.length ; i++) {
			System.out.println(i + "번째 인덱스의 엔진" + arr[i].getEngine());
				
		}
		// 상속 + 다형성
		// Car 상속 클래스는 모두 getEngine()을 가지고 있다를 정의
		// 다형성(업캐스팅) : 부모타입 참조변수 arr[i]로 자식 객체를 참조할 수 있다.
	
	}	
	
	public void ex4() { // 업캐스팅을 이용한 매개변수 사용법
		
		Tesla t = new Tesla("전기모터", "전기", 4, 10000000);		
		Spark s = new Spark("경차 엔진", "휘발유", 4, 0.5);
		Car c = new Car("경유 엔진", "경우", 12);
		
		printCar(t);
		System.out.println("---------------");
		printCar(s);
		System.out.println("---------------");
		printCar(c);
		// 전달받은 Car 또는 자식 객체의 엔진, 연료, 바퀴 개수를 출력하는 메서드
		// 매개변수에 부모타입 참조변수를 작성하면 모든 자식 객체를 전달받을 수 있다.
		
	}

	public void printCar(Car temp) {
		// 부모타입 참조변수 = 자식타입 객체
		// 다형성의 업캐스팅 모양가 똑같다.
		// temp에는 Tesla, Spark, Car의 주소가 넣어와도 된다(업캐스팅)
		
		System.out.println("엔진 : " + temp.getEngine());
		System.out.println("연료 : " + temp.getFuel());
		System.out.println("바퀴 갯수 : " + temp.getWheel() +"개");
		
	}
	
	public void ex5() { // 다형성을 이용한 반환형 사용법
		Car car = new Car(); // 엔진, 퓨엘, 휠
		Tesla tesla = new Tesla(); // 배터리
		Spark spark = new Spark(); // 디스카운트오퍼
		Car car2 = new Tesla(); 
		Car car3 = new Spark();
		
//		Car[] arr = {new Car(), new Tesla(), new Spark()};
		Car[] arr = {createCar(1), createCar(2), createCar(3)};	
		
		// instanceof 연산자 : 객체의 자료형을 검사하는 연산자
		// -> 참조하는 객체가 특정 자료형이거나 부모쪽 상속관계인지 확인
		
		System.out.println(arr[1] instanceof Tesla);
		System.out.println(arr[1] instanceof Spark);
		System.out.println(arr[1] instanceof Car);
		
	}

	private Car createCar(int num) {
		
		Car result = null;
		
		switch(num) {
		case 1 : result = new Car(); break;
		case 2 : result = new Tesla(); break;
		case 3 : result = new Spark(); break;
		}
		
		return result;
	}
	
	
}
