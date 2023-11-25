package com.herbalife.resource;

import io.smallrye.common.annotation.Blocking;
import io.smallrye.common.annotation.NonBlocking;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.time.Duration;
import java.util.List;

@ApplicationScoped
@Path("/reactive")
public class MyReactiveResource {

    @GET
    @Path("/stocks-reactive")
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public Multi<String> getCurrentMarketPriceOfStocksReactive() {
        List<String> stocks = List.of("AAPL", "GOOG", "TSLA", "AMZN", "MSFT", "FB", "NFLX", "ORCL", "IBM", "INTC");
        return Multi
                .createFrom()
                .items(stocks.stream())
                .onItem()
                .transformToUni(value -> Uni
                        .createFrom()
                        .item(value + " : " + (Math.random() * 1000))
                        .onItem()
                        .delayIt()
                        .by(Duration.ofSeconds(1)))
                .concatenate();
    }

    @GET
    @Path("/stocks")
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public List<String> getCurrentMarketPriceOfStocks() {
        List<String> stocks = List.of("AAPL", "GOOG", "TSLA", "AMZN", "MSFT", "FB", "NFLX", "ORCL", "IBM", "INTC");
        return stocks
                .stream()
                .map(stock -> {
                    //Ideally this should be a call to a remote service
                    String stockPrice = stock + " : " + (Math.random() * 1000);
                    try {
                        Thread.sleep(1000); //Induce a delay
                    } catch (InterruptedException e) {
                    }
                    return stockPrice;
                })
                .toList();
    }


    @GET
    @Path("/hello/{name}")
    @NonBlocking //this is not a long running task
    public String hello(String name) {
        String threadName = Thread.currentThread().getName();
        return "Hello " + name + " from " + threadName;
    }

    @GET
    @Path("/bye/{name}")
    @Blocking //default
    public String bye(String name) {
        String threadName = Thread.currentThread().getName();
        return "Bye " + name + " from " + threadName;
    }


}
