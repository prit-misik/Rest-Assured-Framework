    /*
     * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
     * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
     * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
     * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
     * Vestibulum commodo. Ut rhoncus gravida arcu.
     */

    package pojo;

    import com.fasterxml.jackson.annotation.JsonProperty;

    import java.util.ArrayList;

    public class Pet {
        public Pet(int id, Category category, String name, ArrayList<String> photoUrls, ArrayList<Tag> tags, String status) {
            this.id = id;
            this.category = category;
            this.name = name;
            this.photoUrls = photoUrls;
            this.tags = tags;
            this.status = status;
        }

        int id;
        Category category;
        String name;
        ArrayList<String> photoUrls;
        ArrayList<Tag> tags;
        String status;

        @JsonProperty("id")
        public int getId() {
            return this.id;
        }

        @JsonProperty("category")
        public Category getCategory() {
            return this.category;
        }

        @JsonProperty("name")
        public String getName() {
            return this.name;
        }

        @JsonProperty("photoUrls")
        public ArrayList<String> getPhotoUrls() {
            return this.photoUrls;
        }

        @JsonProperty("tags")
        public ArrayList<Tag> getTags() {
            return this.tags;
        }

        @JsonProperty("status")
        public String getStatus() {
            return this.status;
        }
    }
