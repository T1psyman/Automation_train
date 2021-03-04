package ru.sbrf.learnqa.soxshop.condisions;

import lombok.experimental.UtilityClass;
@UtilityClass
public class Condisions {


    public StatusCodeCondition statusCode(int code){
        return new StatusCodeCondition(code);
    }
}
