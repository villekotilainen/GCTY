package gcty.root.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import gcty.root.Entities.Venue;




public interface VenueRepository extends JpaRepository<Venue, Long> {
    
    Venue findByVenueName(String venueName);

    Venue findByVenueAddress(String venueAddress);

    Venue findByVenueDescription(String venueDescription);

    Venue findByVenueWebsite(String venueWebsite);

}
