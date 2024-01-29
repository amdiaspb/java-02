package com.tweteroo.api.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserDTO {
    
    @NotBlank(message = "Avatar is mandatory")
    private String avatar;

    @NotBlank(message = "Name is mandatory")
    private String username;
}
