# Chapter 2

## Ex1

`System.out.println();` 과 `System.out.print();`의 차이는 줄바꿈의 유무

## Ex3

사칙연산이 포함된 식은 계산한 값이 출력된다.

## Ex4

변수는 값을 저장할 수 있는 공간이다.

## Ex5

변수(Variable)도 또한 수식으로 계산할 수 있으므로, 단순히 숫자를 코드로 적는 것보다 편하다.

## Ex6

Java는 변수에 타입을 명시해줘야 한다. 크게 다음의 4가지를 주로 사용한다

- int: 정수 32bit
- double: 부동소수점 64bit
- char: 문자
- String: 문자열

그외 long 64bit와 float 32bit가 있다.

## 상수(Constant)와 리터럴(Literal)

수를 저장할 수 있지만 이후에 다른 값으로 변경할 수 없는 것으로 상수(constant)가 있다. 이는 final 키워드를 붙여주면 된다.

```java
final int MAX_VALUE = 1000;
```

한편, 여기서 우항의 숫자 1000은 일반적으로는 '상수'라고 표현할 수 있지만, 프로그래밍에서는 리터럴이라 한다.

## 리터럴

다음의 5가지로 분류할 수 있다.

- 논리형
- 정수형
- 실수형
- 문자형
- 문자열

정수형은 접두사로 0b, 0x, 0을 사용하여 2진법, 16진법, 8진법 표현이 가능하다. 접미사로 L을 사용하여 long을 표현할 수 있다.

실수형은 접미사로 f,d를 이용하여 float과 double을 표현할 수 있다.

문자형은 ''로 문자 하나를 감싼 것으로 표현한다. \를 이용하여 특수문자를 표현한다. 이때 빈 것을 허용하지 않는다.

문자열은 ""로 문자를 감싼다. 빈 문자열을 허용한다. String은 객체이므로 원래는 `new String("Java")`을 사용해야 하지만, `"Java"`도 허용한다.

## Ex7

문자열은 + 연산을 이용하여 두 문자열을 합칠 수 있다.

한편, 덧셈 연산자는 왼쪽부터 연산하기 때문에 type 변화에 주의해야 한다.

## Ex8

두 변수의 값을 바꾸려면 임시 변수를 하나 더 사용하여 바꾸어야 한다.

## 기본형(Primitive type)과 참조형(Reference type)

논리형, 정수형, 실수형, 문자형은 기본적인 값을 표현하는 형태로 기본형 변수는 실제 값을 저장한다. 반면에 참조형(reference type)은 객체의 주소를 저장한다.

## 기본형 정리

|  type  | 1 byte  | 2 byte | 4 byte | 8 byte |
| :----: | :-----: | :----: | :----: | :----: |
| 논리형 | boolean |        |        |        |
| 문자형 |         |  char  |        |        |
| 정수형 |  byte   | short  |  int   |  long  |
| 실수형 |         |        | float  | double |

## Ex9

`System.out.printf()`는 format이 있는 형태로 출력해주는 함수이다.

좀 더 자세한 사항은 Eclipse에서 F2를 눌러 설명을 보거나 [Formatter Java Docs](https://docs.oracle.com/javase/8/docs/api/java/util/Formatter.html#syntax)을 참고.

## Ex10

`java.util.Scanner` 를 이용하여 콘솔에서 String으로 입력을 받을 수 있다.

## Ex11

Overflow 예제이다.

0000 부터 1111 까지 줄 세웠을 때, 이를 실제 숫자에 매칭하다보면 자릿수 제한이나 부호 표시등에 의해서 숫자값이 크게 바뀌는 부분이 있다. 이를 overflow라고 한다.

## Ex12

정수형, 문자형, 문자열 사이에서의 타입 변환 예제

'3' - '0'과 같은 방법은 기본적으로 '3'이 정수 51에 맵핑되어 있고, '0'은 정수 48에 연결 되어있어 이 차이가 3임을 이용한다.

# Practice

## 2-1

|  type  | 1 byte  | 2 byte | 4 byte | 8 byte |
| :----: | :-----: | :----: | :----: | :----: |
| 논리형 | boolean |        |        |        |
| 문자형 |         |  char  |        |        |
| 정수형 |  byte   | short  |  int   |  long  |
| 실수형 |         |        | float  | double |

## 2-2

- keyword

1. if

- keyword가 아닌것

2. True
3. NULL
4. Class
5. System

Java는 소스코드에서 대소문자를 구분하고, 구분하지 않는다해도 true / null은 literal, System은 객체이다. Class 또한 객체

[Java Keyword](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/_keywords.html)

## 2-3

char는 0~65535

## 2-4

```java
byte b = 256;
char c = '';
char answer = 'no';
float f = 3.14
double d = 1.4e3f;
```

1, 2, 3, 4가 잘못됨. 1은 literal이 int, 2는 빈 문자 3은 문자를 하나만 써야하고 4는 literal이 double이다.
5는 literal이 float인데 double로 자동 변환된다.

## 2-5

```java
int i = 100;
long l = 100L;
final float PI = 3.14f;
```

- 리터럴
  100, 100L, 3.14f
- 키워드
  int, long, final, float
- 변수
  i, l
- 상수
  PI

## 2-6

Byte는 byte primitive를 객체로 한것이고 나머지는 primitive type으로 keyword이기도 하다.

## 2-7

```java
char c = 48;
System.out.println("1"+"2");         // "12"
System.out.println(true+"");         // "true"
System.out.println('A'+'B');         // (int)131
System.out.println('1'+2);           // (int)51
System.out.println('1'+'2');         // (int)99
System.out.println('J'+"ava");       // "Java"
//		System.out.println(true+null); // error
System.out.println(c);               // '0'
```

## 2-8

x y z의 값을 서로 바꾸는 코드는 다음과 같다.

```java
int tmp = x;
x = y;
y = z;
z = tmp;
```

임시 변수 하나를 사용하여 저장한다.
