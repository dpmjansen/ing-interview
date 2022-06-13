package org.example.reactive.controler;

import org.example.reactive.model.CombinedResponse;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
class ControllerTest {

  @Autowired
  private SimpleController simpleController;

  @Test
  public void requestStuff(){
    List<CombinedResponse> combinedResponses = simpleController.combineSources();

    assertThat(combinedResponses.size(), Matchers.is(2));
  }

}