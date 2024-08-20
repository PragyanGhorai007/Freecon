package com.project.ProjectWork.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;



@Component
@Getter
@Setter
@ToString
public class JobDto {
    private String type;
    private int min;
    private int max;
    private String tittle;
    private String location;
    private String description;

}
