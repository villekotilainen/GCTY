package gcty.root.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gcty.root.Entities.Venue;
import gcty.root.Repositories.VenueRepository;

@RestController
@RequestMapping("/api/venues")
public class VenueRestController {
    
    @Autowired
    private VenueRepository venueRepository;

    @GetMapping // GET: hae kaikki venuet
    public List<Venue> getAllVenues() {
        return venueRepository.findAll();
    }

    @GetMapping("/{id}") // GET: hae venue IDn perusteella
    public ResponseEntity<Venue> getVenueById(@PathVariable Long id) {
        Optional<Venue> venue = venueRepository.findById(id);
        return venue.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping // POST: lisää uusi venue
    public ResponseEntity<Venue> createVenue(@RequestBody Venue newVenue) {
        Venue savedVenue = venueRepository.save(newVenue);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedVenue);
    }

    @PutMapping("/{id}") // PUT: päivitä olemassa oleva venue
    public ResponseEntity<Venue> updateVenue(@PathVariable Long id, @RequestBody Venue venueDetails) {
        Optional<Venue> optionalVenue = venueRepository.findById(id);

        if (optionalVenue.isPresent()) {
            Venue existingVenue = optionalVenue.get();
            existingVenue.setVenueName(venueDetails.getVenueName());
            existingVenue.setVenueAddress(venueDetails.getVenueAddress());
            existingVenue.setVenueDescription(venueDetails.getVenueDescription());
            existingVenue.setVenueWebsite(venueDetails.getVenueWebsite());

            Venue updatedVenue = venueRepository.save(existingVenue);
            return ResponseEntity.ok(updatedVenue);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}") // DELETE: poista venue IDn perusteella
    public ResponseEntity<Void> deleteVenue(@PathVariable Long id) {
        if (venueRepository.existsById(id)) {
            venueRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
