package com.github.sworisbreathing.springfox.issues.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;

@ApiModel(description = "an error response")
public class ErrorResponse {

  private int code;

  private String message;

  public ErrorResponse() {
  }

  @JsonCreator
  public ErrorResponse(@JsonProperty("code") int code, @JsonProperty("message") String message) {
    this.code = code;
    this.message = message;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

}
