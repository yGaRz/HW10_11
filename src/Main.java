import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args)  {
        int inp=0;
        Scanner scanner = new Scanner(System.in);
        while (true){
            printMainMenu();
            try
            {
                inp = scanner.nextInt();
                switch (inp){
                    case 1:{
                        createFile();
                        break;
                    }
                    case 2:{

                        break;
                    }
                    case 0:{
                        System.out.println("Программа будет закрыта");
                        return;
                    }
                    default:{
                        System.out.println("Выбран неверный пункт меню.");
                    }
                }
            }
            catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }
    public static void createFile(){
        System.out.println("Введите имя файла с расширением:");
        Scanner scanner = new Scanner(System.in);
        String strName = scanner.nextLine();
        int inp =0;
        while (true) {
            try {
                inp = scanner.nextInt();
                switch (inp) {
                    case 1: {

                        break;
                    }
                    case 2: {

                        break;
                    }
                    case 3: {

                        break;
                    }
                    case 0: {

                        return;
                    }
                    default: {
                        System.out.println("Выбран неверный пункт меню.");
                    }
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void printCreateFileMenu(){
        System.out.println("Выберите тип:");
        System.out.println("1. JSON.");
        System.out.println("2. XML.");
        System.out.println("3. Текстовый.");
        System.out.println("0. Возврат.");
    }

    public static void printMainMenu(){
        System.out.println("Введите пункт меню:");
        System.out.println("1. Создать файл.");
        System.out.println("2. Прочитать файл.");
        System.out.println("0. Выход.");
    }

}
