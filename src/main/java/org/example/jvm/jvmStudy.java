package org.example.jvm;

public class jvmStudy {
    public static void main(String[] args) {
        System.out.println(App.class.getSuperclass());
        
        // 힙영역에 객체 저장, 만들지 않아도 class 객체는 클래스 로딩하면서 만들어짐.
        // App.class
    }
}
