package ru.sbrf.learnqa.soxshop.conditions;

import io.restassured.response.Response;

//Мой класс для выдергивания куков???

/*@RequiredArgsConstructor*/
public class ExtractResponseBody {
    private final Response response;
    public ExtractResponseBody(Response response){      // Это вместо @RequiredArgsConstructor
        this.response = response;                       //
    }


}
