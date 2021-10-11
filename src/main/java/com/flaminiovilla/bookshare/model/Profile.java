package com.flaminiovilla.bookshare.model;

import com.flaminiovilla.bookshare.security.model.User;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "profile")
@Builder
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Size(min = 1, max = 50)
    private String firstName;

    @NotNull
    @Size(min = 1, max = 50)
    private String lastName;

    private Date birthday;

    private String phoneNumber;

    @OneToOne
    @JoinColumn(name = "defaultPosition_id", referencedColumnName = "id")
    private BookSharePosition defaultPosition;

    //many-to-one association to post
    @ManyToMany
    @JoinTable(
            name = "saves_posts",
            joinColumns = @JoinColumn(name = "profile_id"),
            inverseJoinColumns = @JoinColumn(name = "post_id"))
    private List<Post> savedPosts;

    //bi-directional one-to-many association to post
    @OneToMany(mappedBy="owner")
    private List<Post> posts;

    //bi-directional one-to-many association to book
    @OneToMany(mappedBy="owner")
    private List<Book> books;

    private boolean activated;

    //TODO Gestion per la foto (avatar)
}
