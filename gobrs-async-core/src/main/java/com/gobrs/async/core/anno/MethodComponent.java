package com.gobrs.async.core.anno;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: gobrs-async
 * @ClassName MethodComponent
 * @description:
 * @author: sizegang
 * @create: 2023-01-03
 **/
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface MethodComponent {

}
