package com.gfk.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.gfk.cfg.CucumberSpringTest;
import com.gfk.holders.ResponseHolder;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpStatus;

@CucumberSpringTest
public class AuthenticationSteps {

  private final WrongKeyRequestService wrongKeyRequestService;
  private final ResponseHolder responseHolder;

  public AuthenticationSteps(WrongKeyRequestService wrongKeyRequestService,
      ResponseHolder responseHolder) {
    this.wrongKeyRequestService = wrongKeyRequestService;
    this.responseHolder = responseHolder;
  }

  @Then("System reject request")
  public void systemRejectRequest() {
    assertThat(responseHolder.getResponse().statusCode()).isEqualTo(HttpStatus.SC_OK);
  }

  @When("Client with not authenticated api key sends request")
  public void clientWithWrongKeySendsRequest() {
    wrongKeyRequestService.sendRequestAndStoreResponse();
  }
}
