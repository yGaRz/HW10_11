import java.io.Serializable;
class  PersonException extends Exception{
    PersonException(String message){
        super(message);
    }
}

public class Person implements Serializable {
    private String name;
    private int age;
    private double salary;
    public Person(String name, int age, double salary) throws PersonException {
        this.name = name;
        if(age<0)
            throw new PersonException("Возраст не может быть отрицательным.");
        else
            this.age = age;
        if(salary<=0)
            new PersonException("Зарплата не может быть отрицательной.");
        else
            this.salary = salary;
    }
    @Override
    public String toString(){
        return name+" "+age + " "+salary;
    }
}
