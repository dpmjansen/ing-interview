package org.example.reactive.service;

import org.example.reactive.model.ResponseA;
import org.example.reactive.model.ResponseB;
import org.example.reactive.model.ResponseC;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ReactiveApiServices {

  public Flux<ResponseA> getFromSourceA(){
    return Flux.just(new ResponseA("1"),new ResponseA("2"),new ResponseA("3"));
  }

  public Flux<ResponseB> getFromSourceB(){
    return Flux.just(new ResponseB("1"),new ResponseB("3"));
  }

  public Mono<ResponseC> getFromSourceC(final String id){
    return Mono.just( new ResponseC(id, id + "_details")).doOnNext((o) -> {
      try {
        Thread.sleep(3000);
      } catch (final InterruptedException ignored) {}
    });
  }
}
