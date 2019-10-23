package com.config.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * WebElement's title. Optional annotation.
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface PageEntry {
    /**
     * Title text
     *
     * @return a {@Link java.lang.String} object
     */
    public String title();

    /**
     *
     * @return default url;
     */

    public String url() default "";
}
