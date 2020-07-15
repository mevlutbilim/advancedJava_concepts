package design_patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Passwords {
    private Pattern pattern;
    private Matcher matcher;

    private static final String password_pattern=
            "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})";
    public Passwords(){
        pattern=Pattern.compile(password_pattern);
    }
    public boolean validate(final String password){
        matcher=pattern.matcher(password);
        return matcher.matches();
    }

}