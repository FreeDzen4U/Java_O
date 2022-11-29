package Labs_O.Lab_2;

import com.google.gson.Gson;

public class Lab2 {


    public static void main(String[] args){
        Person Yaroslav = new Person(19, "Yaroslav", "Cherkasy");
        Gson gson = new Gson();
        String json = gson.toJson(Yaroslav);
        System.out.println(json);

        Person Yaroslav1 = gson.fromJson(json, Person.class);

        boolean answer = Yaroslav.equals(Yaroslav1);

        System.out.println(answer);
    }
}
