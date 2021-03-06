package ru.sbrf.learnqa.soxshop.services;

import ru.sbrf.learnqa.soxshop.assertions.AssertableResponse;
import ru.sbrf.learnqa.soxshop.payload.CardPayload;

public class CardApiService extends ApiService {

    public AssertableResponse addNewCard(CardPayload card){
        return new AssertableResponse(setUp()
                //.cookies(allCookies)
                .body(card)
                .when()
                .post("cards"));
    }
}
