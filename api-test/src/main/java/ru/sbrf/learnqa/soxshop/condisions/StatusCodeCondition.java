package ru.sbrf.learnqa.soxshop.condisions;

import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StatusCodeCondition implements Condision {

private final int statusCode;

    @Override
    public void check(Response response){
            response.then().log().all()
                .assertThat()
                .statusCode(statusCode);
    }
}
