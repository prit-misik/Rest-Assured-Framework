/*
 * Copyright (c) 2022-2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.prt.examples.responseParsing;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.json.JSONObject;

public class ResponseParsingWithGson {


    public static void main(String[] args) {

        String resp = "{\n" +
                "    \"firstName\": \"John\",\n" +
                "    \"lastName\": \"doe\",\n" +
                "    \"age\": 26,\n" +
                "    \"address\": {\n" +
                "        \"streetAddress\": \"naist street\",\n" +
                "        \"city\": \"Nara\",\n" +
                "        \"postalCode\": \"630-0192\"\n" +
                "    },\n" +
                "    \"phoneNumbers\": [\n" +
                "        {\n" +
                "            \"type\": \"iPhone\",\n" +
                "            \"number\": \"0123-4567-8888\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"type\": \"home\",\n" +
                "            \"number\": \"0123-4567-8910\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";


        var json = new Gson().fromJson(resp, JsonObject.class).getAsJsonObject();
        var r1 = json.get("address").getAsJsonObject();
        System.out.println(r1.get("postalCode"));

        var arr= json.get("phoneNumbers").getAsJsonArray();

        arr.forEach(el->{
            System.out.println(el.getAsJsonObject().get("number"));
        });

        //Also it can be done by :
        JSONObject js = new JSONObject(resp);
        var result = new Gson().toJsonTree(js).getAsJsonObject();
        var res = result.get("address").getAsJsonObject();
        System.out.println(res.get("postalCode"));

    }


}
