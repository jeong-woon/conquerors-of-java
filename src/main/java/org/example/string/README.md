# String vs StringBuilder vs StringBuffer
    1. 가변성 (mutable vs immutable)
        - String : immutable
        - StringBuilder, StringBuffer : mutable
    2. thread-safe
        - String : 기본적으로 불변하기 때문에 thread-safe 
        - StringBuffer : thread-safe (동기화 메서드 제공)
        - StringBuilder : non-thread-safe
        
        System.out.println(a == b);

### String 객체는 한번 생성되면 할당된 메모리 공간이 변하지 않는다.
- '+' 연산또는 concat메서드로 기존에 생성된 문자열과 다른 문자열을 이어붙일때, 새 String 객체를 만든다.
- 한번 생성된 String 객체를 치환할때도 마찬가지로 새 객체의 주소를 참조한다.
- 기존의 객체는 GC 대상이 된다.
- 이런 이유로 String객체는 문자열 연산이 많은 경우 성능이 좋지 않음.
- 리터럴 생성은 String pool에 검색(hashMap-intern) 및 생성, 생성자를 이용한 스트링 객체 생성은 힙영역에 바로 생성. 
- 스트링풀도 엄밀히 말하면 heap의 한 영역임

### StringBuffer, StringBuilder(mutable)
- 문자열 연산등으로 기존 객체 공간이 부족해지면 기존의 버퍼 크기를 늘리며 유연하게 동작함.
- 기본적으로 스트링버퍼와 스트링빌더의 메소드는 동일함.
- 스트링 버퍼는 각 메소드별로 동기화 키워드(synchronized)가 존재 - thread-safe -> 단일 쓰레드 성능은 스트링 빌더 보다 낮음.
- 스트링 빌더는 동기화 보장하지 않음 -> 단일쓰레드 성능은 스트링버퍼 보다 뛰어남