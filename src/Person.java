import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

class  PersonException extends Exception{
    PersonException(String message){
        super(message);
    }
}
@JsonAutoDetect
public class Person implements Serializable {
    @JsonProperty("name")
    public String name;
    @JsonProperty("age")
    public int age;
    @JsonProperty("salary")
    public double salary;
    //Пустой конструктор необходим для сериализации json
    public Person(){}

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
