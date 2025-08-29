package data;
import java.util.*;

public class Dictionary {
   private final Map<String, String> store = new HashMap<>();
   
   public Dictionary(){
       //seed few entries
       store.put("hello", "a greeting");
       store.put("java", "a programming language and platform");
   }
   
   public String find(String word){
       if(word == null) return null;
       return store.get(word.trim().toLowerCase()); // remove unwanted spaces and converted all uppercase to lowercase
   }
   
   public void add(String word, String meaning){
       if(word == null || meaning == null) return;
       store.put(word.trim().toLowerCase(), meaning.trim());
   }
}
