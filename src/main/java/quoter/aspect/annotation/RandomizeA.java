package quoter.aspect.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by dasha on 03.05.18.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface RandomizeA {
    int min();
    int max();
}
