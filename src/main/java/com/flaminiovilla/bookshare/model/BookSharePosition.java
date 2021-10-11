package com.flaminiovilla.bookshare.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book_share_position")
@Builder
public class BookSharePosition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String address;

    @NotNull
    private double lat;

    @NotNull
    private double lng;

    @NotNull
    private String placeId;

    @NotNull
    private int radius;

    @NotNull
    private String geoHash;

}
