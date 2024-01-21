package com.ewcode.ewcomerce.infra.controller;

import jakarta.validation.constraints.NotNull;

public record RegisterProductDTO(
        @NotNull(message = "Title must not be null") String title,
        @NotNull(message = "Description must not be null") String description,
        @NotNull(message = "Owner must not be null") String owner,
        @NotNull(message = "Data not be null") double price
) {

}
