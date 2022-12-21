package Labs_O.Lab_6.src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        AppLoop(dictionary);
    }

    public static void AppLoop(Dictionary dictionary){
        Scanner in = new Scanner(System.in);

        loop:
        while (true){
            printMenu();
            int res = in.nextInt();
            switch (res){
                case 1:
                    addNewWord(in, dictionary);
                    break;
                case 2:
                    translate(in, dictionary);
                    break;
                case 3:
                    break loop;
                default:
                    System.out.println("Invalid input");
            }
        }
        in.close();
    }

    public static void printMenu(){
        System.out.println("1 - to add new word to Dictionary");
        System.out.println("2 - to translate sentence");
        System.out.println("3 - to quit");
        System.out.print("Input here -> ");
    }

    public static void addNewWord(Scanner in, Dictionary dictionary){
        in.nextLine();
        System.out.println("Input word on English");
        String eWord = in.nextLine();
        System.out.println("Input word`s translation");
        String uWord = in.nextLine();
        dictionary.addWordPair(eWord, uWord);
    }

    public static void translate(Scanner in, Dictionary dictionary){
        in.nextLine();
        System.out.println("Input sentence to translate into ukrainian:");
        String sentence = in.nextLine();
        System.out.println(dictionary.translateSentence(sentence));
    }
}
