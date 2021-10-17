package com.flaminiovilla.client.model;

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
@Builder
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 11, max = 13)
    private String nome;

    @Column(name = "cognome", length = 50)
    @NotNull
    @Size(min = 1, max = 50)
    private String cognome;

}
