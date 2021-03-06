package ru.sbrf.learnqa.soxshop.assertions;

import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import ru.sbrf.learnqa.soxshop.condisions.Condision;

@RequiredArgsConstructor
public class AssertableResponse {

    private final Response response;

public AssertableResponse shouldHave(Condision condision){
    condision.check(response);
    return this;
    }

    public <T> T asPojo(Class<T> tclass){
    return response.as(tclass);
    }

}
