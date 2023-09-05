package com.portal.portalapi.client;

import com.portal.portalapi.db.Car;
import com.portal.portalapi.db.Owner;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;


import java.net.http.HttpClient;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Component
public class CarClient {

    @Autowired
    RestTemplate rest;

    private final String USER_CLIENT_URI = "http://localhost:8080/user";

    private final String SALES_CLIENT_URI = "http://localhost:8080/sales";


    public List<Car> carForSalesClient() {
        ResponseEntity<Car[]> responseEntity =  rest.getForEntity(SALES_CLIENT_URI+"/cars",Car[].class);
        return Arrays.asList(Objects.requireNonNull(responseEntity.getBody()));
    }


   public void ownerPostClient(Owner newOwner){
        rest.postForEntity(USER_CLIENT_URI, newOwner,Owner.class);
   }


    public void changeCarForSalesClient(Car car, Long id){
    rest.put(SALES_CLIENT_URI+"/car/"+id,car,Car.class);
    }

    public void deleteCarForSalesClient(Long id){
        rest.delete(SALES_CLIENT_URI+"/car"+id);
    }

    public void test() {
        WebClient client = WebClient.builder()
                .baseUrl("http://localhost:8080")
                .defaultCookie("cookieKey", "cookieValue")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultUriVariables(Collections.singletonMap("url", "http://localhost:8080"))
                .build();

        HttpClient httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
                .responseTimeout(Duration.ofMillis(5000))
                .doOnConnected(conn ->
                        conn.addHandlerLast(new ReadTimeoutHandler(5000, TimeUnit.MILLISECONDS))
                .addHandlerLast(new WriteTimeoutHandler(5000, TimeUnit.MILLISECONDS)));

        WebClient novo = WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();



    }




}
