package org.example;

import java.io.*;

public class FileClass {
    public static void main(String[] args)throws IOException {
        File fileCSV = new File("src/main/resources/test.csv"); // создаем папку с файлом

        System.out.println(fileCSV.getName());
        System.out.println(fileCSV.exists());
        System.out.println(fileCSV.isDirectory());

        File directoryCSV = new File("src/main/resources");

        System.out.println(directoryCSV.getName());
        System.out.println(directoryCSV.exists());
        System.out.println(directoryCSV.isDirectory());

        for (String str: directoryCSV.list()){
            System.out.println("file name:" + str);
        }
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
        for (String str: directoryCSV.list((file,name)->{ // Фильтруем выводим файлы у которых есть в наззвании слово тест
            return name.contains("test");               //В  метод лиcт пишем фильтр (file,name)
        })
        ){
            System.out.println("file name: " + str);
        }


    // FileInputStream чтение обьекта из файла
    System.out.println("++++++++++++++++++++++++++++++++++++++++++");
        FileInputStream fi = null;
        try {
            fi = new FileInputStream(fileCSV);//Создаём обект типа FileInputStream вызываем конструктор FileInputStream передаем на вход  fileCSV
        }catch (FileNotFoundException e){
            e.printStackTrace();           // В дальнеёшем отсюда можнем читать
        }finally {
            fi.close();  // Это ресурсы файлы их нужно закрывать через fi.close
        }

        System.out.println("++++++++++++++++++++++++++++++");
        int i;
        File resultCSV = new File("src/main/resources/result.csv"); //Создаем файл result.csv
        FileInputStream fileInputStream = new FileInputStream(fileCSV);
        try (fileInputStream;
             FileOutputStream fileOutputStream = new FileOutputStream(resultCSV);) { // будем копировать даанные из fileCSV в создаваемый resultCSV

            do {
                i = fileInputStream.read();
                System.out.println((char) i);
                fileOutputStream.write(i); //Записываем в файл
            } while (i!=-1); //Значит конец файла и выходим из файла

        }catch (FileNotFoundException e){
            e.printStackTrace();

        }
    }
}
