package com.github.sworisbreathing.springfox.issues.api;

import com.github.sworisbreathing.springfox.issues.models.ErrorResponse;
import com.github.sworisbreathing.springfox.issues.models.SampleResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sample", produces = {MediaType.APPLICATION_JSON_VALUE})
@Api(value = "/sample", produces = MediaType.APPLICATION_JSON_VALUE)
@ApiResponses({
  @ApiResponse(code = 200, message = "successful request", response = SampleResponse.class),
  @ApiResponse(code = 400, message = "sad panda", response = ErrorResponse.class)
})
public class SampleApi {

  @ApiOperation(value = "successful endpoint", code = 200, response = SampleResponse.class)
  @RequestMapping(value = "/successfulEndpoint", method = RequestMethod.GET)
  public ResponseEntity<?> successfulEndpoint() {
    return new ResponseEntity<>(new SampleResponse("success"), HttpStatus.OK);
  }

  @ApiOperation(value = "failing endpoint", code = 200, response = SampleResponse.class)
  @RequestMapping(value = "/failingEndpoint", method = RequestMethod.GET)
  public ResponseEntity<?> failingEndpoint() {
    return new ResponseEntity<>(new ErrorResponse(-1, "sad panda is sad"), HttpStatus.BAD_REQUEST);
  }
}
