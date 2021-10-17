package com.flaminiovilla.client.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDTO {
    public Long id;
    public String googleBookId;
    public String isbn;
    public String title;
    public String description;
    public double price;
    public String phoneNumber;
}
