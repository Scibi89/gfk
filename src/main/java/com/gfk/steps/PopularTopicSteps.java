package com.gfk.steps;

import com.gfk.verfiers.TopicVerifier;
import io.cucumber.java.en.Given;

public class PopularTopicSteps {

  private final TopicVerifier topicVerifier;

  public PopularTopicSteps(TopicVerifier topicVerifier) {
    this.topicVerifier = topicVerifier;
  }

  @Given("^Coronavirus is popular topic$")
  public void authenticate() {
    topicVerifier.verifyIsCoronaPopularTopic();
  }
}
