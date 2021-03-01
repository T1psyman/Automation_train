package ru.sbrf.learnqa.soxshop.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.sbrf.learnqa.soxshop.UserPayload;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.core.Is.is;

public class UserTest {
    @BeforeClass
    private void setUp(){
        RestAssured.baseURI = ("http://178.154.249.63/");
    }

    @Test
    public void testCanBeRegistrationNewUser(){
        UserPayload user = new UserPayload();
        user.setEmail("g@mail.com");
        user.setPassword("test123");
        user.setUsername(RandomStringUtils.randomAlphanumeric(8));
        RestAssured.given().contentType(ContentType.JSON).log().all()
                .body(user)
                .when()
                .post("register")
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .body("id", is(not(emptyString())));
    }

    @Test
    public void testCanNotBeRegistrationUserTwice(){
        UserPayload user = new UserPayload();
        user.setEmail("g@mail.com");
        user.setPassword("test123");
        user.setUsername(RandomStringUtils.randomAlphanumeric(8));
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

}
