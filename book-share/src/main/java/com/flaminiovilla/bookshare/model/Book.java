package com.flaminiovilla.bookshare.model;

import com.flaminiovilla.bookshare.model.enumeration.BookCondition;
import com.flaminiovilla.bookshare.service.utils.StringListConverter;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Blob;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //bi-directional many-to-one association to Profile
    //one profile could have many books
//    @ManyToOne
//    @JoinColumn(name = "profile_id")
//    private Profile owner;

    private String googleBookId;

    @NotNull
    @Size(min = 11, max = 13)
    private String isbn;

    @Column(name = "title", length = 50)
    @NotNull
    @Size(min = 1, max = 50)
    private String title;

    private String description;

    @NotNull
    private double price;



    private String phoneNumber;

}
