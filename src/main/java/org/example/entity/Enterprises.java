package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ENTERPRISES")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Enterprises {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //criar um valor de ID
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "CNPJ", length = 14, nullable = false)
    private String cnpj;

    @Column(name = "TELEPHONE")
    private String telephone;

    @Column(name = "EMAIL")
    private String email;

}
