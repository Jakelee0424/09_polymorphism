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

	public Car createCar(int num) {
		
		Car result = null;
		
		switch(num) {
		case 1 : result = new Car(); break;
		case 2 : result = new Tesla(); break;
		case 3 : result = new Spark(); break;
		}
		
		return result;
	}
	
	public void ex6() {	// 다형성 중 다운 캐스팅
		
	//다운 캐스팅 - 부모타입 참조변수가 자식 객체를 참조하는 기술
	// 			  -	업캐스팅 상태에서만 진행 가능	
	//			  - 자식 객체의 본래 필드, 메소드를 사용 가능하게 함.
	
		Car c1 = new Tesla("전기모터", "전기", 4, 50000);
		
		System.out.println(((Tesla)c1).getBatteryCapacity());
		//주의 - ' . ' 연산자가 형변환 연산자보다 우선순위 높음
		
		Tesla t1 = (Tesla)c1; // 얕은복사 이용
		System.out.println(t1.getBatteryCapacity());
	}
	
	public void ex7() { // 다운 캐스팅 주의사항
		
		Car c1 = new Tesla();
		
		//Spark s1 = (Spark)c1;
		// c1이 참조하는 객체는 Tesla인데 
		// Spark참조변수로 Tesla를 참조하려고 하면 문제가 있음.
		
		// System.out.println(s1); //-> 형변환 예외(java.lang.ClassCastException)
		
		// 해결방법 : instanceof 같이 사용
		if(c1 instanceof Spark) {
			Spark s1 = (Spark)c1;
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
		
		
	}
	
	public void ex8() { // 바인딩
		// 바인딩 - 실제 실행할 메소드 코드와 호출하는 코드를 연결
		
		Car c1 = new Car("경유엔진", "경유", 0);
		
		System.out.println(c1.getEngine());
		// Car객체에 있는 getEngine() 메소드를 호출 == 바인딩
		// 마우스 올렸을 때 자동으로 나오는 메뉴
		
		// 프로그램 실행 전
		// 컴파일러는 getEngine메소드가 Car에 있는 걸로 인식
		// c1.getEngine() 호출코드와 
		// String edu.kh.poly.ex1.model.vo.Car.getEngine() 메소드를 연결
		// ==> 정적 바인딩
		
		System.out.println(c1.toString());
		// String edu.kh.poly.ex1.model.vo.Car.toString()
		// Car 참조변수 c1을 이용해서
		// Car 객체에 있는 오버라이딩된 toString() 메소드를 호출
		
		// ** 다형성 적용시 바인딩 **
		Car c2 = new Spark("경차엔진", "휘발유", 4, 0.5);
		// 업캐스팅 적용 -> 부모부분만 참조 가능한 상태
		
		System.out.println(c2.toString());
		//	String edu.kh.poly.ex1.model.vo.Car.toString()
		// 참조변수 c2가 Car타입이므로
		// toString()도 Car의 toString()을 호출 - 정적 바인딩
		// but, 실제로는 자식(Spark)의 toString 호출
		
		// -> 컴파일 시에는 부모의 바인딩(정적 바인딩)
		// -> 실행 시에는 자식의 오버라이딩된 메소드와 바인딩 (동적 바인딩)
		
		
	}
	
}
