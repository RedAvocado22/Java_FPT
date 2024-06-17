package dictionaryword;

import java.util.*;

public class demoArrayList {

    public static void main(String[] args) {
        ArrayList a1 = new ArrayList();
        a1.add(new DictionaryWord("bank robber ", "Steals money "));
        a1.add(new DictionaryWord("burglar ", "Breaks into a home to steal things  "));
        a1.add(new DictionaryWord("forger", "Makes an illegal copy of something "));
        a1.add(new DictionaryWord("hacker ", "Breaks into a computer system"));
        a1.add(new DictionaryWord("hijacker ", "Takes control of an airplane "));
        a1.add(new DictionaryWord("kidnapper ", "Holds someone for ransom money "));
        a1.add(new DictionaryWord("hijacker ", "Do something wrong "));
        a1.add(new DictionaryWord("murderer ", "Kills another person"));
        a1.add(new DictionaryWord("mugger ", "Attacks and steals money from someone"));

        Collections.sort(a1);
        Collections.reverse(a1);

        for (int i = 0; i < a1.size(); i++) {
            System.out.println(i + "." + a1.get(i));
        }
    }
}



