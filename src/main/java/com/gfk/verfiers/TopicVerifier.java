package com.gfk.verfiers;

import static com.gfk.NYTimesAddresses.MOST_POPULAR_FACEBOOK_QUERY_URL;
import static io.restassured.RestAssured.when;
import static org.assertj.core.api.Assertions.assertThat;

import io.restassured.response.Response;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Service;


@Service
public class TopicVerifier {

  private static final String API_KEY = System.getProperty("apiKey");
  private static final String FULL_URL = MOST_POPULAR_FACEBOOK_QUERY_URL + API_KEY;
  private static final String CORONAVIRUS_2019_N_CO_V = "Coronavirus (2019-nCoV)";

  public void verifyIsCoronaPopularTopic() {
    final Response response = when()
        .get(FULL_URL);

    assertThat(filterForTopic(getMostPopularTopics(response), CORONAVIRUS_2019_N_CO_V))
        .isTrue();
    assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_OK);
  }

  private ArrayList<ArrayList<String>> getMostPopularTopics(Response response) {
    return response.then().extract().path("results.des_facet");
  }

  private boolean filterForTopic(ArrayList<ArrayList<String>> listOfList, String topic) {
    return listOfList.stream()
        .flatMap(Collection::parallelStream)
        .collect(Collectors.toList()).contains(topic);
  }
}
