package org.example.reactive.controler;

import org.example.reactive.model.CombinedResponse;
import org.example.reactive.model.ResponseA;
import org.example.reactive.model.ResponseB;
import org.example.reactive.service.ApiServices;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class SimpleController {

  private final ApiServices apiServices;

  public SimpleController(final ApiServices apiServices) {
    this.apiServices = apiServices;
  }

  @GetMapping(path = "/**", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<CombinedResponse> combineSources() {
    List<ResponseA> responsesA = apiServices.getFromSourceA();
    List<ResponseB> responsesB = apiServices.getFromSourceB();

    List<CombinedResponse> combinedResponses = new ArrayList<>();
    for (final ResponseA responseA : responsesA) {
      for (final ResponseB responseB : responsesB) {
        if (responseA.getId().equals(responseB.getId())) {
          combinedResponses.add(new CombinedResponse(responseA, apiServices.getFromSourceC(responseB.getId())));
        }
      }
    }
    return combinedResponses;
  }
}
