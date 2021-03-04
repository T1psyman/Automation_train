package ru.sbrf.learnqa.soxshop.services;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import ru.sbrf.learnqa.soxshop.assertions.AssertableResponse;
import ru.sbrf.learnqa.soxshop.payload.UserPayload;

public class UserApiService extends ApiService {


    public AssertableResponse registerUser(UserPayload user) {
        return new AssertableResponse(setUp()
                .body(user)
                .when()
                .post("register"));
    }
}
