package buildin;

import com.googlecode.aviator.AviatorEvaluator;

public class Main {
    public static void main(String[] args) {
        // sysdate() 获取当前时间Date
        // date_to_string(date,format) date转为String
        System.out.println(AviatorEvaluator.execute("date_to_string(sysdate(),'yyyy-MM-dd HH:mm:ss')"));
    }
}
