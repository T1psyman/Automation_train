package ru.sbrf.learnqa.soxshop.tests;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.sbrf.learnqa.soxshop.payload.CardPayload;
import ru.sbrf.learnqa.soxshop.payload.UserPayload;
import ru.sbrf.learnqa.soxshop.responses.UserRegistrationResponse;
import ru.sbrf.learnqa.soxshop.services.CardApiService;
import ru.sbrf.learnqa.soxshop.services.UserApiService;

import java.util.Locale;

import static ru.sbrf.learnqa.soxshop.conditions.Conditions.statusCode;

public class CardTest{
    private final UserApiService userApiService = new UserApiService();
    private final Faker faker = new Faker(new Locale("ru"));
    private final CardApiService cardApiService = new CardApiService();


    @BeforeClass
    public void setUp(){
        RestAssured.baseURI = ("http://178.154.208.225/");
    }

  @Test
    public void testSuccessAddCard() {
      UserPayload user = new UserPayload();
      user.setEmail(faker.internet().emailAddress());
      user.setPassword(faker.internet().password());
      user.setUsername(faker.name().username());
      UserRegistrationResponse response = userApiService.registerUser(user)
              .shouldHave(statusCode(200))
              .asPojo(UserRegistrationResponse.class);
              response.getId();

      /*             .extract().response();
        Map<String, String> allCookies = response.getCookies();
        String id = response.jsonPath().get("id");*/        //так было.

        CardPayload card = new CardPayload();
        card.setCcv(RandomStringUtils.randomNumeric(3)); // В ДОКУМЕНТАЦИИ faker НЕ НАШЕЛ генерацию cvv кода
        card.setExpires(RandomUtils.nextInt(1,12) + "/" + RandomStringUtils.randomNumeric(2));
        card.setLongNum(faker.finance().creditCard());
        card.setUserID(response.getId());

        cardApiService.addNewCard(card)
                .shouldHave(statusCode(200));




  /*      RestAssured.given().contentType(ContentType.JSON).log().all()
                .cookies(allCookies)
                .body(card)
            .when()
                .post("cards")
            .then().log().all()
                .assertThat()
                .statusCode(200)
                .body("id", is(not(emptyString()))); */  //Не парсится тело - потому, что возврат в одну строку?!??!?
    }
}
