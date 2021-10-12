package com.flaminiovilla.bookshare.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.flaminiovilla.bookshare.model.enumeration.BookCondition;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Blob;

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
    public BookCondition condition ;
    public String phoneNumber;
}
