package exec;

import com.googlecode.aviator.AviatorEvaluator;

public class Main {
    public static void main(String[] args) {
        String username = "Bob";
        System.out.println(AviatorEvaluator.exec("'hello '+ username +'!'", username));
    }
}
