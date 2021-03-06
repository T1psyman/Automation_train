package ru.sbrf.learnqa.soxshop.tests;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.sbrf.learnqa.soxshop.payload.UserPayload;
import ru.sbrf.learnqa.soxshop.responses.UserRegistrationResponse;
import ru.sbrf.learnqa.soxshop.services.UserApiService;

import java.util.Locale;

import static ru.sbrf.learnqa.soxshop.condisions.Condisions.*;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.core.Is.is;




public class UserTest {

    private final UserApiService userApiService = new UserApiService();
    private final Faker faker = new Faker(new Locale("ru"));

    @BeforeClass
    private void setUp(){
        RestAssured.baseURI = ("http://178.154.208.225/");
    }

    @Test
    public void testCanBeRegistrationNewUser(){
        UserPayload user = new UserPayload()
        .email(faker.internet().emailAddress())
        .password(faker.internet().password())
        .username(faker.name().username());
       UserRegistrationResponse response =  userApiService.registerUser(user)
        .shouldHave(statusCode(200))
        .shouldHave(bodyField("id", is(not(emptyString()))))
       .asPojo(UserRegistrationResponse.class);
    response.getId();
    }

    @Test
    public void testCanNotBeRegistrationUserTwice() {
        UserPayload user = new UserPayload()
                .email(faker.internet().emailAddress())
                .password(faker.internet().password())
                .username(faker.name().username());
        userApiService.registerUser(user)
                .shouldHave(statusCode(200))
                .shouldHave(bodyField("id", is(not(emptyString()))));


        userApiService.registerUser(user)
                .shouldHave(statusCode(500));
    }
}
