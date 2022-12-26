/*
 * Copyright (c) 2022-2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.prt.examples.responseParsing;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import pojo.Pet;

import static io.restassured.RestAssured.given;

public class DesrializationExample {


    @Test
    public void deserializeExample(){
        Response response = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer ACCESS-TOKEN")
                .queryParam("status", "available")
                .log()
                .all()
                .get("https://petstore.swagger.io/v2/pet/findByStatus");
        Pet pet = response.as(Pet.class);
        System.out.println(pet.getCategory());
    }

}
