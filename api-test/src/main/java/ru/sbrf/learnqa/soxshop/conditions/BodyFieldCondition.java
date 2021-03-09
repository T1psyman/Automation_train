package ru.sbrf.learnqa.soxshop.conditions;

import io.restassured.response.Response;
import org.hamcrest.Matcher;


/*
@RequiredArgsConstructor
*/
public class BodyFieldCondition implements Condition {

    private final String jsonPath;
    private final Matcher matchers;
    public BodyFieldCondition(String jsonPath, Matcher matchers){           //
        this.jsonPath = jsonPath;                                           //  Это вместо @RequiredArgsConstructor
        this.matchers = matchers;                                           //
    }




    @Override
    public void check(Response response){
        response.then().assertThat().body(jsonPath, matchers);
    }
}
