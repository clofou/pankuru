package org.odk.g1.pankuru.Entity.Humain;

import jakarta.persistence.*;
import lombok.Data;
import org.odk.g1.pankuru.Entity.Enum.EnumAction;

@Entity
@Data
public class Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nomClasse;
    private String idDuChamp;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EnumAction typeAction;
    @Column(length = 4000)
    private String ancienneValeur;
    @Column(length = 4000)
    private String nouvelleValeur;

    @ManyToOne
    @JoinColumn(name = "personne_id", nullable = false)
    private Personne personne;
}
