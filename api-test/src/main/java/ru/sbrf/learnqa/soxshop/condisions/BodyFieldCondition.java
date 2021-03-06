package ru.sbrf.learnqa.soxshop.condisions;

import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import org.hamcrest.Matcher;


@RequiredArgsConstructor
public class BodyFieldCondition implements Condision {

    private final String jsonPath;
    private final Matcher matchers;

    @Override
    public void check(Response response){
        response.then().assertThat().body(jsonPath, matchers);
    }
}
