package com.flaminiovilla.bookshare.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Blob;
import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //bi-directional many-to-one association to Profile
    //one Profile can create Many posts
    @ManyToOne
    @JoinColumn(name="profile_id")
    private Profile owner;

    //One post could contain many books
    //bi-directional association to book
    @OneToMany(mappedBy="sellingPost")
    private List<Book> books;

    @Column(name = "title", length = 50)
    @NotNull
    @Size(min = 1, max = 50)
    private String title;

    @Lob
    private Blob description;

    @NotNull
    private double price;

    private String phoneNumber;

    @NotNull
    private boolean active;

    @NotNull
    private Date creationDate;


    //many-to-many association
    @ManyToMany(mappedBy = "savedPosts")
    private List<Profile> saves;

    @OneToOne
    @JoinColumn(name = "postition_id", referencedColumnName = "id")
    @NotNull
    private BookSharePosition postition;

}
