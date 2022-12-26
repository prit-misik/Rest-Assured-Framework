/*
 * Copyright (c) 2022-2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.prt.examples.requestSpecExample;

import BaseAPI.BasicOps;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import requestSpec.ReqSpec;

public class RequestSpecExample {


    @Test
    public void requestSpecDemo(){
         RequestSpecification spec = ReqSpec.createReqSpec();
         BasicOps.makeGETCall(spec, "/pet");
     }

}
