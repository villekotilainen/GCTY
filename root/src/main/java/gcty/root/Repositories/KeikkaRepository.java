package gcty.root.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gcty.root.Entities.Keikka;
import gcty.root.Entities.Venue;
import gcty.root.Entities.Artisti;

import java.time.LocalDate;
import java.util.List;




@Repository
public interface KeikkaRepository extends JpaRepository<Keikka, Long> {

    List<Keikka> findByArtistit(List<Artisti> artistit);

    List<Keikka> findByVenue(Venue venue);

    List<Keikka> findByDate(LocalDate date);

    List<Keikka> findByStartTime(LocalDate startTime);
    
}
