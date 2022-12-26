/*
 * Copyright (c) 2022-2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.prt.examples.responseParsing;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import pojo.Employee;

/**
 * for dynamic json resp
 */


public class RespParsingWithJackson_DynamicResponse {

    public static void main(String[] args) throws JsonProcessingException {
        String json = "{\n" +
                "    \"firstName\": \"John\",\n" +
                "    \"lastName\": \"doe\",\n" +
                "    \"age\": 26,\n" +
                "        \"address\": {\n" +
                "        \"streetAddress\": \"naist street\",\n" +
                "        \"city\": \"Nara\",\n" +
                "        \"postalCode\": \"630-0192\"\n" +
                "    }\n" +
                "}";

        ObjectMapper objM = new ObjectMapper() ;
        var converted= objM.readValue(json, Employee.class);
        System.out.println(converted.getAddress().get("postalCode"));


    }
}
