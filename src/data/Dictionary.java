package data;
import java.util.*;

public class Dictionary {
   private final Map<String, String> store;
   private final DictionaryFileStore fs = new DictionaryFileStore("dictionary.csv");
   
   public Dictionary(){
       store = fs.load();
       if(store.isEmpty()){
           store.put("hello", "a greeting");
           store.put("java", "a programming language and platform");
           fs.save(store);
       }
       //seed few entries
//       store.put("hello", "a greeting");
//       store.put("java", "a programming language and platform");  
   }
   
   public String find(String word){
       if(word == null) return null;
       return store.get(word.trim().toLowerCase()); // remove unwanted spaces and converted all uppercase to lowercase
   }
   
   public void add(String word, String meaning){
       if(word == null || meaning == null) return;
       store.put(word.trim().toLowerCase(), meaning.trim());
       
       fs.save(store); //help to store each added word and meaning
   }
}
