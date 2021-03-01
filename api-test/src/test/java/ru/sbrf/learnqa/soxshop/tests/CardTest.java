package ru.sbrf.learnqa.soxshop.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.sbrf.learnqa.soxshop.CardPayload;
import ru.sbrf.learnqa.soxshop.UserPayload;

import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.Is.is;

public class CardTest {
    @BeforeClass
    public void setUp(){
        RestAssured.baseURI = ("http://178.154.249.63/");
    }

    @Test
    public void testSuccessAddCard(){
        UserPayload user = new UserPayload();
        user.setEmail("g@mail.com");
        user.setPassword("test123");
        user.setUsername(RandomStringUtils.randomAlphanumeric(8));

        String id = RestAssured.given().contentType(ContentType.JSON).log().all()
                .body(user)
                .when()
                .post("register")
                .then().log().all()
                .extract().response().jsonPath().get("id");


        CardPayload card =new CardPayload();
        card.setCcv(RandomStringUtils.randomNumeric(3));
        card.setExpires(RandomUtils.nextInt(1,12) + "/" + RandomStringUtils.randomNumeric(2));
        card.setLongNum(RandomStringUtils.randomNumeric(16));
        card.setUserID(id);
        RestAssured.given().contentType(ContentType.JSON).log().all()
                .body(card)
                .when()
                .post("cards")
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .body("id", is(not(emptyString())));   //дефект??!
    }
}
