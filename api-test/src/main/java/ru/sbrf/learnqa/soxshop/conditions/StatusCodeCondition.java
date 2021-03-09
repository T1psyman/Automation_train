package ru.sbrf.learnqa.soxshop.conditions;

import io.restassured.response.Response;

/*@RequiredArgsConstructor*/
public class StatusCodeCondition implements Condition {

private final int statusCode;
public StatusCodeCondition(int statusCode){             //
    this.statusCode = statusCode;                       //вместо @RequiredArgsConstructor
}

    @Override
    public void check(Response response){
            response.then().log().all()
                .assertThat()
                .statusCode(statusCode);
    }
}
