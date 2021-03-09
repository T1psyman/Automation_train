package ru.sbrf.learnqa.soxshop.conditions;

import io.restassured.response.Response;

public interface Condition {

    void check(Response response);
}
