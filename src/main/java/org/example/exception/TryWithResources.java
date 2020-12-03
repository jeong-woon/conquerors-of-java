package org.example.exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TryWithResources {

    public static void main(String[] args) {
        TryWithResources twr = new TryWithResources();
        System.out.println("try-catch");
        twr.fileHandlerWthTryCatch("C:/Users/Lenovo/Desktop/text.txt");
        System.out.println("============================================");

        System.out.println("try-catch-finally");
        twr.fileHandlerWithTryCatchFinally("C:/Users/Lenovo/Desktop/text.txt");
        System.out.println("============================================");

        System.out.println("try-with-resources");
        twr.fileHandlerWithTryWithResources("C:/Users/Lenovo/Desktop/text.txt");
        System.out.println("============================================");

        // try -with - resources 실습 : https://multifrontgarden.tistory.com/192
        try(B b = new B(new A())){

        }catch(Exception e){

        }

    }

    public void fileHandlerWthTryCatch(String path){

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(path);
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
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e2) {
                // 4. 파일을 찾았은 읽지 못하여 fileStream을 닫으려고 했으나 닫지 못했을 경우
            }
        }
    }

    public void fileHandlerWithTryCatchFinally(String path){

        // 중첩 try - catch 사라짐
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(path);
            int read = fis.read();// 데이터 1byte 읽기
            System.out.println("try block");
//            return "method";
        } catch (FileNotFoundException e) {
            System.out.println("catch block");
//            return "file not found";
        } catch (IOException e) {
            System.out.println("catch io block");
//            return "IOException";
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
    }

    public void fileHandlerWithTryWithResources(String path){
        // 코드가 짧고 간결해짐.
        try (FileInputStream fis = new FileInputStream(path)){
            int read = fis.read();// 데이터 1byte 읽기
            System.out.println("try block");
        } catch (FileNotFoundException e) {
            System.out.println("catch block");
        } catch (IOException e) {
            System.out.println("catch io block");
        }
    }
}

class A implements AutoCloseable{
    @Override
    public void close() throws Exception {
        System.out.println("a call");
    }
}

class B implements AutoCloseable{

    private A a;

    public B(A a) {
        this.a = a;
    }

    @Override
    public void close() throws Exception {
        this.a.close();
        System.out.println("b call");
    }
}