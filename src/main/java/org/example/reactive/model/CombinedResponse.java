package org.example.reactive.model;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CombinedResponse {
  private final ResponseA responseA;
  private final ResponseC responseC;
}
