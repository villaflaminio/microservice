package com.flaminiovilla.bookshare.model;

import com.flaminiovilla.bookshare.model.enumeration.BookCondition;
import com.flaminiovilla.bookshare.service.utils.StringListConverter;
import com.sun.xml.bind.v2.TODO;
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
@Table(name = "book")
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //bi-directional many-to-one association to Profile
    //one profile could have many books
    @ManyToOne
    @JoinColumn(name="profile_id")
    private Profile owner;

    private String googleBookId;

    @NotNull
    @Size(min = 11, max = 13)
    private String isbn;

    @Column(name = "title", length = 50)
    @NotNull
    @Size(min = 1, max = 50)
    private String title;

    @Lob
    private Blob description;

    @NotNull
    private double price;

    @Enumerated(EnumType.ORDINAL)
    private BookCondition condition ;

    private String phoneNumber;

//TODO gestione foto
//
//    @Lob
//    @Column(name="profile_picture")
//    private List<Blob> profilePicture;


    @ManyToOne
    @JoinColumn(name="post_id", nullable=false)
    private Post sellingPost;

    @Convert(converter = StringListConverter.class)
    private List<String> authors;
}
