# 예외

### try catch
    
    FileInputStream fis = null;
    try {
        fis = new FileInputStream(new File("file 경로"));
        // 데이터 1byte 읽기
        int read = fis.read();
        try {
            fis.close();
        } catch (IOException e) {
            // 1. 파일을 열어 정상적으로 읽었으나 Stream을 닫을 때 에러 발생의 경우
        }
    } catch (FileNotFoundException e) {
        // 2. 파일을 찾지 못했을 경우
    } catch (IOException e) {
        // 3. 파일을 찾았으나 읽지 못했을 경우
        try {
            if(fis != null) {
                fis.close();
            }
        } catch (IOException e2) {
            // 4. 파일을 찾았은 읽지 못하여 fileStream을 닫으려고 했으나 닫지 못했을 경우
        }
    }

### try catch finally
    // 중첩 try - catch 사라짐
    FileInputStream fis = null;
    try {
        fis = new FileInputStream(new File("file 경로"));
        int read = fis.read();// 데이터 1byte 읽기
        System.out.println("try block");
        return "method";
    } catch (FileNotFoundException e) {
        System.out.println("catch block");
        return "file not found";
    } catch (IOException e) {
        System.out.println("catch block"); 
        return "IOException";
    } finally {
        System.out.println("finally block");
        try {
            if(fis != null) {
                fis.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

### try with resources
    // 코드가 짧고 간결해짐.
    try (FileInputStream fis = new FileInputStream(new File(hello))){
        int read = fis.read();// 데이터 1byte 읽기
        System.out.println("try block");
    } catch (FileNotFoundException e) {
        System.out.println("catch block");
    } catch (IOException e) {
        System.out.println("catch block");
    }
    
#### try()안에 들어갈려면
- AutoCloseable 인터페이스를 구현한 객체만 들어갈 수 있음. -> InputStream, OutputStream 등등
   - 인터페이스는 인터페이스를 다중 상속할 수 있다.(신기하네)
- 위 예제의 FileInputStream은 InputStream을 확장하고 있고, InputStream은 AutoCloseable 인터페이스를 구현하고 있다.
- https://multifrontgarden.tistory.com/192 (따라치기)
- 결국 AutoCloseable 인터페이스를 구현한 자원들의 해제를 보장한다고 이해. 
- https://docs.oracle.com/javase/specs/jls/se7/html/jls-14.html#jls-14.20.3.1 (try with resources 내부구현)