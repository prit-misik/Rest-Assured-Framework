/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.prt.examples.postWithPOJO;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import pojo.Order;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static io.restassured.RestAssured.given;

public class PostTestUsingPOJO_V2 {

    @Test
    public void createPet() throws IOException {
        // api ref : https://petstore.swagger.io/#/store/placeOrder
        /**
         * {
         *   "id": 0,
         *   "petId": 0,
         *   "quantity": 0,
         *   "shipDate": "2022-06-19T19:04:13.375Z",
         *   "status": "placed",
         *   "complete": true
         * }
         */
        Date dt = Date.from(LocalDate.of(2022, 02, 11).atStartOfDay(ZoneId.systemDefault()).toInstant());
        Order order = new Order(1, 001, 01, dt ,"OK", true );
        Response response = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer ACCESS-TOKEN")
                .body(order)
                .log()
                .all()
                .post("https://petstore.swagger.io/v2/store/order");
        System.out.println(response.statusCode());
    }

}
