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
    }
}

//    final StringBuffer buffer = new StringBuffer();
//
//    void append(String s) {
//        buffer.append(s);
//    }
//
//    public void run() {
//        for (;;) {
//            Thread.sleep(100);
//
//            String message = buffer.toString();
//            sendToServer(message);
//            buffer.delete(0, message.length());
//        }
//    }