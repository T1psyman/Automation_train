package ru.sbrf.learnqa.soxshop.conditions;
import org.hamcrest.Matcher;

/*@UtilityClass*/
public class Conditions {
    private Conditions(){}                          // Заменяет @UtilityClass

    public static StatusCodeCondition statusCode(int code){         //без аннотации обязательно static
        return new StatusCodeCondition(code);
    }

    public static BodyFieldCondition bodyField(String jsonPath, Matcher matcher) {  //без аннотации обязательно static
        return new BodyFieldCondition(jsonPath, matcher);
    }

}
