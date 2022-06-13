package org.example.reactive.service;

import org.example.reactive.DemoApp;
import org.example.reactive.model.ResponseA;
import org.example.reactive.model.ResponseB;
import org.example.reactive.model.ResponseC;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ApiServices {

  public List<ResponseA> getFromSourceA(){
    return Arrays.asList(new ResponseA("1"),new ResponseA("2"),new ResponseA("3"));
  }

  public List<ResponseB> getFromSourceB(){
    return Arrays.asList(new ResponseB("1"),new ResponseB("3"));
  }

  public ResponseC getFromSourceC(final String id){
    try {
      Thread.sleep(3000);
    } catch (final InterruptedException ignored) {}
    return new ResponseC(id, id + "_details");
  }
}
