package com.tweteroo.api.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TweetDTO {
    
    @NotBlank(message = "Tweet is mandatory")
    private String text;

    @NotBlank(message = "Id user is mandatory")
    private Long id;

}
