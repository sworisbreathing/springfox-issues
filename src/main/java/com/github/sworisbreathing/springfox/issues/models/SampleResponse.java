package com.github.sworisbreathing.springfox.issues.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;

@ApiModel(description = "A sample response")
public class SampleResponse {

  private String successMessage;

  public SampleResponse() {
  }

  @JsonCreator
  public SampleResponse(@JsonProperty("successMessage") String successMessage) {
    this.successMessage = successMessage;
  }

  public String getSuccessMessage() {
    return successMessage;
  }

  public void setSuccessMessage(String successMessage) {
    this.successMessage = successMessage;
  }

}
