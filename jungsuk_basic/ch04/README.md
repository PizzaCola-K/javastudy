# Chapter 4 조건문과 반복문

```java
// condition
if(condition) {
  // do something
} else if(condition) {
  // do something
} else {
  // do something
}
switch(variable){
  case value1:
    break;
  case value2:
  case value3:
    break;
  default:
    break;
}

// loop
Label_loop:
for(int i = 0; i < 10; i++) {
  // do something
  if(condition) {
    break Label_loop;
  } else {
    continue;
  }
}
while(condition){
  // do something
}
do {

} while(condition)
```
