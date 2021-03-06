package ru.sbrf.learnqa.soxshop.condisions;
import org.hamcrest.Matcher;
import lombok.experimental.UtilityClass;
import ru.sbrf.learnqa.soxshop.assertions.AssertableResponse;

@UtilityClass
public class Condisions {


    public StatusCodeCondition statusCode(int code){
        return new StatusCodeCondition(code);
    }

    public BodyFieldCondition bodyField(String jsonPath, Matcher matcher) {
        return new BodyFieldCondition(jsonPath, matcher);
    }

}
