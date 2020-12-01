# String vs StringBuilder vs StringBuffer
    1. 가변성 (mutable vs immutable)
        - String : immutable
        - StringBuilder, StringBuffer : mutable
    2. thread-safe
        - String, StringBuffer : thread-safe (동기화 메서드 제공)
        - StringBuilder : non-thread-safe
        
        https://12bme.tistory.com/42
### String 객체는 한번 생성되면 할당된 메모리 공간이 변하지 않는다.
    https://ifuwanna.tistory.com/221
    https://jeong-pro.tistory.com/85