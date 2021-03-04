package ru.sbrf.learnqa.soxshop.condisions;

import io.restassured.response.Response;

public interface Condision {

    void check(Response response);
}
