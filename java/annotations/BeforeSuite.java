package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD })


//It is a annotation class, to declare the function. 
//Before test cases start it says what the browser want to do.
//Its a interface, it was used in another class.
public @interface BeforeSuite {

}
