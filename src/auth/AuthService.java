package auth;
import java.util.*;

public class AuthService {
    private static final AuthService INSTANCE = new AuthService();
    public static AuthService getInstance(){
        return INSTANCE;
    }
    
    private final Map<String,String> users = new HashMap<>();
    private boolean loggedIn = false;
    private String currentUser = null;
    
    private AuthService(){
        users.put("admin", "admin123");
        users.put("sachin", "pass123");
    }
    
    public boolean login(String user, String pass){
    boolean ok = users.containsKey(user) && users.get(user).equals(pass);
    loggedIn = ok;
    currentUser = ok ? user : null;
    return ok;
    }
    
    public void logout(){
    loggedIn = false;
    currentUser = null;
    }
    public boolean isLoggedIn(){
        return loggedIn;
    }
    public String currentUser(){
        return currentUser;
    }
}
