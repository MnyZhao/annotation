package myview.com.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 声明一个注解参数是 id 和msg
 */
@Retention(RetentionPolicy.RUNTIME)//标记运行时可以检测到
public @interface TestAnnotation {
    int id() default 0;

    String msg() default "msg";
}
