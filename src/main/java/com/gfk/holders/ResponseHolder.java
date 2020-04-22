package com.gfk.holders;

import com.gfk.cfg.StoryProxyComponent;
import io.restassured.response.Response;
import java.util.Optional;

@StoryProxyComponent
public class ResponseHolder {

  private Optional<Response> response = Optional.empty();

  public Response getResponse() {
    return response.orElseThrow(() -> new IllegalStateException("Response not stored"));
  }

  public void setResponse(Response response) {
    this.response = Optional.ofNullable(response);
  }
}
