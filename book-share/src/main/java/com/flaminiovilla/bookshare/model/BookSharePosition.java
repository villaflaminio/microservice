package com.flaminiovilla.bookshare.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
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
