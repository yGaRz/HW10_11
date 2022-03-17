import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Scanner;
import java.io.*;
import  com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.ObjectMapper;


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
                        readFile();
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
                System.out.println(ex.toString());
                scanner = new Scanner(System.in);
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
                printCreateFileMenu();
                inp = scanner.nextInt();
                switch (inp) {
                    case 1: {
                        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(strName))){
                            Person p  = new Person("Java-сериализация Test",22,255.5);
                            oos.writeObject(p);
                        }
                        catch (PersonException pe){
                            System.out.println(pe.getMessage());
                        }
                        catch (Exception ex){
                            System.out.println(ex.toString() + ex.getMessage());
                        }
                        System.out.println("Файл " + strName + " создан.");
                        return;
                    }
                    case 2: {
                        Person p  = new Person("JSON_Test",15,4000);
                        ObjectMapper mapper = new ObjectMapper();
                        String result = mapper.writeValueAsString(p);
                        try(FileOutputStream fos = new FileOutputStream(strName)) {
                            fos.write(result.getBytes());
                        }
                        catch (Exception ex){
                            System.out.println(ex.toString() + ex.getMessage());
                        }
                        break;
                    }
                    case 3: {
                        try (BufferedWriter writer = new BufferedWriter(new FileWriter(strName))){
                            Person p = new Person("String test",10,20);
                            writer.write(p.name+"\r\n");
                            writer.write(String.valueOf(p.age)+"\r\n");
                            writer.write(String.valueOf(p.salary)+"\r\n");
                        }
                        catch (Exception ex){
                            System.out.println(ex.toString() + ex.getMessage());
                        }
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
                System.out.println(ex.toString() + ex.getMessage());
                scanner= new Scanner(System.in);
            }
        }
    }

    public static void readFile(){
        System.out.println("Введите имя файла с расширением:");
        Scanner scanner = new Scanner(System.in);
        String strName = scanner.nextLine();
        //Перебираем различные вариации для считывания файла
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(strName))){
            Person p = (Person)ois.readObject();
            System.out.println("Java-сериализация:");
            System.out.println(p.toString());
        }
        catch (FileNotFoundException ex){
            System.out.println("Файл не найден.");
            return;
        }
        catch (StreamCorruptedException ex){
            //Это не js сериализация.
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        try(BufferedReader fis = new BufferedReader(new InputStreamReader(new FileInputStream(strName)))){
            String data = fis.readLine();
            StringReader reader = new StringReader(data);
            ObjectMapper mapper = new ObjectMapper();
            Person p = mapper.readValue(reader, Person.class);
            System.out.println("JSON: " + p.toString());
            return;
        } catch (JsonParseException ex){
            //
        }
        catch (Exception ex){
            System.out.println(ex.toString() + ex.getMessage());
        }
        try(BufferedReader fis = new BufferedReader(new InputStreamReader(new FileInputStream(strName)))){
            Scanner scanner1 = new Scanner(fis);
            Person person = new Person(fis.readLine(), Integer.parseInt( fis.readLine()),Double.parseDouble( fis.readLine()));
            System.out.println("Сохранение по строкам:" + person.toString());
            return;
        }
        catch (PersonException ex){
            System.out.println(ex.getMessage());
        }
        catch (Exception ex){
            System.out.println(ex.toString() + ex.getMessage());
        }
    }

    public static void printCreateFileMenu(){
        System.out.println("Выберите тип:");
        System.out.println("1. Сериализация.");
        System.out.println("2. JSON.");
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
