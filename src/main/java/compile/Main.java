package compile;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String s = "a-(b-c)>100";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("a", 100);
        params.put("b", 5);
        params.put("c", 6);
        Expression expression = AviatorEvaluator.compile(s);
        System.out.println(expression.execute(params));
    }
}
