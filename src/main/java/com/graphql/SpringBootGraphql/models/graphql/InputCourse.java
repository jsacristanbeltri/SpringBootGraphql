package com.graphql.SpringBootGraphql.models.graphql;

import lombok.Data;

@Data
public class InputCourse {

    private String name;
    private String category;
    private String teacher;
}