package com.herbalife;

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
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static io.smallrye.mutiny.Multi.*;

@ApplicationScoped
@Path("/reactive")
public class ReactiveSampleResource {

    @GET
    @Path("/async")
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public Multi<String> testingMutiny() {
        String threadName = Thread.currentThread().getName();
        System.out.println("****testingMutiny called on thread " + threadName);
        List<String> completeList = new ArrayList<>();
        completeList.add("hello");
        completeList.add("RestEasy");
        completeList.add("Mutiny");
        completeList.add("is");
        completeList.add("awesome");
        completeList.add("!");

        return createFrom()
                .items(completeList.stream())
                .onItem()
                .transformToUni(value -> Uni
                        .createFrom()
                        .item(value)
                        .onItem()
                        .delayIt()
                        .by(Duration.ofSeconds(1)))
                .concatenate();
    }

    @GET
    @Path("/async2")
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public List<String> testingWithoutMutiny() {
        String threadName = Thread.currentThread().getName();
        System.out.println("****testingWithoutMutiny called on thread " + threadName);
        List<String> completeList = new ArrayList<>();
        completeList.add("hello");
        completeList.add("RestEasy");
        completeList.add("Mutiny");
        completeList.add("is");
        completeList.add("awesome");
        completeList.add("!");
        return completeList
                .stream()
                .map(value -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return value;
                })
                .collect(Collectors.toList());

    }

    @GET
    @Path("/hello")
    @NonBlocking
    public String hello() {
        String threadName = Thread.currentThread().getName();
        return "****Hello called on thread " + threadName;
    }

    @GET
    @Path("/long-running-task")
    @Blocking
    public String longRunningTask() {
        //Assume this task takes a long time to complete
        String threadName = Thread.currentThread().getName();
        return "****A Long running task called on thread " + threadName;
    }
}
