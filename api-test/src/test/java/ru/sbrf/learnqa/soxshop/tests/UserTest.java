package ru.sbrf.learnqa.soxshop.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.sbrf.learnqa.soxshop.condisions.Condision;
import ru.sbrf.learnqa.soxshop.condisions.Condisions;
import ru.sbrf.learnqa.soxshop.condisions.StatusCodeCondition;
import ru.sbrf.learnqa.soxshop.payload.UserPayload;
import ru.sbrf.learnqa.soxshop.services.UserApiService;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.core.Is.is;

public class UserTest {

    private final UserApiService userApiService = new UserApiService();


    @BeforeClass
    private void setUp(){
        RestAssured.baseURI = ("http://178.154.208.225/");
    }

    @Test
    public void testCanBeRegistrationNewUser(){
        UserPayload user = new UserPayload()
        .email("g@mail.com")
        .password("test123")
        .username(RandomStringUtils.randomAlphanumeric(8));
        userApiService.registerUser(user)
            .shouldHave(Condisions.statusCode(200));
/*                .body("id", is(not(emptyString())));*/
    }

/*
    @Test
    public void testCanNotBeRegistrationUserTwice(){
        UserPayload user = new UserPayload()
            .email("g@mail.com")
            .password("test123")
            .username(RandomStringUtils.randomAlphanumeric(8));
        RestAssured.given().contentType(ContentType.JSON).log().all()
                .body(user)
            .when()
                .post("register")
            .then().log().all()
                .assertThat()
                .statusCode(200)
                .body("id", is(not(emptyString())));

        RestAssured.given().contentType(ContentType.JSON).log().all()
                .body(user)
            .when()
                .post("register")
            .then().log().all()
                .assertThat()
                .statusCode(500);
    }
*/

}
