package edu.kh.poly.ex2.model.service;

import java.util.Scanner;

import edu.kh.poly.ex2.model.vo.Animal;
import edu.kh.poly.ex2.model.vo.Fish;
import edu.kh.poly.ex2.model.vo.Person;
import edu.kh.poly.ex2.model.service.LJKCalculator;

// import edu.kh.poly.ex2.model.vo.Animal;

public class AbstractService {

	Scanner sc = new Scanner(System.in);
		
	
	public void ex1() {
		
//		Animal animal = new Animal(); // Cannot instantiate
									  // 추상클래스는 객체화 불가
		
		Person p1 = new Person(); // 추상클래스를 상속받은 자식클래스 인스턴스화
		p1.setName("홍길동");
		p1.setType("척추동물");
		p1.setEatType("잡식");
		
		System.out.println(p1.toString());
		p1.eat();
		p1.breath();
		p1.move();
		
		System.out.println("-------------------");		
		Fish f1 = new Fish();
		f1.eat();
		f1.breath();
		f1.move();
	
	}

	public void ex2() { // 추상클래스와 다형성 + 바인딩
		
		
		// 추상클래스는 객체화 불가
		//   -> 하지만 "참조 변수"로는 사용할 수 있다.
		
		// 사람 -> 동물 / 물고기 -> 동물
		// Animal a1 = new Person();
		// Animal a2 = new Fish();
		
		Animal[] arr = new Animal[2]; // 타입으로 사용 가능
		arr[0] = new Person("사람", "잡식" ,"김사람");
		arr[1] = new Fish("물고기", "잡식");
		
		
		// 바인딩 확인
		for(int i = 0 ; i<arr.length ; i++) {
			arr[i].eat();
			arr[i].breath();
			System.out.println(arr[i].toString()); 
			// String edu.kh.poly.ex2.model.vo.Animal.toString()
			// Animal 참조하는 것으로 나옴 
			//		-> 정적 바인딩
			// 실제 실행하면 자식 클래스 메소드 실행
			// 		-> 동적 바인딩
			
			System.out.println("---------------");
		}
		
	}

	public void ex3() { // 인터페이스 사용 예
		
		Calculator c = new LJKCalculator();
//		Calculator c = new ~의 Calculator();
		
		System.out.println(c.plus(0, 0));
		System.out.println(c.minus(0, 0));
		System.out.println(c.multiple(0, 0));
		System.out.println(c.divide(0, 2));
		
		// 인터페이스 => 미완성 설계도 : 객체생성 불가
		// 참조변수로는 사용 가능
		
		// 코드의 큰 수정 없이
		// 객체 생성 코드만 바꾸면 새로은 클래드 코드 수행 가능
		
		// 인터페이스의 특징
		//   1) 인터페이스를 부모 참조변수로 사용하면
		//		업캐스팅이 적용되어 
		// 		상속받은 모든 클래스를 자식 객체로 참조할 수 있다.
		// 	 -> 중요한 메인코드의 수정을 최소화 할 수 있음
		//  ex) 줄 73~74 : 객체 생성 코드만 수정하여 기능을 다르게
		
		//   2) 자식 클래스에 공통된 메서드 구현을 강제
		// 		모든 자식 클래스가 동일한 형태를 띠게 됨
		//   -> 팀 프로젝트에 필요한 환경 조성이 가능
	}
}
