package ru.sbrf.learnqa.soxshop.assertions;

import io.restassured.response.Response;
import ru.sbrf.learnqa.soxshop.conditions.Condition;

/*@RequiredArgsConstructor*/
public class AssertableResponse {
    private final Response response;

    public AssertableResponse(Response response){       //
        this.response = response;                       //  Это можно заменить аннотацией  RequiredArgsConstructor
    }                                                   //


public AssertableResponse shouldHave(Condition condition){
    condition.check(response);
    return this;
    }

    public <T> T asPojo(Class<T> tclass){
    return response.as(tclass);
    }

}
