package ru.sbrf.learnqa.soxshop.services;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ApiService {
    protected RequestSpecification setUp(){
        return  RestAssured.given().contentType(ContentType.JSON).log().all();
    }
}
