package execute;

import com.googlecode.aviator.AviatorEvaluator;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("username", "Bob");
        System.out.println(AviatorEvaluator.execute("'hello: ' + username  + '!'", map));
    }
}
