## 1.简介
Aviator是一个高性能、轻量级的java语言实现的表达式求值引擎，主要用于各种表达式的动态求值。

## 2.Maven依赖
```xml
<dependency>
    <groupId>com.googlecode.aviator</groupId>
    <artifactId>aviator</artifactId>
    <version>${aviator.version}</version>
</dependency>
```

## 3.使用
### 3.1.执行表达式
[示例](https://github.com/Grrui/aviator/tree/master/src/main/java/expression)

Aviator的使用方式比较简单，通过使用AviatorEvaluator.execute基本可以实现大部分功能：
```java
package expression;

import com.googlecode.aviator.AviatorEvaluator;

public class Main {
    public static void main(String[] args) throws Exception {
        Long result = (Long) AviatorEvaluator.execute("1+2+3");
        System.out.println(result);
    }
}
```
### 3.2. 使用变量
变量的使用有两种方法：execute()、exec();
1. execute()，需要传递Map格式参数
2. exec(),不需要传递Map
#### 3.2.1. execute
[示例](https://github.com/Grrui/aviator/tree/master/src/main/java/execute)
```java
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
```
#### 3.2.2. exec
[示例](https://github.com/Grrui/aviator/tree/master/src/main/java/exec)
```java
package exec;

import com.googlecode.aviator.AviatorEvaluator;

public class Main {
    public static void main(String[] args) {
        String username = "Bob";
        System.out.println(AviatorEvaluator.exec("'hello '+ username +'!'", username));
    }
}
```
### 3.3. 使用函数
Aviator可以使用两种函数：内置函数、自定义函数
#### 3.3.1. 使用内置函数
Aviator提供了非常多的内置函数。具体可以官方文档或者文章最后的参考链接。

[示例](https://github.com/Grrui/aviator/tree/master/src/main/java/buildin)
```java
package buildin;

import com.googlecode.aviator.AviatorEvaluator;

public class Main {
    public static void main(String[] args) {
        // sysdate() 获取当前时间Date
        // date_to_string(date,format) date转为String
        System.out.println(AviatorEvaluator.execute("date_to_string(sysdate(),'yyyy-MM-dd HH:mm:ss')"));
    }
}
```
#### 3.3.2. 自定义函数
自定义函数需要继承AbstractFunction类，重写目标方法。
[示例](https://github.com/Grrui/aviator/tree/master/src/main/java/defined)
```java
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
```
## 4.总结
Aviator功能还是挺强大的，本文只做了简单的介绍，还有很多非常强大功能（正则表达式匹配、语法糖衣等），可以参考后面给的参考链接。

参考链接：
https://github.com/killme2008/aviator/wiki
