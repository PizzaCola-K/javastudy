# Chapter 6 객체지향 프로그래밍

## Exercise 6-8

틀린것

- [ ]모든 생성자의 이름은 클래스의 이름과 동일해야한다.
- [x]생성자는 객체를 생성하기 위한 것이다.
- [ ]클래스에는 생성자가 반드시 하나 이상 있어야 한다.
- [ ]생성자가 없는 클래스는 컴파일러가 기본 생성자를 추가한다.
- [x]생성자는 오버로딩 할 수 없다.

객체를 생성하는 것은 new

## Exercise 6-9

this에 대해서 틀린것

- [ ]객체 자신을 가리키는 참조 변수
- [x]클래스 내에서라면 어디서든 사용할 수 있다.
- [ ]지역변수와 인스턴스 변수를 구별할 때 사용한다.
- [ ]클래스 메서드 내에서는 사용할 수 없다.

인스턴스 메서드에서만 사용 가능

## Exercise 6-10

오버로딩이 성립하기 위한 조건이 아닌 것

- [ ]메서드의 이름이 같아야 한다.
- [ ]매개변수의 개수나 타입이 달라야 한다.
- [x]리턴 타입이 달라야한다.
- [x]매개변수의 이름이 달라야 한다.

## Exercise 6-11

```java
long add(int a, int b) {return a+b;}
```

올바르게 오버로딩 한것

```java
long add(int x, int y) {return x+y;} // x
long add(long a, long b) {return a+b;} // o
int add(byte a, byte b) {return a+b;}  // o
int add(long a, int b) {return (int)a+b;} // o
```

## Exercise 6-12

초기화에 대한 설명으로 옳지 않은 것

- [ ]멤버변수는 자동 초기화되므로 초기화 하지 않고도 값을 참조할 수 있다.
- [ ]지역변수는 사용하기 전에 반드시 초기화 해야 한다.
- [x]초기화 블럭보다 생성자가 먼저 수행된다
- [ ]명시적 초기화를 제일 우선적으로 고려해야 한다.
- [x]클래스 변수보다 인스턴스 변수가 먼저 초기화된다.

## Exercise 6-13

인스턴스 변수의 초기화 순서가 올바른 것은?

기본값 - 명시적 초기화 - 초기화 블럭 - 생성자

## Exercise 6-14

지역변수에 대한 설명으로 옳지 않은 것.

- [x]자동 초기화 되므로 별도 초기화가 필요없다.
- [ ]지역변수가 선언된 메서드가 종료되면 지역변수도 함께 소멸된다.
- [ ]매서드의 매개변수로 선언된 변수도 지역변수이다.
- [ ]클래스 변수나 인스턴스 변수보다 메모리 부담이 적다.
- [x]힙 영역에 생성되며 가비지 컬렉터에 의해 소멸된다.

## Exercise 6-15

- [ ]제일 먼저 호출스택에 저장된 것은 main 메서드
- [x]println 메서드를 제외한 나머지 메서드들은 모두 종료된 상태이다.
- [ ]method2 를 호출한 것은 main
- [ ]println 이 종료되면 method1 이 수행을 재개한다.
- [ ]main-method2-mehod1-println 순으로 호출되었다.
- [ ]현재 실행중인 메서드는 println뿐이다.

## Exercise 6-16

```java
class Exercise6_16 {
  public static void change(String str) {
    str +="456";
  }
  public static void main(String[] args){
    String str = "ABC123";
    System.out.println(str);
    change(str);
    System.out.println("After change:"+str); //ABC123
  }
}
```
