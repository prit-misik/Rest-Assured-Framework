/*
 * Copyright (c) 2022-2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.prt.examples.responseParsing;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

public class compareJson {

    String JsonObject1;
    String jsonObject2;
    ObjectMapper objectMapper;
    JsonNode jsonNode1;
    JsonNode jsonNode2;

    @Test
    public void compareTwoJsonObjects() throws JsonMappingException, JsonProcessingException {
        JsonObject1 = "{\r\n" +
                "  \"firstName\" : \"Mod\",\r\n" +
                "  \"lastName\" : \"Mahajan\"\r\n" +
                "}";

        jsonObject2 = "{\r\n" +
                "  \"firstName\" : \"Amod\",\r\n" +
                "  \"lastName\" : \"Mahajan\"\r\n" +
                "}";

        objectMapper = new ObjectMapper();
        jsonNode1 = objectMapper.readTree(JsonObject1);
        jsonNode2 = objectMapper.readTree(jsonObject2);

        // Checking if both json objects are same
        System.out.println(jsonNode1.equals(jsonNode2));
    }

    @Test
    public void compareTwoJsonObjectsWithDifferentOrderOfRootElements() throws JsonMappingException, JsonProcessingException {
        // Change in order of elements does not impact
        JsonObject1 = "{\r\n" +
                "  \"firstName\" : \"Amod\",\r\n" +
                "  \"lastName\" : \"Mahajan\"\r\n" +
                "}";

        jsonObject2 = "{\r\n" +
                "  \"lastName\" : \"Mahajan\",\r\n" +
                "  \"firstName\" : \"Amod\"\r\n" +
                "  \r\n" +
                "}";

        jsonNode1 = objectMapper.readTree(JsonObject1);
        jsonNode2 = objectMapper.readTree(jsonObject2);

        System.out.println(jsonNode1.equals(jsonNode2));
    }

    @Test
    public void compareTwoNestedJsonObjects() throws JsonMappingException, JsonProcessingException {

        // Nested json objects can also be compared with equals method
        JsonObject1 = "{\r\n" +
                "  \"lastName\": \"Mahajan\",\r\n" +
                "  \"firstName\": \"Amod\",\r\n" +
                "  \"address\": {\r\n" +
                "    \"city\": \"Katihar\",\r\n" +
                "    \"state\": \"Bihar\"\r\n" +
                "  }\r\n" +
                "}";
        jsonObject2 = "{\r\n" +
                "  \"lastName\": \"Mahajan\",\r\n" +
                "  \"firstName\": \"Amod\",\r\n" +
                "  \"address\": {\r\n" +
                "    \"city\": \"Katihar\",\r\n" +
                "    \"state\": \"Bihar\"\r\n" +
                "  }\r\n" +
                "}";

        jsonNode1 = objectMapper.readTree(JsonObject1);
        jsonNode2 = objectMapper.readTree(jsonObject2);

        System.out.println(jsonNode1.equals(jsonNode2));

    }

    @Test
    public void compareTwoJsonArrays() throws JsonMappingException, JsonProcessingException {
        String jsonArray1;
        String jsonArray2;
        ObjectMapper objectMapper;
        JsonNode jsonNode1;
        JsonNode jsonNode2;
        jsonArray1 = "[\r\n" +
                "  {\r\n" +
                "    \"lastName\": \"Mahajan\",\r\n" +
                "    \"firstName\": \"Amod\",\r\n" +
                "    \"address\": {\r\n" +
                "      \"city\": \"Katihar\",\r\n" +
                "      \"state\": \"Bihar\"\r\n" +
                "    }\r\n" +
                "  },\r\n" +
                "  {\r\n" +
                "    \"lastName\": \"Animesh\",\r\n" +
                "    \"firstName\": \"Prashant\",\r\n" +
                "    \"address\": {\r\n" +
                "      \"city\": \"Kolkata\",\r\n" +
                "      \"state\": \"WB\"\r\n" +
                "    }\r\n" +
                "  }\r\n" +
                "]";

        jsonArray2 = "[\r\n" +
                "  {\r\n" +
                "    \"lastName\": \"Mahajan\",\r\n" +
                "    \"firstName\": \"Amod\",\r\n" +
                "    \"address\": {\r\n" +
                "      \"city\": \"Katihar\",\r\n" +
                "      \"state\": \"Bihar\"\r\n" +
                "    }\r\n" +
                "  },\r\n" +
                "  {\r\n" +
                "    \"lastName\": \"Animesh\",\r\n" +
                "    \"firstName\": \"Prashant\",\r\n" +
                "    \"address\": {\r\n" +
                "      \"city\": \"Kolkata\",\r\n" +
                "      \"state\": \"WB\"\r\n" +
                "    }\r\n" +
                "  }\r\n" +
                "]";

        objectMapper = new ObjectMapper();
        jsonNode1 = objectMapper.readTree(jsonArray1);
        jsonNode2 = objectMapper.readTree(jsonArray2);

        // Checking if both json objects are same
        System.out.println(jsonNode1.equals(jsonNode2));
    }

    @Test
    public void compareTwoJsonArraysWithDifferentOrderOfElements() throws JsonMappingException, JsonProcessingException {
        String jsonArray1;
        String jsonArray2;
        ObjectMapper objectMapper;
        JsonNode jsonNode1;
        JsonNode jsonNode2;

        // Change in order of elements in array will impact and it will not be considered same
        jsonArray1 = "[\r\n" +
                "  {\r\n" +
                "    \"lastName\": \"Mahajan\",\r\n" +
                "    \"firstName\": \"Amod\",\r\n" +
                "    \"address\": {\r\n" +
                "      \"city\": \"Katihar\",\r\n" +
                "      \"state\": \"Bihar\"\r\n" +
                "    }\r\n" +
                "  },\r\n" +
                "  {\r\n" +
                "    \"lastName\": \"Animesh\",\r\n" +
                "    \"firstName\": \"Prashant\",\r\n" +
                "    \"address\": {\r\n" +
                "      \"city\": \"Kolkata\",\r\n" +
                "      \"state\": \"WB\"\r\n" +
                "    }\r\n" +
                "  }\r\n" +
                "]";

        jsonArray2 = "[\r\n" +
                "  {\r\n" +
                "    \"lastName\": \"Animesh\",\r\n" +
                "    \"firstName\": \"Prashant\",\r\n" +
                "    \"address\": {\r\n" +
                "      \"city\": \"Kolkata\",\r\n" +
                "      \"state\": \"WB\"\r\n" +
                "    }\r\n" +
                "  },\r\n" +
                "  {\r\n" +
                "    \"lastName\": \"Mahajan\",\r\n" +
                "    \"firstName\": \"Amod\",\r\n" +
                "    \"address\": {\r\n" +
                "      \"city\": \"Katihar\",\r\n" +
                "      \"state\": \"Bihar\"\r\n" +
                "    }\r\n" +
                "  }\r\n" +
                "]";

        objectMapper = new ObjectMapper();
        jsonNode1 = objectMapper.readTree(jsonArray1);
        jsonNode2 = objectMapper.readTree(jsonArray2);

        System.out.println(jsonNode1.equals(jsonNode2));


    }

}
