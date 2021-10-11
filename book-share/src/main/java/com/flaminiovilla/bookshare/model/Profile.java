package com.flaminiovilla.bookshare.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@ToString
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @OneToOne
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    private User user;

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
    @ToString.Exclude
    private List<Post> savedPosts;

    //bi-directional one-to-many association to post
    @OneToMany(mappedBy="owner")
    @ToString.Exclude
    private List<Post> posts;

    //bi-directional one-to-many association to book
    @OneToMany(mappedBy="owner")
    @ToString.Exclude
    private List<Book> books;

    private boolean activated;

    //TODO Gestion per la foto (avatar)

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Profile profile = (Profile) o;
        return id != null && Objects.equals(id, profile.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
