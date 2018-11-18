package defined;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorDouble;
import com.googlecode.aviator.runtime.type.AviatorObject;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        // 注册
        AviatorEvaluator.addFunction(new AddFunction());
        // 方式1
        System.out.println(AviatorEvaluator.execute("myAdd(12.23, -2.3)"));
        // 方式2
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("a", 12.23);
        params.put("b", -2.3);
        System.out.println(AviatorEvaluator.execute("myAdd(a, b)", params));
    }
}

class AddFunction extends AbstractFunction {

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2) {
        double num1 = FunctionUtils.getNumberValue(arg1, env).doubleValue();
        double num2 = FunctionUtils.getNumberValue(arg2, env).doubleValue();
        return new AviatorDouble(num1 + num2);
    }

    public String getName() {
        return "myAdd";
    }
}