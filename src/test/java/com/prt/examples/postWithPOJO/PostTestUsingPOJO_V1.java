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
import pojo.Category;
import pojo.Pet;
import pojo.Tag;

import java.io.IOException;
import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class PostTestUsingPOJO_V1 {

    @Test
    public void createPet() throws IOException {
        // api ref : https://petstore.swagger.io/#/pet/addPet
        /**
         *  payload =
         *  {
         *   "id": 0,
         *   "category": {
         *     "id": 0,
         *     "name": "string"
         *   },
         *   "name": "doggie",
         *   "photoUrls": [
         *     "string"
         *   ],
         *   "tags": [
         *     {
         *       "id": 0,
         *       "name": "string"
         *     }
         *   ],
         *   "status": "available"
         * }
         */
        Category c = new Category(1, "dalmatian");
        ArrayList <Tag> t = new ArrayList<>();
        t.add( new Tag(1, "t2"));
        ArrayList <String> list = new ArrayList<>();
        list.add("aaaa");
        list.add("bbbb");
        Pet pet = new Pet(001,c,"Tommy", list ,t,"OK");

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer ACCESS-TOKEN")
                .body(pet)
                .log()
                .all()
                .post("https://petstore.swagger.io/v2/pet");
        System.out.println(response.statusCode());

    }

}
