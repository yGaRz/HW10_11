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




    public static void printMainMenu(){
        System.out.println("Введите пункт меню:");
        System.out.println("1. Создать файл.");
        System.out.println("2. Прочитать файл.");
        System.out.println("0. Выход.");
    }

}
