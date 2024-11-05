package gcty.root.Entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Venue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long venueId;
    private String venueName;
    private String venueAddress;
    private String venueDescription;
    private String venueWebsite;


    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venue")
    private List<Keikka> keikat;

    @OneToOne
    @JoinColumn(name = "userId")
    private User userId;

    public Venue(Long venueId, String venueName, String venueAddress, String venueDescription, String venueWebsite,
            User userId) {
        this.venueId = venueId;
        this.venueName = venueName;
        this.venueAddress = venueAddress;
        this.venueDescription = venueDescription;
        this.venueWebsite = venueWebsite;
        this.userId = userId;
    }

    public Venue() {
        
    }

    public Long getVenueId() {
        return venueId;
    }

    public void setVenueId(Long venueId) {
        this.venueId = venueId;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getVenueAddress() {
        return venueAddress;
    }

    public void setVenueAddress(String venueAddress) {
        this.venueAddress = venueAddress;
    }

    public String getVenueDescription() {
        return venueDescription;
    }

    public void setVenueDescription(String venueDescription) {
        this.venueDescription = venueDescription;
    }

    public String getVenueWebsite() {
        return venueWebsite;
    }

    public void setVenueWebsite(String venueWebsite) {
        this.venueWebsite = venueWebsite;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public List<Keikka> getKeikat() {
        return keikat;
    }

    public void setKeikat(List<Keikka> keikat) {
        this.keikat = keikat;
    }

    @Override
    public String toString() {
        return "Venue [venueId=" + venueId + ", venueName=" + venueName + ", venueAddress=" + venueAddress
                + ", venueDescription=" + venueDescription + ", venueWebsite=" + venueWebsite
                + "]";
    }
    
    
}
