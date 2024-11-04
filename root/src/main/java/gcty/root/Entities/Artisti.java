package gcty.root.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Artisti {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long artistiId;
    private String artistiName;
    private String artistiGenre;
    private String artistiHomeCountry;
    private String artistiWebsite;
    private String artistiDescription;

    @ManyToOne
    @JoinColumn(name = "keikkaId")
    private Keikka keikka;

    public Artisti(Long artistiId, String artistiName, String artistiGenre, String artistiHomeCountry,
            String artistiWebsite, String artistiDescription, Keikka keikka) {
        this.artistiId = artistiId;
        this.artistiName = artistiName;
        this.artistiGenre = artistiGenre;
        this.artistiHomeCountry = artistiHomeCountry;
        this.artistiWebsite = artistiWebsite;
        this.artistiDescription = artistiDescription;
        this.keikka = keikka;
    }

    public Artisti(Long artistiId, String artistiName, String artistiGenre, String artistiHomeCountry,
            String artistiWebsite, String artistiDescription) {
        this.artistiId = artistiId;
        this.artistiName = artistiName;
        this.artistiGenre = artistiGenre;
        this.artistiHomeCountry = artistiHomeCountry;
        this.artistiWebsite = artistiWebsite;
        this.artistiDescription = artistiDescription;
    }

    public Artisti() {
        
    }

    public Long getArtistiId() {
        return artistiId;
    }

    public void setArtistiId(Long artistiId) {
        this.artistiId = artistiId;
    }

    public String getArtistiName() {
        return artistiName;
    }

    public void setArtistiName(String artistiName) {
        this.artistiName = artistiName;
    }

    public String getArtistiGenre() {
        return artistiGenre;
    }

    public void setArtistiGenre(String artistiGenre) {
        this.artistiGenre = artistiGenre;
    }

    public String getArtistiHomeCountry() {
        return artistiHomeCountry;
    }

    public void setArtistiHomeCountry(String artistiHomeCountry) {
        this.artistiHomeCountry = artistiHomeCountry;
    }

    public String getArtistiWebsite() {
        return artistiWebsite;
    }

    public void setArtistiWebsite(String artistiWebsite) {
        this.artistiWebsite = artistiWebsite;
    }

    public String getArtistiDescription() {
        return artistiDescription;
    }

    public void setArtistiDescription(String artistiDescription) {
        this.artistiDescription = artistiDescription;
    }

    public Keikka getKeikka() {
        return keikka;
    }

    public void setKeikka(Keikka keikka) {
        this.keikka = keikka;
    }

    @Override
    public String toString() {
        return "Artisti [artistiId=" + artistiId + ", artistiName=" + artistiName + ", artistiGenre=" + artistiGenre
                + ", artistiHomeCountry=" + artistiHomeCountry + ", artistiWebsite=" + artistiWebsite
                + ", artistiDescription=" + artistiDescription + "]";
    }

    
}
