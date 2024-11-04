package gcty.root.Entities;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Keikka {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long keikkaId;
    private LocalDate date;
    private LocalDate startTime;

    @ManyToOne
    @JoinColumn(name = "venueId")
    private Venue venue;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "keikka")
    private List<Artisti> artistit;

    public Keikka(Long keikkaId, LocalDate date, LocalDate startTime, Venue venue, List<Artisti> artistit) {
        this.keikkaId = keikkaId;
        this.date = date;
        this.startTime = startTime;
        this.venue = venue;
        this.artistit = artistit;
    }

    public Long getKeikkaId() {
        return keikkaId;
    }

    public void setKeikkaId(Long keikkaId) {
        this.keikkaId = keikkaId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public List<Artisti> getArtistit() {
        return artistit;
    }

    public void setArtistit(List<Artisti> artistit) {
        this.artistit = artistit;
    }

    @Override
    public String toString() {
        return "Keikka [keikkaId=" + keikkaId + ", date=" + date + ", startTime=" + startTime + ", venue=" + venue
                + ", artistit=" + artistit + "]";
    }

    
    

}
