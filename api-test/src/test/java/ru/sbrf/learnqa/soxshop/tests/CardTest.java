package ru.sbrf.learnqa.soxshop.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.sbrf.learnqa.soxshop.payload.CardPayload;
import ru.sbrf.learnqa.soxshop.payload.UserPayload;
import java.util.Map;

import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.Is.is;

public class CardTest{
    @BeforeClass
    public void setUp(){
        RestAssured.baseURI = ("http://178.154.208.225/");
    }

    @Test
    public void testSuccessAddCard() throws InterruptedException {
        UserPayload user = new UserPayload();
        user.email("g@mail.com");
        user.password("test123");
        user.username(RandomStringUtils.randomAlphanumeric(8));

        Response response= RestAssured.given().contentType(ContentType.JSON).log().all()
                .body(user)
             .when()
                .post("register")
             .then().log().all()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .extract().response();

        Map<String, String> allCookies = response.getCookies();
        String id = response.jsonPath().get("id");

        CardPayload card =new CardPayload();
        card.setCcv(RandomStringUtils.randomNumeric(3));
        card.setExpires(RandomUtils.nextInt(1,12) + "/" + RandomStringUtils.randomNumeric(2));
        card.setLongNum(RandomStringUtils.randomNumeric(16));
        card.setUserID(id);

        RestAssured.given().contentType(ContentType.JSON).log().all()
                .cookies(allCookies)
                .body(card)
            .when()
                .post("cards")
            .then().log().all()
                .assertThat()
                .statusCode(200)
                .body("id", is(not(emptyString())));   //Не парсится тело - потому, что возврат в одну строку?!??!?
    }
}
