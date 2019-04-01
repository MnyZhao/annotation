package myview.com.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Crate by E470PD on 2019/3/13
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Check {
    String value() default "check";
}
