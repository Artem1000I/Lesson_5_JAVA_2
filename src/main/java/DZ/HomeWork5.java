package DZ;

import java.io.*;

public class HomeWork5 {
    public static void main(String[] args)throws IOException {
        File FlCSV = new File("src/main/resources/FL.csv"); // создаем папку с файлом


        String path = "src/main/resources/FL.csv";
        String line = "";//чтобы сохранить строку создаём переменую
        String cvsSplitBy = ";"; //разделитель

        File directoryCSV = new File("src/main/resources");

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));//Буферизованный считыватель вместо сканера
            //Просматриваем файл
            while ((line = bufferedReader.readLine())!= null){ //line это следущая строка буферизованного считывателя
                String[] csv = line.split(cvsSplitBy);
                System.out.println(csv);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            //Исключение на ошибку пути
        }catch (IOException e) {// Исключение ввода вывода
            e.printStackTrace();
        }
    }
}
