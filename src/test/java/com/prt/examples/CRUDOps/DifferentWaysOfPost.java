/*
 * Copyright (c) 2022-2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.prt.examples.CRUDOps;

import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class DifferentWaysOfPost {

    @Test
    public void createUser1() throws IOException {
        //{"name":"Tenali Ramakrishna", "gender":"male", "email":"tenali.ramakrishna@15ce.com", "status":"active"}

        String body = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") + "/src/test/java/com/prt/post/resource/createUser.json")));
        System.out.println(body);
        Response response = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer ACCESS-TOKEN")
                .body(body)
                .log()
                .all()
                .post("https://gorest.co.in/public/v2/users");
        System.out.println(response.prettyPrint());
    }

    @Test
    public void createBodyAsMap() {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "AAAA Ramakrishna");
        map.put("gender", "male");
        map.put("email", "aaa@bbb.com");
        map.put("status", "inactive");

        Response res = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer 2923b2e001c6430a79634f175ff2ce750f266d0dbfc6222b0bdd4f7c19c8a4f3")
                .body(map)
                .log()
                .all()
                .post("https://gorest.co.in/public/v2/users");

        System.out.println(res.getStatusCode());
    }

    // use of org.json
    //we get extra data structure for use,
    // we want to send a list of emails easily in payload
    //also we want to check only if the value is not  null, then send it in paylaod.
    // every time we have a {} , consider it as a JsonObject
    //if we have a [] it means it is Array
    // but Jackson databind cannot serialize JsonObjects, it can do only java objects, so we are converting it to a map

    @Test
    public void useJSONOrg() {

        JSONObject obj = new JSONObject();
        obj.put("name", "AAAA Ramakrishna");
        obj.put("gender", "male");
        obj.put("status", "inactive");

        JSONArray emailList = new JSONArray();
        emailList.put("aaa.gmail.com");
        emailList.put("bbb.gmail.com");
        obj.put("email", emailList);

        given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(obj.toMap())
                .log()
                .all()
                .post("https://gorest.co.in/public/v2/users");
    }
}
