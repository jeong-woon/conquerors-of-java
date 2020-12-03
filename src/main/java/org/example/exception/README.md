# 예외

#### try()안에 들어갈려면
- AutoCloseable 인터페이스를 구현한 객체만 들어갈 수 있음. -> InputStream, OutputStream 등등
   - 인터페이스는 인터페이스를 다중 상속할 수 있다.(신기하네)
- 위 예제의 FileInputStream은 InputStream을 확장하고 있고, InputStream은 AutoCloseable 인터페이스를 구현하고 있다.
- 결국 AutoCloseable 인터페이스를 구현한 자원들의 해제를 보장한다고 이해. 
- https://docs.oracle.com/javase/specs/jls/se7/html/jls-14.html#jls-14.20.3.1 (try with resources 내부구현)