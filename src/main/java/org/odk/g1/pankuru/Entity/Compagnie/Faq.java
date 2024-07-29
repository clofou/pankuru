package org.odk.g1.pankuru.Entity.Compagnie;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Faq")
@Data
@NoArgsConstructor
public class Faq {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String questionCategorie;
    private String reponse;

    @ManyToOne
    @JoinColumn(name = "Compagnie_id")
    private Compagnie compagnie;

}