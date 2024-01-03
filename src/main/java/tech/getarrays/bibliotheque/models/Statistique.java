package tech.getarrays.bibliotheque.models;

import jakarta.persistence.*;

@Entity
public class Statistique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TypeStatistique typeStatistique;

    private int valeur;

    @Enumerated(EnumType.STRING)
    private PeriodeReference periodeReference;

    public enum StatutReservation {
        EN_ATTENTE, DISPONIBLE, ANNULEE
    }



        public enum StatutEmprunt {
            EN_COURS, RENOUVELE, TERMINE
        }

        // ... rest of the class ...



    public Statistique() {
    }

    public Statistique(Long id, TypeStatistique typeStatistique, int valeur, PeriodeReference periodeReference) {
        this.id = id;
        this.typeStatistique = typeStatistique;
        this.valeur = valeur;
        this.periodeReference = periodeReference;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeStatistique getTypeStatistique() {
        return typeStatistique;
    }

    public void setTypeStatistique(TypeStatistique typeStatistique) {
        this.typeStatistique = typeStatistique;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public PeriodeReference getPeriodeReference() {
        return periodeReference;
    }

    public void setPeriodeReference(PeriodeReference periodeReference) {
        this.periodeReference = periodeReference;
    }

    public enum TypeStatistique {
        FREQUENTATION, EMPRUNTS_POPULAIRES, RESERVATION // Fixed the enum name
    }

    public enum PeriodeReference {
        MENSUELLE, ANNUELLE // Removed the comment here
    }
}
