package com.gfk.steps;

import static com.gfk.NYTimesAddresses.MOST_POPULAR_FACEBOOK_QUERY_URL;
import static io.restassured.RestAssured.when;

import com.gfk.holders.ResponseHolder;
import org.springframework.stereotype.Service;

@Service
public class WrongKeyRequestService {

  private final ResponseHolder responseHolder;
  private static final String WRONG_API_KEY = "123-gfk-wrong";
  private static final String FULL_URL = MOST_POPULAR_FACEBOOK_QUERY_URL + WRONG_API_KEY;

  public WrongKeyRequestService(ResponseHolder responseHolder) {
    this.responseHolder = responseHolder;
  }

  public void sendRequestAndStoreResponse() {
    responseHolder.setResponse(when()
        .get(FULL_URL));
  }
}
