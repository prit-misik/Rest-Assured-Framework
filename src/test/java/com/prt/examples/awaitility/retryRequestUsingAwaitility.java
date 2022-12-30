/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.prt.examples.awaitility;

import org.awaitility.Awaitility;
import org.testng.annotations.Test;

import java.time.Duration;

public class retryRequestUsingAwaitility {

    @Test
    public void retryTest(){
        Awaitility
                .await()
                .atMost(Duration.ofSeconds(10))
                .pollInterval(Duration.ofSeconds(2))
                .until(()-> CreateFlightBooking.createBooking() == 200);
    }
}
