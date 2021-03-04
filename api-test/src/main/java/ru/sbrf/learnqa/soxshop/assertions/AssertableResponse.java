package ru.sbrf.learnqa.soxshop.assertions;

import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import ru.sbrf.learnqa.soxshop.condisions.Condision;

@RequiredArgsConstructor
public class AssertableResponse {

    private final Response register;

public void shouldHave(Condision condision){
    condision.check(register);

    }
}
