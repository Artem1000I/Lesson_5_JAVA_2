package org.example;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class StreamClass {
    public static void main(String[] args)throws IOException,ClassCastException {
        OutputStream outputStream = new OutputStream() {
            @Override
            public void write(int b) throws IOException {

            }
        };

        byte[] bytes = new  String("Моя строка в байтах").getBytes();
        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();){

            int x;
            while ((x = byteArrayInputStream.read())!=-1){ //читайем байты из массива выводим на экран и записываем
                System.out.println(x+" ");
                byteArrayOutputStream.write(x);
            }
            byte[] arr = byteArrayOutputStream.toByteArray(); //Вызываем чтобы завершить запись
        }
        System.out.println();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");



    }
}
