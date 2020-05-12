package model;

/**
 *
 * @author Lawal
 */
public class Person {

    private String name;
    private int age;
    private String id;
    private String address;
    private String dob;
    private int height;
    private double salary;

    public Person() {
    }

    public static class Builder {

        private String name;
        private int age;
        private String id;
        private String address;
        private String dob;
        private int height;
        private double salary;
        
        public Builder name(String name){
            this.name = name;
            return this;
        }
        
        public Builder age(int age){
            this.age = age;
            return this;
        }
        public Builder id(String id){
            this.id = id;
            return this;
        }
        
        public Builder address(String address){
            this.address = address;
            return this;
        }
        public Builder dob(String dob){
            this.dob = dob;
            return this;
        }
        
        public Builder height(int height){
            this.height = height;
            return this;
        }
        
        
        public Builder salary(double salary){
            this.salary = salary;
            return this;
        }
        
        public Person build(){
            return new Person(this);
        }
        
    }
    
    public Person(Builder builder){
        this.name = builder.name;
        this.age = builder.age;
        this.id = builder.id;
        this.address = builder.address;
        this.dob = builder.dob;
        this.height = builder.height;
        this.salary = builder.salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getDob() {
        return dob;
    }

    public int getHeight() {
        return height;
    }

    public double getSalary() {
        return salary;
    }

}
