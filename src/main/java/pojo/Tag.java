/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tag {
    int id;
    String name;

    public Tag(int id , String name){
        this.id = id;
        this.name = name;
    }

    @JsonProperty("id")
    public int getId() {
        return this.id;
    }

    @JsonProperty("name")
    public String getName() {
        return this.name;
    }
}
