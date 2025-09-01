/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class DictionaryFileStore {
    
     private final File file;

    public DictionaryFileStore(String path) { this.file = new File(path); }

    public Map<String,String> load() {
        Map<String,String> map = new HashMap<>();
        if (!file.exists()) return map;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(file), StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                int idx = line.indexOf(',');
                if (idx > 0) {
                    String w = line.substring(0, idx).trim().toLowerCase();
                    String m = line.substring(idx+1).trim();
                    if (!w.isEmpty() && !m.isEmpty()) map.put(w, m);
                }
            }
        } catch (IOException ignored) {}
        return map;
    }

    public void save(Map<String,String> map) {
        try (PrintWriter pw = new PrintWriter(new OutputStreamWriter(
                new FileOutputStream(file), StandardCharsets.UTF_8))) {
            for (var e : map.entrySet()) pw.println(e.getKey() + "," + e.getValue());
        } catch (IOException ignored) {}
    }
}
