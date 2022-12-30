/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.prt.examples.awaitility;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;

public class CreateFlightBooking {

    public static int createBooking(){

        String body = "{\n" +
                "    \"firstname\" : \"Prs\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 212,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        return RestAssured
                .given()
                .body("")
                .baseUri("https://restful-booker.herokuapp.com/booking")
                .contentType(ContentType.JSON)
                .post()
                .statusCode();

    }
}
