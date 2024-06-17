
package dictionaryword;

public class DictionaryWord extends FuDictionary implements Comparable<Object>{
    private String word;
    private String meanings;

    public DictionaryWord(String word, String meanings) {
        this.word = word;
        this.meanings = meanings;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeanings() {
        return meanings;
    }

    public void setMeanings(String meanings) {
        this.meanings = meanings;
    }

    @Override
    public String toString() {
        return "" + "word = " + word + ", meanings = " + meanings + ' ';
    }
    
    @Override
    public int compareTo(Object o) {
        DictionaryWord s = (DictionaryWord)o;
        return word.compareTo(s.getWord());
    }
}
