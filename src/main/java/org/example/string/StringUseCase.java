package org.example.string;

public class StringUseCase {
    public static void main(String[] args) {
        // String 저장공간
        String a = "aaa";
        String b = "aaa";
        System.out.println(a == b);

        String c = new String("aaa");
        String d = new String("aaa");
        System.out.println(c == d);

        //안전하지 않은 객체
        StringBuilder sb1 = new StringBuilder();
        //안전한객체
        StringBuffer sb2 = new StringBuffer();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    sb1.append(i);
                    sb2.append(i);
//                    System.out.println("t1 : " + i);
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            }
            System.out.println("Thread1-builder: " + sb1.toString());
            System.out.println("Thread1-buffer: " + sb2.toString());
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    sb1.append(i);
                    sb2.append(i);
//                    System.out.println("t2 : " +i);
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            }
            System.out.println("Thread2-builder: " + sb1.toString());
            System.out.println("Thread2-buffer: " + sb2.toString());
        });

        thread1.start();
        thread2.start();
    }
}
