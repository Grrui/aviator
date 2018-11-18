package expression;

import com.googlecode.aviator.AviatorEvaluator;

public class Main {
    public static void main(String[] args) throws Exception {
        Long result = (Long) AviatorEvaluator.execute("1+2+3");
        System.out.println(result);
    }
}
