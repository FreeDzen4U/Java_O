package Labs_O.Lab_6.src;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {

    private final Map<String,String> dictionary;

    public Dictionary(){
        dictionary = new HashMap<>();
        setUp();
    }


    public String translateSentence(String englishSentence){
        String[] Sentence = englishSentence
                                .toLowerCase()
                                .replace(",", "")
                                .replaceAll("  "," ")
                                .replace(".", "")
                                .replace(";", "")
                                .replace(":", "")
                                .split(" ");
        String result = "";

        for(String i : Sentence){
            if(dictionary.containsKey(i)) {
                result += (dictionary.get(i) +" ");
            }else{
                throw new IllegalArgumentException("Cant translate " + i);
            }
        }

        return result;
    }

    public void addWordPair(String englishWord, String ukrainianWord){
        dictionary.put(englishWord, ukrainianWord);
    }

    public void setUp(){
        addWordPair("ukraine","Україна");
        addWordPair("england","Англія");
        addWordPair("great","Велика");
        addWordPair("capital","столиця");
        addWordPair("is","є");
        addWordPair("a","");
        addWordPair("of","");
        addWordPair("kyiv","Київ");
        addWordPair("britain","Британії");
    }
}
