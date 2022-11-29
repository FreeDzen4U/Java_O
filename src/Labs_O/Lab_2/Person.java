package Labs_O.Lab_2;

import java.util.Objects;

class Person {
    int age;
    String name;
    String geo;

    public Person(int age, String name, String geo){
        this.age = age;
        this.name = name;
        this.geo = geo;
    }

    public boolean equals(Object equalsTest){
        if (this == equalsTest){ return  true;}
        if (equalsTest == null || getClass() != equalsTest.getClass()){return false;}
        Person Yaroslav = (Person) equalsTest;
        return Objects.equals(age, Yaroslav.age) &&
               Objects.equals(name, Yaroslav.name) &&
               Objects.equals(geo, Yaroslav.geo);
    }

    @Override
    public int hashCode() {
        int result = 0;
        if (name != null && geo != null ) {
            result += name.hashCode() + geo.hashCode();
        }
        result = 31 * result + age;
        return result;
    }
}